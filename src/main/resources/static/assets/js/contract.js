/**
 * 
 */

function insert() {
	var today = new Date();
	var currentDate = new Date().toISOString().slice(0, 10);
	var checkBoolean = true;

	var nameContract = document.getElementById("nameContract").value;
	if (nameContract === '') {
		document.getElementById("error-name-contract").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-name-contract").style.display = "none";
	}


	var regexNameCustomer = /^[^\d+]*[\d+]{0}[^\d+]*$/;
	if (!regexNameCustomer.test(nameContract)) {
		document.getElementById("error-regex-name-contract").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-regex-name-contract").style.display = "none";
	}


	var contractNumber = document.getElementById("contractNumber").value;
	if (contractNumber === '') {
		document.getElementById("error-contract-number").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-contract-number").style.display = "none";
	}

	var signedContractByPerson = document.getElementById("signedContractByPerson").value;
	if (signedContractByPerson === '') {
		document.getElementById("error-signed-contract-by-person").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-signed-contract-by-person").style.display = "none";
	}

	var customer = document.getElementById("customer").value;
	if (customer === '') {
		document.getElementById("error-customer").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-customer").style.display = "none";
	}

	var typeOfContracts = document.getElementById("typeOfContracts").value;
	if (typeOfContracts === '') {
		document.getElementById("error-typeOfContracts").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-typeOfContracts").style.display = "none";
	}

	var signedDate = document.getElementById("signedDate").value;
	if (signedDate === '') {
		document.getElementById("error-registrationDate").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-registrationDate").style.display = "none";
	}

	
	if(signedDate > currentDate){
		document.getElementById("check-registrationDate").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("check-registrationDate").style.display = "none";
	}
	
	
	
	var expiredDate = document.getElementById("expiredDate").value;
	if (expiredDate === '') {
		document.getElementById("error-expired-date").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-expired-date").style.display = "none";
	}

	
	if(expiredDate > currentDate){
		document.getElementById("check-expired-date").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("check-expired-date").style.display = "none";
	}
	
	return checkBoolean;
}


function update() {
	var today = new Date();
	var currentDate = new Date().toISOString().slice(0, 10);
	var checkBoolean = true;

	var nameContract = document.getElementById("nameContract").value;
	if (nameContract === '') {
		document.getElementById("error-name-contract").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-name-contract").style.display = "none";
	}


	var regexNameCustomer = /^[^\d+]*[\d+]{0}[^\d+]*$/;
	if (!regexNameCustomer.test(nameContract)) {
		document.getElementById("error-regex-name-contract").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-regex-name-contract").style.display = "none";
	}


	var contractNumber = document.getElementById("contractNumber").value;
	if (contractNumber === '') {
		document.getElementById("error-contract-number").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-contract-number").style.display = "none";
	}

	var signedContractByPerson = document.getElementById("signedContractByPerson").value;
	if (signedContractByPerson === '') {
		document.getElementById("error-signed-contract-by-person").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-signed-contract-by-person").style.display = "none";
	}

	var customer = document.getElementById("customer").value;
	if (customer === '') {
		document.getElementById("error-customer").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-customer").style.display = "none";
	}

	var typeOfContracts = document.getElementById("typeOfContracts").value;
	if (typeOfContracts === '') {
		document.getElementById("error-typeOfContracts").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-typeOfContracts").style.display = "none";
	}

	var signedDate = document.getElementById("signedDate").value;
	if (signedDate === '') {
		document.getElementById("error-registrationDate").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-registrationDate").style.display = "none";
	}

	
	if(signedDate > currentDate){
		document.getElementById("check-registrationDate").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("check-registrationDate").style.display = "none";
	}
	
	
	
	var expiredDate = document.getElementById("expiredDate").value;
	if (expiredDate === '') {
		document.getElementById("error-expired-date").style.display = "block";
		return checkBoolean = false;
	} else {
		document.getElementById("error-expired-date").style.display = "none";
	}

	
	if(expiredDate > currentDate){
		document.getElementById("check-expired-date").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("check-expired-date").style.display = "none";
	}
	
	
	
	return checkBoolean;
	
}
