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
@Table(name="quyen")
public class Role {

	@Id
	@Column(name="id_quyen")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;
	
	@Column(name="ten_quyen")
	private String nameRole;
	
	@Column(name="ma_quyen")
	private String codeRole;

	@Column(name="trang_thai")
	private Long status;

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public String getCodeRole() {
		return codeRole;
	}

	public void setCodeRole(String codeRole) {
		this.codeRole = codeRole;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Role(Long idRole, String nameRole, String codeRole, Long status) {
		super();
		this.idRole = idRole;
		this.nameRole = nameRole;
		this.codeRole = codeRole;
		this.status = status;
	}
	
	public Role() {
		
	}
	@OneToMany(mappedBy = "role")
	List<UserRole> lisUserRoles;
}
