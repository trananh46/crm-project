function insert() {
	var nameDepartment = document.getElementById("name-department").value;
	var booleanCheck = true;
	if (nameDepartment==='') {
		document.getElementById("error").style.display = "block";
		booleanCheck = false;
	}else{
		document.getElementById("error").style.display = "none";
	} 
	return booleanCheck;
}


function confirmDelete(){
	
	if(confirm("Bạn Có Muốn Xóa Phòng Ban Và Các Nhân Viên Trong Phòng Ban") == true){
	
	}
	
	
}