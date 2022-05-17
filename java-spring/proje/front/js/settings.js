
function onClearLocalStorage() {
	var result = confirm('Əminsiniz?');
	if (result) {
		localStorage.removeItem("users");
		localStorage.removeItem("categories");
		localStorage.removeItem("computers");
		localStorage.removeItem("basketComputers");
		localStorage.removeItem("orders");
		localStorage.removeItem("customers");
		localStorage.removeItem("order-customer");
		localStorage.removeItem("logged-in-user-id");
		localStorage.removeItem("logged-in-user-name");
		alert('Məlumatlar sıfırlandı');
	}

}

var totalStepMarkElement = document.getElementById('total-step-mark');
function calculateTotalStepMark() {
	var totalStepMark = 0;
	var stepMarkElements = document.getElementsByClassName('step-mark');
	for (let index = 0; index < stepMarkElements.length; index++) {
		const stepMarkElement = stepMarkElements[index];
		totalStepMark += Number(stepMarkElement.innerHTML);
	}
	//console.log(totalStepMark);
	totalStepMarkElement.innerHTML = totalStepMark;
}
calculateTotalStepMark();