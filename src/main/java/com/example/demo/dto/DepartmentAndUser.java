package com.example.demo.dto;

import java.time.LocalDate;

public interface DepartmentAndUser {

	Long getId_user();
	
	String getTen_user();
	
	String getSdt();
	
	String getEmail();
	
	Long getId_tai_khoan();
	
	Long getId_phong_ban();
	
	LocalDate getNgay_vao_cong_ty();
	
	LocalDate getSinh_nhat();
	
	String getCan_cuoc_cong_dan();
	
	Long getTrang_thai();
	
	String getTen_phong_ban();
	
	
}
