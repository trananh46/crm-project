package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_system")
public class User {

	@Id
	@Column(name="id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	
	@Column(name="ten_user")
	private String nameUser;
	
	@Column(name="sdt")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="ngay_vao_cong_ty")
	private LocalDate dateEnterCompany;
	
	@Column(name="sinh_nhat")
	private LocalDate birthday;
	
	@Column(name="can_cuoc_cong_dan")
	private String identification;
	
	@OneToOne
	@JoinColumn(name="id_tai_khoan")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name="id_phong_ban")
	private Department department;

	@Column(name="trang_thai")
	private Long status;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateEnterCompany() {
		return dateEnterCompany;
	}

	public void setDateEnterCompany(LocalDate dateEnterCompany) {
		this.dateEnterCompany = dateEnterCompany;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public User(Long idUser, String nameUser, String phoneNumber, String email, LocalDate dateEnterCompany,
			LocalDate birthday, String identification, Account account, Department department, Long status) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateEnterCompany = dateEnterCompany;
		this.birthday = birthday;
		this.identification = identification;
		this.account = account;
		this.department = department;
		this.status = status;
	}
	
	public User() {
		
	}
	
	@OneToMany(mappedBy = "user")
	List<UserRole> lisUserRoles;
}
