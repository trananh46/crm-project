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
@Table(name="phong_ban")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_phong_ban")
	private Long idDepartment;
	
	
	@Column(name="ten_phong_ban")
	private String nameDepartment;

	@Column(name="trang_thai")
	private Long status;

	public Long getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(Long idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getNameDepartment() {
		return nameDepartment;
	}

	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Department(Long idDepartment, String nameDepartment, Long status) {
		super();
		this.idDepartment = idDepartment;
		this.nameDepartment = nameDepartment;
		this.status = status;
	}
	
	public Department() {
		
	}
	
	@OneToMany(mappedBy = "department")
	List<User> liUsers;
	
}
