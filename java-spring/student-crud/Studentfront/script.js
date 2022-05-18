var selectedStudentId = 0;
var API_URL = "http://localhost:8585"; //secilmis telebenin id sini bu deyisene memimsedirik
var studentNameInput = document.getElementById('student-name'); //bunu basda hecbir funksiyanin icinde olmamaqla elaqelendirdik harda lazimdirsa bu sekilde istifade edirik
var studentSurnameInput = document.getElementById('student-surname');

var studentsTbodyElement = document.getElementById('students-tbody');
var notesTbodyElement = document.getElementById('notes-tbody');

var token="Basic "+window.btoa("muellim-1:1");

var headerTextElement = document.getElementById('header-text');

var nameErrorElement = document.getElementById('name-error');
var surnameErrorElement = document.getElementById('surname-error');

var studentNoteInput = document.getElementById('student-note');

function onSaveStudent(event) {

    event.preventDefault(); //form un default gelen ozelliyini legv edirik form yenilemeli deyil mane olur 
    var studentName = studentNameInput.value // adini yazacagimiz inputu qaytarir
    var studentSurname = studentSurnameInput.value;

    var studentObject = {};
    studentObject.id = selectedStudentId; //secdiyimiz id update edir yeni telebe etmir daha 
    studentObject.name = studentName; // (name ) back end le ad eyni olmalidir
    studentObject.surname = studentSurname;

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
            selectedStudentId = 0; // redakte etdikden sonra yeniden 0 edirikki telebe qeydiyatina kecsin
            setHeaderText('Yeni Telebe Qeydiyyati ');
            loadAllStudents();
        }
    }

    http.open("POST", API_URL + "/students", true) //cagiracagimiz yer 
    http.setRequestHeader("Content-Type", "application/json")
    http.setRequestHeader("Authorization",token);
    http.send(JSON.stringify(studentObject)); // json un stringfy funksiyasi json a cevirir 

}

function loadAllStudents() {
    var http = new XMLHttpRequest();
    http.onload = function () {
        var response = this.responseText;
        var studentsArray = JSON.parse(response);
        fillStudentsTable(studentsArray); // bu funksiya massivi istifade ede bilsin icerisinde  patametr gonderirik
    }

    http.open("GET", API_URL + "/students", true)
    http.setRequestHeader("Authorization",token); //authorization header 
    http.send();
}

function fillStudentsTable(students) {
    var studentsTbodyHtml = "";
    for (var i = 0; i < students.length; i++) {
        var student = students[i];
        studentsTbodyHtml += "<tr><td>" + student.id + "</td>";
        studentsTbodyHtml += "<td>" + student.name + "</td>";
        studentsTbodyHtml += "<td>" + student.surname + "</td>";
        studentsTbodyHtml += "<td><button class='btn btn-danger' onclick='onDeleteStudent(" +
            student.id + ")'>Delete</button> ";
        studentsTbodyHtml += "<button class='btn btn-primary' onclick='onEditStudent(" +
            student.id + ")' >Update</button>  ";

        studentsTbodyHtml += "<button class='btn btn-warning' onclick='onShowStudentNotes(" +
            student.id + ")' type='button'  data-toggle='modal' data-target='#notesListModal' >Notes</button>  ";

        studentsTbodyHtml += "<button class='btn btn-secondary' onclick='onNoteStudent(" +
            student.id + ")' type='button'  data-toggle='modal' data-target='#noteModal'>Add Note</button></td></tr>";
    }
    studentsTbodyElement.innerHTML = studentsTbodyHtml;
    
    $(document).ready(function () {
      
   $('#students-table').DataTable({
       
   });
});
}
loadAllStudents();

function onDeleteStudent(studentId) {
    if (confirm('Silmeye eminsen?')) {


        var http = new XMLHttpRequest();
        http.onload = function () {
            loadAllStudents(); // birce defe sehifeni yenilemek ucundur 
        }

        http.open("DELETE", API_URL + "/students/" + studentId, true)
        http.setRequestHeader("Authorization",token);
        http.send();
    }
}

function onEditStudent(studentId) {
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
    http.setRequestHeader("Authorization",token);
    http.send();
    
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
    http.setRequestHeader("Authorization",token);

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
    http.setRequestHeader("Authorization",token);
    http.send();
}