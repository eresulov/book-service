var userFullNameElement = document.getElementById('user-full-name');
var userPhoneElement = document.getElementById('user-phone');
var API_URL = "http://localhost:8587";
var usernameElement = document.getElementById('username');
var passwordElement = document.getElementById('password');


var userExistsErrorAlertElement = document.getElementById('user-exists-error-alert');

var userCreatedAlertElement = document.getElementById('user-created-alert');



function onCreateAccount(event) {
    event.preventDefault();


    var userFullName = userFullNameElement.value;
    var userPhone = userPhoneElement.value;
    var username = usernameElement.value;
    var password = passwordElement.value;

    var http = new XMLHttpRequest();
    http.onload = function () {
        var response = this.responseText;
        var user = JSON.parse(response);
        if (user.username == "") {
            userExistsErrorAlertElement.innerHTML = 'Bu istifadəçi adı mövcuddur!';
            userExistsErrorAlertElement.style.display = 'block';
            setTimeout(() => {
                userExistsErrorAlertElement.style.display = 'none';
            }, 1200);
        } else {
            userCreatedAlertElement.innerHTML = 'İstifadəçi uğurla yaradıldı';

            userCreatedAlertElement.style.display = 'block';
            setTimeout(() => {
                userCreatedAlertElement.style.display = 'none';
            }, 1200);
        }

    }
    var userObject = {};
    userObject.username = username;
    userObject.password = password;
    userObject.name = userFullName;
    userObject.phone = userPhone;


    http.open("POST", API_URL + "/users", true);
    http.setRequestHeader("Content-Type", "application/json");
    http.send(JSON.stringify(userObject));





}