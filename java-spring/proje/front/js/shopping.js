var API_URL = "http://localhost:8587";
var token = localStorage.getItem('token');


var computerCategoriesElement = document.getElementById('computer-categories-div');
var computersElement = document.getElementById('computers-div');
var computersLoading = document.getElementById('computers-loading');
var basketComputerCount = document.getElementById('basket-computer-count');
var openBasketButton = document.getElementById('open-basket-button');
//var computerModalImage = document.getElementById('computer-modal-image');
var computerModalBrand = document.getElementById('computer-modal-brand');
var computerModalModel = document.getElementById('computer-modal-model');
var computerModalDescription = document.getElementById('computer-modal-description');
var computerModalPrice = document.getElementById('computer-modal-price');
var computerModalPhone = document.getElementById('computer-modal-phone');
var computerModalNew = document.getElementById('computer-modal-new');
var computerModalRam = document.getElementById('computer-modal-ram');
var computerModalCpu = document.getElementById('computer-modal-cpu');
var computerModalDrive = document.getElementById('computer-modal-drive');
var computerModalDriveType = document.getElementById('computer-modal-drive-type');
var computerModalOs = document.getElementById('computer-modal-os');
var computerModalVideoCard = document.getElementById('computer-modal-video-card');
var computerDetailsModal = document.getElementById('computer-details-modal');
var computerDetailsModalContent = document.getElementById('computer-details-modal-content');
var basketModalElement = document.getElementById('basket-modal');
var basketModalCloseButtonElement = document.getElementById('basket-modal-close-button');
var basketComputersTableBodyElement = document.getElementById('basket-computers-table-body');
var basketTotalPriceContentElement = document.getElementById('basket-total-price-content');

var users = [];
var categories = [];
var categoriesGlobal = [];
var computers = []; var computersGlobal = []; var computersSelectedGlobal = [];
var computersSelectedGlobalForSearch = [];

var basketComputers = [];
var currentSelectedCategoryId = 0;

function loadDataFromLocalStorage() {



	var http = new XMLHttpRequest();
	http.onload = function () {
		if (this.status == 200) {

			var computersSelected = JSON.parse(this.responseText);



			for (var i = 0; i < computersSelected.length; i++) {
				const c = computersSelected[i];
				const computerImagePath = API_URL + "/files/download/" +
					c.imagePath;

				computersElementHTML += "<div class='computer-card-container' >" +
					"<div class='computer-card' >" +
					"<div class='computer-image'    style='background-image:url(" + computerImagePath + ");'></div>" +
					"<div class='computer-data'><div class='computer-brand' title='" +
					c.brand + "'>" + c.brand + "</div>" +
					"<div class='computer-description' title='" +
					c.description + "'>" + c.description + "</div>" +
					"<div class='computer-price' title='" + c.price + " AZN'>" +
					c.price + " AZN</div>" +
					"<div class='computer-new'>" + (c.isNew ? 'Bəli' : 'Xeyr') + "</div>" +
					" " +
					"<div class='add-to-basket-div'><button class='btn btn-primary' " +
					"onclick='onComputerSelected(" +
					c.id + ")'>Ətraflı</button></div>" +
					"</div></div></div>";
			}
			computersElement.innerHTML = computersElementHTML;
		} else {

		}
	}
	http.open("GET", API_URL + "/computers/all", true);

	http.send();




}
loadDataFromLocalStorage();


function onComputerSelected(computerId) {
	computerDetailsModal.style.display = "block";
	var http = new XMLHttpRequest();
	http.onload = function () {
		if (this.status == 200) {
			let selectedComputer = JSON.parse(this.responseText);
			let selectedComputerImagePath = API_URL + "/files/download/" + selectedComputer.imagePath;

			computerModalImageContainer.style.backgroundImage = "url('" + selectedComputerImagePath + "')";
			computerModalBrand.innerHTML = selectedComputer.brand;
			computerModalModel.innerHTML = selectedComputer.model;
			computerModalDescription.innerHTML = selectedComputer.description;
			computerModalPrice.innerHTML = selectedComputer.price + " AZN";
			computerModalPhone.innerHTML = selectedComputer.user.phone;
			computerModalNew.innerHTML = (selectedComputer.isNew ? 'Bəli' : 'Xeyr');
			computerModalRam.innerHTML = selectedComputer.memory + " GB";
			computerModalCpu.innerHTML = selectedComputer.cpu;
			computerModalDrive.innerHTML = selectedComputer.driveMemory + " GB";



		} else {

		}
	}
	http.open("GET", API_URL + "/computers/shopping/" + computerId, true);

	http.send();
}

function showBasketComputerCount() {
	basketComputerCount.innerHTML = basketComputers.length;
}
window.addEventListener("click", function (event) {
	if (event.target === computerDetailsModal) {
		computerDetailsModal.style.display = 'none';
	}
});
function onOpenBasket() {
	if (basketComputers.length === 0) {
		showAlertMessage('Səbət boşdur', 1000);
	} else {
		basketModalElement.style.display = 'block';
		refreshComputersBasket();
		calculateBasketTotalPrice();
	}
}
basketModalCloseButtonElement.addEventListener("click", function () {
	closeBasket();
});

function calculateBasketTotalPrice() {
	var totalPrice = 0;
	for (let index = 0; index < basketComputers.length; index++) {
		const b = basketComputers[index];
		totalPrice += b.count * b.computer.price;
	}
	basketTotalPriceContentElement.innerHTML = totalPrice;
}
calculateBasketTotalPrice();
function computerCountChanged(countInput, computerId) {
	if (countInput.value == '' || countInput.value == '0') { countInput.value = "1"; }
	for (let index = 0; index < basketComputers.length; index++) {
		const b = basketComputers[index];
		if (b.computer.id === computerId) {
			b.count = Number(countInput.value);
			document.getElementById('computer-total-price-' + b.computer.id).innerHTML = "" + (b.count * b.computer.price) + " AZN";
			break;
		}
	}
	localStorage.setItem('basketComputers', JSON.stringify(basketComputers));
	calculateBasketTotalPrice();
}


var confirmOrderModalElement = document.getElementById('confirm-order-modal');
var confirmOrderModalCloseButtonElement = document.getElementById('confirm-order-modal-close-button');

confirmOrderModalCloseButtonElement.addEventListener("click", function () {
	closeConfirmOrder();
});



function checkCount(event) {

	var code = event.charCode;
	if (code >= 48 && code <= 57) {

	} else {

		event.returnValue = false;
	}

	if (Number(event.target.value + "" + event.key) > 10000) {
		event.target.value = "1";
		event.returnValue = false;
	}
	if (event.target.value === "0" && event.key === "0") { event.returnValue = false; }

}

var customerNameElement = document.getElementById("customer-name");
var customerAddressElement = document.getElementById("customer-address");
var customerPhoneElement = document.getElementById("customer-phone");
var customerEmailElement = document.getElementById("customer-email");
var customerOrderNoteElement = document.getElementById("customer-order-note");







function showAlertMessage(message, duration) {
	var messageElement = document.createElement('div');
	messageElement.innerHTML = message;
	messageElement.classList.add('alert-message');

	var fixedElements = document.getElementById('fixed-elements');
	fixedElements.appendChild(messageElement);
	messageElement.style.display = 'block';
	setTimeout(() => {
		messageElement.style.display = 'none';
		messageElement.remove();
	}, duration);
}



function onSearchInput(inputElement) {

}
function onSearchChange(inputElement) {



}

var computersElementHTML = "";


function onSearchKeyDown(event) {
	if (event.keyCode == 13) {
		begin = 0;
		allComputersLoaded = true;
		//allowScroll=true;
		computersElement.innerHTML = '';
		computersElement.style.display = 'none';
		computersLoading.style.display = 'block';
		setTimeout(function () {
			computersLoading.style.display = 'none';

			computersElementHTML = "";
			var searchValue = event.target.value.toLowerCase();
			searchValue = searchValue.trim();
			var findedComputers = [];
			// Əgər sadəcə cari seçilmiş kateqoriyada axtarış edilirsə
			//computersSelectedGlobal=computersSelectedGlobalForSearch.slice();

			// Əgər bütün komputerlərdə axtarış edilirsə
			computersSelectedGlobal = computers.slice();

			for (let index = 0; index < computersSelectedGlobal.length; index++) {
				const c = computersSelectedGlobal[index];
				if (c.name.toLowerCase().includes(searchValue)) {
					findedComputers.push(c);
				}
			}

			if (findedComputers.length <= length) { allComputersLoaded = true; } else {

			}
			console.log(findedComputers.length);
			computersSelectedGlobal = findedComputers.slice();
			findedComputers = findedComputers.slice(begin, length);
			console.log(findedComputers.length);
			addComputersToPage(findedComputers);
			computersElement.style.display = 'block';
			if (findedComputers.length == 0) { computersElement.innerHTML = "<h2 class='not-found'>Bu axtarışa uyğun heç bir komputer tapılmadı!</h2>"; }
			allComputersLoaded = false;
		}, 500);


	}
}

var computerModalImageContainer = document.getElementById('computer-modal-image-container');



// Kateqoriya axtarışı zamanı icra olunan metod
function searchCategory(searchInput) {
	var searchText = searchInput.value.trim();
	searchText = searchText.toLowerCase();
	categories = [];
	for (let index = 0; index < categoriesGlobal.length; index++) {
		const c = categoriesGlobal[index];
		if (c.name.toLowerCase().includes(searchText)) {
			categories.push(c);
		}
	}
	loadComputerCategories();
}

var allComputersLoaded = false;
var begin = 0;
var length = 25;
var allowScroll = false;
var computersLoadingNext = document.getElementById('computers-loading-next');



