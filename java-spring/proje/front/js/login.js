
var API_URL = "http://localhost:8587";


var usernameElement = document.getElementById('username');
var passwordElement = document.getElementById('password');
var loginErrorAlertElement = document.getElementById('login-error-alert');
var loginSuccessAlertElement = document.getElementById('login-success-alert');

function onLogin(event) {
    event.preventDefault();
    var username = usernameElement.value;
    var password = passwordElement.value;

    var token = "Basic " + window.btoa(username + ":" + password);

    var userLoggedIn = false;


    var http = new XMLHttpRequest();
    http.onload = function () {
        if (this.status == 200) {
            userLoggedIn = true;

            localStorage.setItem("logged-in-user-name", username);
            localStorage.setItem('token', token);

            if (userLoggedIn) {
                localStorage.setItem("show-success-login-message", '');

                loginSuccessAlertElement.innerHTML = 'Məlumatlar doğrudur';

                loginErrorAlertElement.style.display = 'none';
                loginSuccessAlertElement.style.display = 'block';
                setTimeout(() => {
                    window.location.href = "computers.html";
                }, 500);


            } else {

                localStorage.removeItem("logged-in-user-name");
                showLoginErrorMessage();
            }



        } else {
            alert("Məlumatlar səhvdir!!!");
        }
    }
    http.open("GET", API_URL + "/users/login", true);
    http.setRequestHeader("Authorization", token);
    http.send();





}

function showLoginErrorMessage() {
    loginErrorAlertElement.innerHTML = 'Məlumatlar doğru deyil';
    loginErrorAlertElement.style.display = 'block';
}