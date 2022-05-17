var computersTableBodyElement = document.getElementById('computers-table-body');
var editMode = false; var selectedComputerId = 0;

var API_URL = "http://localhost:8587";
var token = localStorage.getItem('token');



var mainContentElement = document.getElementById('main-content');

var loggedInUsername = localStorage.getItem("logged-in-user-name");
if (loggedInUsername == null) {

    window.location.href = 'index.html';
} else {

    mainContentElement.style.display = 'block';
}


var usersString = localStorage.getItem("users");
var users = JSON.parse(usersString);

function refreshComputers() {



    var http = new XMLHttpRequest();
    http.onload = function () {
        if (this.status == 200) {

            var computers = JSON.parse(this.responseText);

            computersTableBodyElement.innerHTML = '';
            var computersTableBodyElementHtml = '';
            for (let index = 0; index < computers.length; index++) {
                const computer = computers[index];
                const computerImagePath = API_URL + "/files/download/" +
                    computer.imagePath;

                computersTableBodyElementHtml += '<tr><td>' + computer.id;
                computersTableBodyElementHtml += '</td><td>' + computer.brand;
                computersTableBodyElementHtml += '</td><td><img class="computer-image" src="' +
                    computerImagePath;
                computersTableBodyElementHtml += '" onclick="onImageSelected(\'' + computerImagePath + '\')" /></td><td>' + computer.price;

                computersTableBodyElementHtml += ' AZN</td><td> <button class="btn btn-danger"' +
                    ' onclick="onDeleteComputer(' + computer.id + ')" >Sil</button>  ' +
                    '<button class="btn btn-primary" onclick="onEditComputer(' + computer.id +
                    ')">Redaktə</button>  ';
                computersTableBodyElementHtml += '</td></tr>';
            }
            computersTableBodyElement.innerHTML = computersTableBodyElementHtml;

        } else {

        }
    }
    http.open("GET", API_URL + "/computers", true);
    http.setRequestHeader("Authorization", token);
    http.send();



}
refreshComputers();






function onNewComputer() {
    editMode = false; selectedComputerId = 0;
    saveComputerModalElement.style.display = 'block';

    saveComputerHeaderMessage.innerHTML = 'Yeni';
}

var categories = [];
var categoriesString = localStorage.getItem("categories");

if (categoriesString == null) {

} else {
    categories = JSON.parse(categoriesString);
}



var saveComputerModalElement = document.getElementById('save-computer-modal');

var saveComputerModalCloseButtonElement = document.getElementById('save-computer-modal-close-button');
saveComputerModalCloseButtonElement.addEventListener('click', function () {
    saveComputerModalElement.style.display = 'none';
});

window.addEventListener('click', function (event) {
    if (event.target == saveComputerModalElement) {
        // saveComputerModalElement.style.display='none';
    }

    if (event.target == computerImageModalElement) {
        computerImageModalElement.style.display = 'none';
    }
});


var computerImageInputElement = document.getElementById('computer-image');

var computerNameElement = document.getElementById('computer-name');
var computerBrandElement = document.getElementById('computer-brand');
var computerModelElement = document.getElementById('computer-model');


var computerPriceElement = document.getElementById('computer-price');
var computerDescriptionElement = document.getElementById('computer-description');
var computerIsNewElement = document.getElementById('computer-new');
var computerRamElement = document.getElementById('computer-ram');
var computerCpuElement = document.getElementById('computer-cpu');
var computerDriveElement = document.getElementById('computer-drive');


var computerCategoryElementHtml = '';

for (let index = 0; index < categories.length; index++) {
    const c = categories[index];
    computerCategoryElementHtml += "<option value='" + c.id + "'>" + c.name + "</option>";
}



async function onSaveComputer(event) {
    event.preventDefault();




    let formData = new FormData();
    let photo = computerImageInputElement.files[0];

    formData.append("file", photo);
    let response = await fetch(API_URL + '/files/upload', {
        method: "POST",
        body: formData,
        headers: {
            "Authorization": token
        }
    });

    var photoName = await response.json();

    saveComputer(photoName.fileName);



}

function saveComputer(imageName) {

    var computer = {};

    computer.brand = computerBrandElement.value;
    computer.model = computerModelElement.value;
    computer.price = Number(computerPriceElement.value);
    computer.imagePath = imageName;
    computer.description = computerDescriptionElement.value;
    computer.isNew = computerIsNewElement.value == "true" ? true : false;
    computer.memory = Number(computerRamElement.value);
    computer.cpu = computerCpuElement.value;
    computer.driveMemory = Number(computerDriveElement.value);


    if (editMode) {
        // save computer
        computer.id = selectedComputerId;
        saveComputerMethod(computer);
        alert("Komputer uğurla redaktə olundu!");

    } else {
        // add computer
        saveComputerMethod(computer);
        alert("Komputer uğurla qeydiyyat olundu!");
    }






}


function saveComputerMethod(computer) {


    var http = new XMLHttpRequest();
    http.onload = function () {
        refreshComputers();
    }


    http.open("POST", API_URL + "/computers", true);
    http.setRequestHeader("Content-Type", "application/json");
    http.setRequestHeader("Authorization", token);
    http.send(JSON.stringify(computer));






}



function onDeleteComputer(computerId) {
    var result = confirm('Komputeri silməyə əminsiniz?');
    if (result) {


        var http = new XMLHttpRequest();
        http.onload = function () {
            if (this.status == 200) {
                refreshComputers();

            } else {

            }
        }
        http.open("DELETE", API_URL + "/computers/" + computerId, true);
        http.setRequestHeader("Authorization", token);
        http.send();



    } else {

    }
}





function onEditComputer(computerId) {
    editMode = true; selectedComputerId = computerId;
    saveComputerModalElement.style.display = 'block';
    saveComputerHeaderMessage.innerHTML = 'Redaktə';
    setTimeout(() => {




        var http = new XMLHttpRequest();
        http.onload = function () {
            if (this.status == 200) {
                let selectedComputer = JSON.parse(this.responseText);

                computerBrandElement.value = selectedComputer.brand;
                computerModelElement.value = selectedComputer.model;
                computerPriceElement.value = selectedComputer.price;
                computerDescriptionElement.value = selectedComputer.description;
                computerIsNewElement.value = selectedComputer.isNew;



                computerRamElement.value = selectedComputer.memory;
                computerCpuElement.value = selectedComputer.cpu;
                computerDriveElement.value = selectedComputer.driveMemory;


            } else {

            }
        }
        http.open("GET", API_URL + "/computers/" + computerId, true);
        http.setRequestHeader("Authorization", token);
        http.send();




    }, 500);


}

var saveComputerHeaderMessage = document.getElementById('save-computer-header-message');
var saveComputerModalForm = document.getElementById('save-computer-modal-form');


function resetComputerForm() {
    computerImageShowElement.style.display = 'none';
}



var computersTableBodyElementHtml = '';


var computersTableElement = document.getElementById('computers-table');
var computersLoading = document.getElementById('computers-loading');
function onSearchKeyDown(event) {
    if (event.keyCode == 13) {
        computersTableElement.style.display = 'none';
        computersLoading.style.display = 'block';
        computersTableBodyElement.innerHTML = '';
        computersTableBodyElementHtml = '';
        setTimeout(() => {
            computersTableElement.style.display = 'block';
            computersLoading.style.display = 'none';
            var searchValue = event.target.value.toLowerCase();
            searchValue = searchValue.trim();
            var findedComputers = [];

            for (let index = 0; index < computers.length; index++) {
                const c = computers[index];
                if (c.name.toLowerCase().includes(searchValue)) {
                    findedComputers.push(c);
                }
            }
            addComputersToPage(findedComputers);

        }, 500);



    }
}


console.log('computers.js end');


function onImageSelected(computerImagePath) {
    computerImageModalElement.style.display = 'block';
    computerModalImageShowElement.src = computerImagePath;
}

var computerImageModalElement = document.getElementById('computer-image-modal');
var computerModalImageShowElement = document.getElementById('computer-modal-image-show');