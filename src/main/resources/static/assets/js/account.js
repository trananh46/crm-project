/**
 * 
 */

function insert(){
	
	var checkBoolean = true;
	
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

	var password = document.getElementById("password").value;
	if(password === ''){
		document.getElementById("error-password").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-password").style.display = "none";
	}
	
	return checkBoolean;
}




function update(){
	
	var checkBoolean = true;
	
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

	var oldPassword = document.getElementById("old-password").value;
	if(oldPassword === ''){
		document.getElementById("error-old-password").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-old-password").style.display = "none";
	}
	
	var newPassword = document.getElementById("new-password").value;
	if(newPassword === ''){
		document.getElementById("error-new-password").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-new-password").style.display = "none";
	}
	
	if(!(newPassword === oldPassword)){
		document.getElementById("error-check-password").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error-check-password").style.display = "none";
	}
	
	return checkBoolean;
}