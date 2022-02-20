/**
 * 
 */

function checkInsert(){
	var nameMenu = document.getElementById("name-menu").value;
	var booleanCheck = true;
	if(nameMenu === ''){
		document.getElementById("error-name-menu").style.display = "block";
		booleanCheck = false;
	}else{
		document.getElementById("error-name-menu").style.display = "none";
	}
	return booleanCheck;
}


function checkUpdate(){
	var nameMenu = document.getElementById("name-menu").value;
	var booleanCheck = true;
	if(nameMenu === ''){
		document.getElementById("error-name-menu").style.display = "block";
		booleanCheck = false;
	}else{
		document.getElementById("error-name-menu").style.display = "none";
	}
	
	return booleanCheck;
}
