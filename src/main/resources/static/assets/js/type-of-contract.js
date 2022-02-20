/**
 * 
 */


function insert(){
	var nameTypeOfContract = document.getElementById("name-type-of-contract").value;
	var checkBoolean = true;
	if(nameTypeOfContract === ''){
		document.getElementById("error").style.display = "block";
		return checkBoolean = false;
	}else{
		document.getElementById("error").style.display = "none";
	}
	return checkBoolean;
}

function update(){
	var nameTypeOfContract = document.getElementById("name-type-of-contract").value;
	var checkBoolean = true;
	if(nameTypeOfContract === ''){
		document.getElementById("error").style.display = "block";
		return checkBoolean = false;
	}else{
		document.getElementById("error").style.display = "none";
	} 
	return checkBoolean;
}


