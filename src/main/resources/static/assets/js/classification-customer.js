/**
 * 
 */

function insert(){
	var nameClassificationCustomer = document.getElementById("name-classification-customer").value;
	var checkBoolean = true;
	if(nameClassificationCustomer === ''){
		document.getElementById("error").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error").style.display = "none";
	}
	return checkBoolean;
}


function update(){

	var nameClassificationCustomer = document.getElementById("name-classification-customer").value;
	var checkBoolean = true;
	if(nameClassificationCustomer === ''){
		document.getElementById("error").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error").style.display = "none";
	}
	return checkBoolean;
}

