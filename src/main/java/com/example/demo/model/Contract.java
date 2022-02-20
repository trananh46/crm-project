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
import javax.persistence.Table;

@Entity
@Table(name="hop_dong")
public class Contract {

	@Id
	@Column(name="id_hop_dong")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContract;
	
	@Column(name="ten_hop_dong")
	private String nameContract;
	
	@Column(name="so_hop_dong")
	private String contractNumber;
	
	@Column(name="file_dinh_kem")
	private String attachedFile;
	
	@Column(name="nguoi_ky_hop_dong")
	private String signedContractByPerson;
	
	@Column(name="ngay_ky")
	private LocalDate signedDate;
	
	@Column(name="ngay_het_han")
	private LocalDate expiredDate;
	
	@ManyToOne
	@JoinColumn(name="id_khach_hang")
	Customer customer;
	
	@ManyToOne
	@JoinColumn(name="id_loai_hop_dong")
	TypeOfContract typeOfContracts;

	@Column(name="trang_thai")
	private Long status;

	public Long getIdContract() {
		return idContract;
	}

	public void setIdContract(Long idContract) {
		this.idContract = idContract;
	}

	public String getNameContract() {
		return nameContract;
	}

	public void setNameContract(String nameContract) {
		this.nameContract = nameContract;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getAttachedFile() {
		return attachedFile;
	}

	public void setAttachedFile(String attachedFile) {
		this.attachedFile = attachedFile;
	}

	public String getSignedContractByPerson() {
		return signedContractByPerson;
	}

	public void setSignedContractByPerson(String signedContractByPerson) {
		this.signedContractByPerson = signedContractByPerson;
	}

	public LocalDate getSignedDate() {
		return signedDate;
	}

	public void setSignedDate(LocalDate signedDate) {
		this.signedDate = signedDate;
	}

	public LocalDate getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(LocalDate expiredDate) {
		this.expiredDate = expiredDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public TypeOfContract getTypeOfContracts() {
		return typeOfContracts;
	}

	public void setTypeOfContracts(TypeOfContract typeOfContracts) {
		this.typeOfContracts = typeOfContracts;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Contract(Long idContract, String nameContract, String contractNumber, String attachedFile,
			String signedContractByPerson, LocalDate signedDate, LocalDate expiredDate, Customer customer,
			TypeOfContract typeOfContracts, Long status) {
		super();
		this.idContract = idContract;
		this.nameContract = nameContract;
		this.contractNumber = contractNumber;
		this.attachedFile = attachedFile;
		this.signedContractByPerson = signedContractByPerson;
		this.signedDate = signedDate;
		this.expiredDate = expiredDate;
		this.customer = customer;
		this.typeOfContracts = typeOfContracts;
		this.status = status;
	}
	
	public Contract() {
		
	}
}
