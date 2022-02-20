package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Customer;
import com.example.demo.model.TypeOfContract;

public class ContractDTO {
	
	private Long idContract;
	
	private String nameContract;
	
	private String contractNumber;
	
	private	MultipartFile attachedFile;
	
	private String signedContractByPerson;
	
	private String signedDate;
	
	private String expiredDate;
	
	private Customer customer;
	
	private TypeOfContract typeOfContracts;

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

	public MultipartFile getAttachedFile() {
		return attachedFile;
	}

	public void setAttachedFile(MultipartFile attachedFile) {
		this.attachedFile = attachedFile;
	}

	public String getSignedContractByPerson() {
		return signedContractByPerson;
	}

	public void setSignedContractByPerson(String signedContractByPerson) {
		this.signedContractByPerson = signedContractByPerson;
	}

	public String getSignedDate() {
		return signedDate;
	}

	public void setSignedDate(String signedDate) {
		this.signedDate = signedDate;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
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

	public ContractDTO(Long idContract, String nameContract, String contractNumber, MultipartFile attachedFile,
			String signedContractByPerson, String signedDate, String expiredDate, Customer customer,
			TypeOfContract typeOfContracts) {
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
	}

	public ContractDTO() {
		
	}
}
