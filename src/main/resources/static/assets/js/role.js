/**
 * 
 */

function insert(){
	var checkBoolean = true;
	
	var nameRole = document.getElementById("nameRole").value;
	if(nameRole === ''){
		document.getElementById("error-nameRole").style.display = "block";
		return checkBoolean = false;
	}else{
		document.getElementById("error-nameRole").style.display = "none";
	}
	
	var codeRole = document.getElementById("codeRole").value;
	if(codeRole === ''){
		document.getElementById("error-codeRole").style.display = "block";
		return checkBoolean = false;
	}else{
		document.getElementById("error-codeRole").style.display = "none";
	}
	
	return checkBoolean;
}


function update(){
	var checkBoolean = true;
	
	var nameRole = document.getElementById("nameRole").value;
	if(nameRole === ''){
		document.getElementById("error-nameRole").style.display = "block";
		return checkBoolean = false;
	}else{
		document.getElementById("error-nameRole").style.display = "none";
	}
	
	var codeRole = document.getElementById("codeRole").value;
	if(codeRole === ''){
		document.getElementById("error-codeRole").style.display = "block";
		return checkBoolean = false;
	}else{
		document.getElementById("error-codeRole").style.display = "none";
	}
	
	return checkBoolean;
}