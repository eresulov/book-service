var selectedStudentId = 0;

var API_URL = "http://localhost:8585"; //secilmis telebenin id sini bu deyisene memimsedirik
var username = localStorage.getItem('username');
var password = localStorage.getItem('password');
var token = "Basic " + window.btoa(username + ":" + password);

var gridOptionsGlobal;

var studentNameInput = document.getElementById('student-name'); //bunu basda hecbir funksiyanin icinde olmamaqla elaqelendirdik harda lazimdirsa bu sekilde istifade edirik
var studentSurnameInput = document.getElementById('student-surname');
var studentProfilePhotoInput = document.getElementById('student-photo');

var studentsTbodyElement = document.getElementById('students-tbody');
var notesTbodyElement = document.getElementById('notes-tbody');

var headerTextElement = document.getElementById('header-text');

var nameErrorElement = document.getElementById('name-error');
var surnameErrorElement = document.getElementById('surname-error');

var studentNoteInput = document.getElementById('student-note');

async function onSaveStudent(event) {

    event.preventDefault(); //form un default gelen ozelliyini legv edirik form yenilemeli deyil mane olur 

    let formData = new FormData();
    let photo = studentProfilePhotoInput.files[0];

    formData.append("file", photo);
    let response = await fetch(API_URL + '/files/upload', {
        method: "POST",
        body: formData,
        headers: {
            "Authorization": token
        }
    });

    var photoName = await response.json(); //server nevaxt cavab verir onda ise dusur 

    saveStudent(photoName.fileName);

}

function loadAllStudents() {
    var http = new XMLHttpRequest();
    http.onload = function () {
        var response = this.responseText;
        var studentsArray = JSON.parse(response);
        fillStudentsTable(studentsArray); // bu funksiya massivi istifade ede bilsin icerisinde  patametr gonderirik
    }

    http.open("GET", API_URL + "/students", true)
    http.setRequestHeader("Authorization", token); //authorization header 
    http.send();
}

function fillStudentsTable(students) {
    gridOptionsGlobal.api.setRowData(students); //bos olan mekumati doldurur row un ici
}


function onDeleteStudent() {
    var selectedStudents = gridOptionsGlobal.api.getSelectedRows();
    if (selectedStudents.length > 0) {


        if (confirm('Silmeye eminsen?')) {
            var studentId = selectedStudents[0].id; //siyahidan secilen telebelerin obyektini qaytarir Massiv
            var http = new XMLHttpRequest();
            http.onload = function () {
                loadAllStudents(); // birce defe sehifeni yenilemek ucundur 
            }

            http.open("DELETE", API_URL + "/students/" + studentId, true)
            http.setRequestHeader("Authorization", token);
            http.send();
        }
    } else
        alert('Siyahidan silmek istediyinizi secin!');
}

function onEditStudent() {
    var selectedStudents = gridOptionsGlobal.api.getSelectedRows();
    if (selectedStudents.length==1) {
        var studentId=selectedStudents[0].id;
    selectedStudentId = studentId;
    setHeaderText('Telebe Redaqtesi id si -> ' + studentId);
    var http = new XMLHttpRequest();
    http.onload = function () {
        var response = this.responseText; //butun srvisleri cagiranda json gelirse hemise bucur olur ve parse etmeliyik js ya
        var studentObject = JSON.parse(response)
        studentNameInput.value = studentObject.name; // serverden gelen name i yerlesdiririk id si studetn name olan inputun daxiline 
        studentSurnameInput.value = studentObject.surname;
    }

    http.open("GET", API_URL + "/students/" + studentId, true) // id sine gore melumati qaytaracaq
    http.setRequestHeader("Authorization", token);
    http.send();
    }
}

function setHeaderText(text) {
    headerTextElement.innerHTML = text;
}
setHeaderText('Yeni Telebe Qeydiyyati ');

function clearErrorMessages() {
    nameErrorElement.innerHTML = ""; //error yoxdursa error mesajlarini temizleyirik
    surnameErrorElement.innerHTML = "";
}

function onNoteStudent(studentId) {
    selectedStudentId = studentId;

}


function onSaveStudentNote(event) {

    event.preventDefault(); //form un default gelen ozelliyini legv edirik form yenilemeli deyil mane olur 
    var studentNote = studentNoteInput.value // bu inputdan goturub server e gonderir


    var studentNoteObject = {};

    studentNoteObject.note = studentNote; // server e gondermekcun hazirliyiriq
    studentNoteObject.studentId = selectedStudentId;

    var http = new XMLHttpRequest(); //ajax request sinifinnen obyekt yaradiriq

    http.onload = function () {
        //bazada olan butun telebeleri cedvele yuklemek
        //servere e melumat gonderirik serverden cavab gelende yoxlayiriq ki eger kod 400 durse 
        if (this.status == 400) {
            alert('Qeyd elave edile bilmedi!');
        } else {
            alert('Qeyd elave edildi');
        }
    }

    http.open("POST", API_URL + "/student-notes", true) //metodun tipi , cagiracagimiz yer 
    http.setRequestHeader("Content-Type", "application/json")
    http.setRequestHeader("Authorization", token);

    http.send(JSON.stringify(studentNoteObject)); // json un stringfy funksiyasi json a cevirir 

}

function onShowStudentNotes(studentId) {
    loadAllStudentNotes(studentId);
}

function fillStudentNotesTable(notes) {

    var notesTbodyHtml = "";
    for (var i = 0; i < notes.length; i++) {
        var note = notes[i];
        notesTbodyHtml += "<tr><td>" + note.id + "</td>";
        notesTbodyHtml += "<td>" + note.note + "</td>";
        notesTbodyHtml += "</tr>";
    }
    notesTbodyElement.innerHTML = notesTbodyHtml; //tbody ni icerisini tr lerle doldurur
}

function loadAllStudentNotes(studentId) {
    var http = new XMLHttpRequest();
    http.onload = function () {
        var response = this.responseText;
        var notesArray = JSON.parse(response);
        fillStudentNotesTable(notesArray); // bu funksiya massivi istifade ede bilsin icerisinde  patametr gonderirik
    }

    http.open("GET", API_URL + "/student-notes/student/" + studentId, true)
    http.setRequestHeader("Authorization", token);
    http.send();
}

function prepareAgGridTable() {
    const columnDefs = [ //sutunlar teyin edilir
        {
            field: "id",
            headerName: "Kod"
        },
        {
            field: "name",
            headerName: "Ad"
        },
        {
            field: "surname",
            headerName: "Soyad"
        }
    ];


    const gridOptions = {
        columnDefs: columnDefs,
        rowData: [],
        defaultColDef: {
            sortable: true,
            filter: true
        }, //sortlasdirir 
        animateRows: true, //animasiyali sort
        floatingFilter: true,
        pagination: true, //hisse hisse verir page lere bolur
        rowSelection: 'multiple'
    }; //ayarlari sazlanir ag-grid in 

    gridOptionsGlobal = gridOptions; //grid options bu funksiyada local oldugu ucun globalda grid option deyiseni yaratmaliyiq

    //serverden html sehifesi yuklenende bu kod calisir myStudents e ag grid sazlanir
    document.addEventListener('DOMContentLoaded', () => {
        const gridDiv = document.querySelector('#myStudents');
        new agGrid.Grid(gridDiv, gridOptions);
    });
}
prepareAgGridTable();
loadAllStudents();

function saveStudent(photo) {
    var studentName = studentNameInput.value // adini yazacagimiz inputu qaytarir
    var studentSurname = studentSurnameInput.value;

    var studentObject = {};
    studentObject.id = selectedStudentId; //secdiyimiz id update edir yeni telebe etmir daha 
    studentObject.name = studentName; // (name ) back end le ad eyni olmalidir
    studentObject.surname = studentSurname;
    studentObject.profilePhoto = photo;
    var http = new XMLHttpRequest(); //ajax request sinifinnen obyekt yaradiriq

    http.onload = function () {
        //bazada olan butun telebeleri cedvele yuklemek
        //servere e melumat gonderirik serverden cavab gelende yoxlayiriq ki eger kod 400 durse 
        if (this.status == 400) {
            var nameError = "";
            var surnameError = "";
            var erroObject = JSON.parse(this.responseText); //js formatina ceviririkk
            erroObject.validations.forEach(error => {
                if (error.field == 'name') { //eger field name dirse demeli name ein errorudur

                    nameError += error.message + "<br>";
                }
                if (error.field == 'surname') {
                    surnameError += error.message + "<br>";
                }
            });
            nameErrorElement.innerHTML = nameError; //id si name-error dursa
            surnameErrorElement.innerHTML = surnameError;
        } else {
            clearErrorMessages();
            gridOptionsGlobal.api.getSelectedRows();
            selectedStudentId = 0; // redakte etdikden sonra yeniden 0 edirikki telebe qeydiyatina kecsin
            setHeaderText('Yeni Telebe Qeydiyyati ');
            loadAllStudents();
        }
    }
    http.open("POST", API_URL + "/students", true) //cagiracagimiz yer 
    http.setRequestHeader("Content-Type", "application/json")
    http.setRequestHeader("Authorization", token);
    http.send(JSON.stringify(studentObject)); // json un stringfy funksiyasi json a cevirir 
}


function onShowImage() {
    var selectedStudents = gridOptionsGlobal.api.getSelectedRows(); //ag-gridden secilen setrleri obyekt sekilde qaytarir
    console.log(selectedStudents[0]);

    document.getElementById('student-image').src = API_URL + "/files/download/" + selectedStudents[0].profilePhoto;
}