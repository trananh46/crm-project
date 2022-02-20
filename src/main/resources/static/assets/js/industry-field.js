/**
 * 
 */

function insert(){
	var nameIndustryField = document.getElementById("name-industry-field").value;
	var checkBoolean = true;
	
	if(nameIndustryField === ''){
		document.getElementById("error").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error").style.display = "none";
	}
	return checkBoolean;
	
}


function checkUpdate(){
	var nameIndustryField = document.getElementById("name-industry-field").value;
	var checkBoolean = true;
	
	if(nameIndustryField === ''){
		document.getElementById("error").style.display = "block";
		checkBoolean = false;
	}else{
		document.getElementById("error").style.display = "none";
	}
	return checkBoolean;
}


function deleteIndustryField(){
	var notification = confirm("Bạn Có Muốn Xóa Lĩnh Vực Này ? - Khách Hàng Thuộc Lĩnh Vực Này Sẽ Không Bị Xóa ");
	
	if(notification == true){
		alert(" Đã Xóa Lĩnh Vực");
	}else{
		alert("Đã Hủy Xóa");
	}
	return notification;
	
}
