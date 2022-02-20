package com.example.demo.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.demo.model.Account;
import com.example.demo.model.Department;

public class UserDTO {

	
	private Long idUser;
	

	private String nameUser;
	
	
	private String phoneNumber;
	
	
	private String email;
	
	
	private String dateEnterCompany;
	
	
	private String birthday;
	

	private String identification;
	
	
	private Account account;
	

	private Department department;


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


	public String getDateEnterCompany() {
		return dateEnterCompany;
	}


	public void setDateEnterCompany(String dateEnterCompany) {
		this.dateEnterCompany = dateEnterCompany;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
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


	public UserDTO(Long idUser, String nameUser, String phoneNumber, String email, String dateEnterCompany,
			String birthday, String identification, Account account, Department department) {
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
	}

	public UserDTO() {
		
	}
	
}
