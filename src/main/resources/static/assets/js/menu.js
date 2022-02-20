/**
 * 
 */


function confirmDeleteMenuParent() {

	var notification = confirm("Bạn Có Muốn Xóa Menu Chính Không ? - Các Menu Phụ Sẽ Bị Xóa Theo");
	if (notification == true) {
		alert("Đã Xóa Menu Chính Và Các Menu Phụ")
	} else {
		alert("Đã Hủy Xóa")
	}
	return notification;
}
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

