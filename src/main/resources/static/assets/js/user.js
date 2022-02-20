/**
 * 
 */

function insert(){
	
	var today = new Date();
	var currentDate = new Date().toISOString().slice(0, 10);
	var checkBoolean = true;
	
	var nameUser = document.getElementById("nameUser").value;
	if(nameUser === ''){
		document.getElementById("error-nameUser").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-nameUser").style.display = "none";
	}
	
	
	var regexNameCustomer = /^[^\d+]*[\d+]{0}[^\d+]*$/;
	if(!regexNameCustomer.test(nameUser)){
		document.getElementById("error-regex-nameUser").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-regex-nameUser").style.display = "none";
	}
	
	var identification = document.getElementById("identification").value;
	if(identification === ''){
		document.getElementById("error-identification").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-identification").style.display = "none";
	}
	
	var birthday = document.getElementById("birthday").value;
	if(birthday === ''){
		document.getElementById("error-birthday").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-birthday").style.display = "none";
	}
	
	
	if(birthday > currentDate){
		document.getElementById("error-check-birthday").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-check-birthday").style.display = "none";
	}
	
	
	
	var dateEnterCompany = document.getElementById("dateEnterCompany").value;
	if(dateEnterCompany === ''){
		document.getElementById("error-dateEnterCompany").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-dateEnterCompany").style.display = "none";
	}
	
	
	if(dateEnterCompany > currentDate){
		document.getElementById("error-check-dateEnterCompany").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-check-dateEnterCompany").style.display = "none";
	}
	
	
	var phoneNumber = document.getElementById("phoneNumber").value;
	if(phoneNumber === ''){
		document.getElementById("error-phoneNumber").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-phoneNumber").style.display = "none";
	}
	
	var regexPhoneNumber = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;
	
	if(!regexPhoneNumber.test(phoneNumber)){
		document.getElementById("error-check-phoneNumber").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-check-phoneNumber").style.display = "none";
	}
	
	
	var email = document.getElementById("email").value;
	if(email === ''){
		document.getElementById("error-email").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-email").style.display = "none";
	}
	
	
	var regexEmail = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(!regexEmail.test(email)){
		document.getElementById("error-regex-email").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-regex-email").style.display = "none";
	}
	
	
	var department = document.getElementById("department").value;
	if(department === ''){
		document.getElementById("error-department").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-department").style.display = "none";
	}
	
	return checkBoolean;
}

function update(){
	
	var today = new Date();
	var currentDate = new Date().toISOString().slice(0, 10);
	var checkBoolean = true;
	
	var nameUser = document.getElementById("nameUser").value;
	if(nameUser === ''){
		document.getElementById("error-nameUser").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-nameUser").style.display = "none";
	}
	
	
	var regexNameCustomer = /^[^\d+]*[\d+]{0}[^\d+]*$/;
	if(!regexNameCustomer.test(nameUser)){
		document.getElementById("error-regex-nameUser").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-regex-nameUser").style.display = "none";
	}
	
	var identification = document.getElementById("identification").value;
	if(identification === ''){
		document.getElementById("error-identification").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-identification").style.display = "none";
	}
	
	var birthday = document.getElementById("birthday").value;
	if(birthday === ''){
		document.getElementById("error-birthday").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-birthday").style.display = "none";
	}
	
	
	if(birthday > currentDate){
		document.getElementById("error-check-birthday").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-check-birthday").style.display = "none";
	}
	
	
	
	var dateEnterCompany = document.getElementById("dateEnterCompany").value;
	if(dateEnterCompany === ''){
		document.getElementById("error-dateEnterCompany").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-dateEnterCompany").style.display = "none";
	}
	
	
	if(dateEnterCompany > currentDate){
		document.getElementById("error-check-dateEnterCompany").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-check-dateEnterCompany").style.display = "none";
	}
	
	
	var phoneNumber = document.getElementById("phoneNumber").value;
	if(phoneNumber === ''){
		document.getElementById("error-phoneNumber").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-phoneNumber").style.display = "none";
	}
	
	var regexPhoneNumber = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;
	
	if(!regexPhoneNumber.test(phoneNumber)){
		document.getElementById("error-check-phoneNumber").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-check-phoneNumber").style.display = "none";
	}
	
	
	var email = document.getElementById("email").value;
	if(email === ''){
		document.getElementById("error-email").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-email").style.display = "none";
	}
	
	
	var regexEmail = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if(!regexEmail.test(email)){
		document.getElementById("error-regex-email").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-regex-email").style.display = "none";
	}
	
	
	var department = document.getElementById("department").value;
	if(department === ''){
		document.getElementById("error-department").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-department").style.display = "none";
	}
	
	
	
	return checkBoolean;
}