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
@Table(name = "phan_loai_khach_hang")
public class ClassificationCustomer {

	@Id
	@Column(name = "id_phan_loai_khach_hang")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClassificationCustomer;

	@Column(name = "ten_phan_loai_khach_hang")
	private String nameClassificationCustomer;

	@Column(name = "trang_thai")
	private Long status;

	public Long getIdClassificationCustomer() {
		return idClassificationCustomer;
	}

	public void setIdClassificationCustomer(Long idClassificationCustomer) {
		this.idClassificationCustomer = idClassificationCustomer;
	}

	public String getNameClassificationCustomer() {
		return nameClassificationCustomer;
	}

	public void setNameClassificationCustomer(String nameClassificationCustomer) {
		this.nameClassificationCustomer = nameClassificationCustomer;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public ClassificationCustomer(Long idClassificationCustomer, String nameClassificationCustomer, Long status) {
		super();
		this.idClassificationCustomer = idClassificationCustomer;
		this.nameClassificationCustomer = nameClassificationCustomer;
		this.status = status;
	}

	public ClassificationCustomer() {

	}

	@OneToMany(mappedBy = "classificationCustomer")
	List<Customer> customers;
}
