/**
 * 
 */

function insert() {

	var today = new Date(); 
	var currentDate = new Date().toISOString().slice(0, 10);
	var checkBoolean = true;

	var nameCustomer = document.getElementById("name-customer").value;
	if (nameCustomer === '') {
		document.getElementById("error-name-customer").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-name-customer").style.display = "none";
	}

	var regexNameCustomer = /^[^\d+]*[\d+]{0}[^\d+]*$/;
	if (!regexNameCustomer.test(nameCustomer)) {
		document.getElementById("error-regex-name-customer").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-regex-name-customer").style.display = "none";
	}


	var address = document.getElementById("address").value;
	if (address === '') {
		document.getElementById("error-address").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-address").style.display = "none";
	}


	var email = document.getElementById("email").value;
	if (email === '') {
		document.getElementById("error-email").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-email").style.display = "none";
	}

	var regexEmail = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if (!regexEmail.test(email)) {
		document.getElementById("error-regex-email").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-regex-email").style.display = "none";
	}

	var taxIdentificationNumber = document.getElementById("taxIdentificationNumber").value;
	if (taxIdentificationNumber === '') {
		document.getElementById("error-taxIdentificationNumber").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-taxIdentificationNumber").style.display = "none";
	}


	var enterpriseIdentificationNumber = document.getElementById("enterpriseIdentificationNumber").value;
	if (enterpriseIdentificationNumber === '') {
		document.getElementById("error-enterpriseIdentificationNumber").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-enterpriseIdentificationNumber").style.display = "none";
	}

	var classificationCustomer = document.getElementById("classificationCustomer").value;
	if (classificationCustomer === '') {
		document.getElementById("error-classificationCustomer").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-classificationCustomer").style.display = "none";
	}


	var industryField = document.getElementById("industryField").value;
	if (industryField === '') {
		document.getElementById("error-industryField").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-industryField").style.display = "none";
	}

	var registrationDate = document.getElementById("registrationDate").value;
	if (registrationDate === '') {
		document.getElementById("error-registrationDate").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-registrationDate").style.display = "none";
	}


	if (registrationDate > currentDate) {
		document.getElementById("check-registrationDate").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("check-registrationDate").style.display = "none";
	}



	var phoneNumber = document.getElementById("phoneNumber").value;
	if (phoneNumber === '') {
		document.getElementById("error-phoneNumber").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-phoneNumber").style.display = "none";
	}

	var regexPhoneNumber = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;

	if (!regexPhoneNumber.test(phoneNumber)) {
		document.getElementById("error-check-phoneNumber").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-check-phoneNumber").style.display = "none";
	}


	var idCustomerStatus = document.getElementById("idCustomerStatus").value;
	if (idCustomerStatus === '') {
		document.getElementById("error-idCustomerStatus").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-idCustomerStatus").style.display = "none";
	}


	var companyScale = document.getElementById("companyScale").value;
	if (companyScale === '') {
		document.getElementById("error-companyScale").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-companyScale").style.display = "none";
	}
	

	return checkBoolean;
}


function update() {

	var today = new Date(); 
	var currentDate = new Date().toISOString().slice(0, 10);
	var checkBoolean = true;

	var nameCustomer = document.getElementById("name-customer").value;
	if (nameCustomer === '') {
		document.getElementById("error-name-customer").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-name-customer").style.display = "none";
	}

	var regexNameCustomer = /^[^\d+]*[\d+]{0}[^\d+]*$/;
	if (!regexNameCustomer.test(nameCustomer)) {
		document.getElementById("error-regex-name-customer").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-regex-name-customer").style.display = "none";
	}


	var address = document.getElementById("address").value;
	if (address === '') {
		document.getElementById("error-address").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-address").style.display = "none";
	}


	var email = document.getElementById("email").value;
	if (email === '') {
		document.getElementById("error-email").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-email").style.display = "none";
	}

	var regexEmail = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if (!regexEmail.test(email)) {
		document.getElementById("error-regex-email").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-regex-email").style.display = "none";
	}

	var taxIdentificationNumber = document.getElementById("taxIdentificationNumber").value;
	if (taxIdentificationNumber === '') {
		document.getElementById("error-taxIdentificationNumber").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-taxIdentificationNumber").style.display = "none";
	}


	var enterpriseIdentificationNumber = document.getElementById("enterpriseIdentificationNumber").value;
	if (enterpriseIdentificationNumber === '') {
		document.getElementById("error-enterpriseIdentificationNumber").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-enterpriseIdentificationNumber").style.display = "none";
	}

	var classificationCustomer = document.getElementById("classificationCustomer").value;
	if (classificationCustomer === '') {
		document.getElementById("error-classificationCustomer").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-classificationCustomer").style.display = "none";
	}


	var industryField = document.getElementById("industryField").value;
	if (industryField === '') {
		document.getElementById("error-industryField").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-industryField").style.display = "none";
	}

	var registrationDate = document.getElementById("registrationDate").value;
	if (registrationDate === '') {
		document.getElementById("error-registrationDate").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-registrationDate").style.display = "none";
	}


	if (registrationDate > currentDate) {
		document.getElementById("check-registrationDate").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("check-registrationDate").style.display = "none";
	}



	var phoneNumber = document.getElementById("phoneNumber").value;
	if (phoneNumber === '') {
		document.getElementById("error-phoneNumber").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-phoneNumber").style.display = "none";
	}

	var regexPhoneNumber = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;

	if (!regexPhoneNumber.test(phoneNumber)) {
		document.getElementById("error-check-phoneNumber").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-check-phoneNumber").style.display = "none";
	}


	var idCustomerStatus = document.getElementById("idCustomerStatus").value;
	if (idCustomerStatus === '') {
		document.getElementById("error-idCustomerStatus").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-idCustomerStatus").style.display = "none";
	}


	var companyScale = document.getElementById("companyScale").value;
	if (companyScale === '') {
		document.getElementById("error-companyScale").style.display = "block";
		checkBoolean = false;
	} else {
		document.getElementById("error-companyScale").style.display = "none";
	}
	

	return checkBoolean;
}