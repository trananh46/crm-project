package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="linh_vuc")
public class IndustryField {

	@Id
	@Column(name="id_linh_vuc")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIndustryField;
	
	@Column(name="ten_linh_vuc")
	private String nameIndustryField;

	@Column(name="trang_thai")
	private Long status;

	public Long getIdIndustryField() {
		return idIndustryField;
	}

	public void setIdIndustryField(Long idIndustryField) {
		this.idIndustryField = idIndustryField;
	}

	public String getNameIndustryField() {
		return nameIndustryField;
	}

	public void setNameIndustryField(String nameIndustryField) {
		this.nameIndustryField = nameIndustryField;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public IndustryField(Long idIndustryField, String nameIndustryField, Long status) {
		super();
		this.idIndustryField = idIndustryField;
		this.nameIndustryField = nameIndustryField;
		this.status = status;
	}
	
	public IndustryField() {
		
	}
	@OneToMany(mappedBy = "industryField")
	List<Customer> customers;
}
