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
@Table(name="loai_hop_dong")
public class TypeOfContract {

	@Id
	@Column(name="id_loai_hop_dong")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTypeOfContract;
	
	@Column(name="ten_loai_hop_dong")
	private String nameTypeOfContract;

	@Column(name="trang_thai")
	private Long status;

	public Long getIdTypeOfContract() {
		return idTypeOfContract;
	}

	public void setIdTypeOfContract(Long idTypeOfContract) {
		this.idTypeOfContract = idTypeOfContract;
	}

	public String getNameTypeOfContract() {
		return nameTypeOfContract;
	}

	public void setNameTypeOfContract(String nameTypeOfContract) {
		this.nameTypeOfContract = nameTypeOfContract;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public TypeOfContract(Long idTypeOfContract, String nameTypeOfContract, Long status) {
		super();
		this.idTypeOfContract = idTypeOfContract;
		this.nameTypeOfContract = nameTypeOfContract;
		this.status = status;
	}
	
	public TypeOfContract() {
		
	}
	
	@OneToMany(mappedBy = "typeOfContracts")
	List<Contract> contract;
}
