package com.example.demo.dto;

import java.time.LocalDate;

public interface ContractAndInformationOfCustomer {

	Long getId_hop_dong();
	String getTen_hop_dong();
	String getSo_hop_dong();
	String getFile_dinh_kem();
	String getNguoi_ky_hop_dong();
	Long getId_khach_hang();
	Long getId_loai_hop_dong();
	LocalDate getNgay_ky();
	LocalDate getNgay_het_han();
	Long getTrang_thai();
	String getTen_khach_hang();
	String getMa_so_doanh_nghiep();
	String getTen_loai_hop_dong();
}
