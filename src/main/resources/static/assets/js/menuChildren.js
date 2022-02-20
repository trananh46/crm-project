/**
 * 
 */

function checkInsert(){
	var nameMenu = document.getElementById("name-menu").value;
	var url = document.getElementById("url").value;
	
	var booleanCheck = true;
	if(nameMenu === ''){
		document.getElementById("error-name-menu").style.display = "block";
		booleanCheck = false;
	}else{
		document.getElementById("error-name-menu").style.display = "none";
	}
	
	
	if(url === ''){
		document.getElementById("error-url-menu").style.display = "block";
		booleanCheck = false;
	}else{
		document.getElementById("error-url-menu").style.display = "none";
	}
	
	return booleanCheck;
}


function confirmDelete(){
	var notification = confirm("Bạn Có Muốn Xóa Menu Phụ Không ?");
	
	if(notification == true){
		alert("Đã Xóa Menu Phụ");
	}else{
		alert("Đã Hủy Xóa");
	}
	return notification;
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