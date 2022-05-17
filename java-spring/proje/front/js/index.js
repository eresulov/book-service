
var myComputersButton = document.getElementById('my-computers-button');

var shoppingButton = document.getElementById('shopping-button');
var loginButton = document.getElementById('login-button');
var logoutButton = document.getElementById('logout-button');
myComputersButton.addEventListener('click', function () { window.location.href = "computers.html"; });
shoppingButton.addEventListener('click', function () {
	window.location.href = "shopping.html";
});
var userLoggedIn = false;

var loggedInUsername = localStorage.getItem("logged-in-user-name");
if (loggedInUsername == null) {
	userLoggedIn = false;
} else {
	userLoggedIn = true;
}
var showSuccessLoginMessage = localStorage.getItem('show-success-login-message');
if (showSuccessLoginMessage == null) {

} else {
	document.getElementById('success-login-alert').style.display = 'block';
	localStorage.removeItem('show-success-login-message');
	setTimeout(() => {
		document.getElementById('success-login-alert').style.display = 'none';

	}, 1200);
}
function showButtons() {
	if (userLoggedIn) {
		loginButton.style.display = 'none';
		myComputersButton.style.display = 'inline-block';

		logoutButton.style.display = 'inline-block';

	} else {
		logoutButton.style.display = 'none';
		myComputersButton.style.display = 'none';

		loginButton.style.display = 'inline-block';
	}
}
showButtons();
function onLogin() {
	window.location.href = "login.html";
}
function onLogout() {

	setTimeout(() => {
		userLoggedIn = false;

		localStorage.removeItem("logged-in-user-name");
		localStorage.removeItem("token");
		showButtons();
		document.getElementById('success-logout-alert').style.display = 'block';
		showUsername();
		setTimeout(() => {
			document.getElementById('success-logout-alert').style.display = 'none';
		}, 1200);
	}, 500);


}
var users = [];

var computers = [];











var loggedInUserName = document.getElementById('logged-in-user-name');

function showUsername() {
	if (userLoggedIn) {

		loggedInUserName.innerHTML = localStorage.getItem('logged-in-user-name');

	} else {
		loggedInUserName.innerHTML = '';

	}
}
showUsername();