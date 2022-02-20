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
import javax.persistence.Table;

@Entity
@Table(name="khach_hang")
public class Customer {

	@Id
	@Column(name="id_khach_hang")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCustomer;
	
	@Column(name="ten_khach_hang")
	private String nameCustomer;
	
	@Column(name="dia_chi")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="ma_so_thue")
	private String taxIdentificationNumber;
	
	@Column(name="gioi_tinh")
	private Long gender;
	
	@Column(name="can_cuoc_cong_dan")
	private String identification;
	
	@Column(name="quoc_tich")
	private String nationality;
	
	@Column(name="noi_sinh")
	private String birthPlace;
	
	@Column(name="logo_image")
	private String logoImage;
	
	@Column(name="dia_chi_website")
	private String websiteAddress;
	
	@Column(name="nguoi_dai_dien")
	private String representative;
	
	@Column(name="id_parent_company")
	private Long idParentCompany;
	
	@Column(name="ma_so_doanh_nghiep")
	private String enterpriseIdentificationNumber;
	
	@Column(name="sinh_nhat")
	private LocalDate birthday;
	
	@Column(name="ngay_dang_ky")
	private LocalDate registrationDate;
	
	@Column(name="sdt")
	private String phoneNumber;
	
	@Column(name="id_trang_thai_khach_hang")
	private Long idCustomerStatus;
	
	@Column(name="quy_mo")
	private Long companyScale;
	
	@ManyToOne
	@JoinColumn(name="id_phan_loai_khach_hang")
	private ClassificationCustomer classificationCustomer;
	
	
	@ManyToOne
	@JoinColumn(name="id_linh_vuc")
	private IndustryField industryField;


	@Column(name="trang_thai")
	Long status;


	public Long getIdCustomer() {
		return idCustomer;
	}


	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}


	public String getNameCustomer() {
		return nameCustomer;
	}


	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTaxIdentificationNumber() {
		return taxIdentificationNumber;
	}


	public void setTaxIdentificationNumber(String taxIdentificationNumber) {
		this.taxIdentificationNumber = taxIdentificationNumber;
	}


	public Long getGender() {
		return gender;
	}


	public void setGender(Long gender) {
		this.gender = gender;
	}


	public String getIdentification() {
		return identification;
	}


	public void setIdentification(String identification) {
		this.identification = identification;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getBirthPlace() {
		return birthPlace;
	}


	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}


	public String getLogoImage() {
		return logoImage;
	}


	public void setLogoImage(String logoImage) {
		this.logoImage = logoImage;
	}


	public String getWebsiteAddress() {
		return websiteAddress;
	}


	public void setWebsiteAddress(String websiteAddress) {
		this.websiteAddress = websiteAddress;
	}


	public String getRepresentative() {
		return representative;
	}


	public void setRepresentative(String representative) {
		this.representative = representative;
	}


	public Long getIdParentCompany() {
		return idParentCompany;
	}


	public void setIdParentCompany(Long idParentCompany) {
		this.idParentCompany = idParentCompany;
	}


	public String getEnterpriseIdentificationNumber() {
		return enterpriseIdentificationNumber;
	}


	public void setEnterpriseIdentificationNumber(String enterpriseIdentificationNumber) {
		this.enterpriseIdentificationNumber = enterpriseIdentificationNumber;
	}


	public LocalDate getBirthday() {
		return birthday;
	}


	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}


	public LocalDate getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Long getIdCustomerStatus() {
		return idCustomerStatus;
	}


	public void setIdCustomerStatus(Long idCustomerStatus) {
		this.idCustomerStatus = idCustomerStatus;
	}


	public Long getCompanyScale() {
		return companyScale;
	}


	public void setCompanyScale(Long companyScale) {
		this.companyScale = companyScale;
	}


	public ClassificationCustomer getClassificationCustomer() {
		return classificationCustomer;
	}


	public void setClassificationCustomer(ClassificationCustomer classificationCustomer) {
		this.classificationCustomer = classificationCustomer;
	}


	public IndustryField getIndustryField() {
		return industryField;
	}


	public void setIndustryField(IndustryField industryField) {
		this.industryField = industryField;
	}


	public Long getStatus() {
		return status;
	}


	public void setStatus(Long status) {
		this.status = status;
	}


	public Customer(Long idCustomer, String nameCustomer, String address, String email, String taxIdentificationNumber,
			Long gender, String identification, String nationality, String birthPlace, String logoImage,
			String websiteAddress, String representative, Long idParentCompany, String enterpriseIdentificationNumber,
			LocalDate birthday, LocalDate registrationDate, String phoneNumber, Long idCustomerStatus,
			Long companyScale, ClassificationCustomer classificationCustomer, IndustryField industryField,
			Long status) {
		super();
		this.idCustomer = idCustomer;
		this.nameCustomer = nameCustomer;
		this.address = address;
		this.email = email;
		this.taxIdentificationNumber = taxIdentificationNumber;
		this.gender = gender;
		this.identification = identification;
		this.nationality = nationality;
		this.birthPlace = birthPlace;
		this.logoImage = logoImage;
		this.websiteAddress = websiteAddress;
		this.representative = representative;
		this.idParentCompany = idParentCompany;
		this.enterpriseIdentificationNumber = enterpriseIdentificationNumber;
		this.birthday = birthday;
		this.registrationDate = registrationDate;
		this.phoneNumber = phoneNumber;
		this.idCustomerStatus = idCustomerStatus;
		this.companyScale = companyScale;
		this.classificationCustomer = classificationCustomer;
		this.industryField = industryField;
		this.status = status;
	}
	public Customer() {
		
	}
	
	public Customer(Customer c) {
		super();
		this.idCustomer = c.getIdCustomer();
		this.nameCustomer = c.getNameCustomer();
		this.address = c.getAddress();
		this.email = c.getEmail();
		this.taxIdentificationNumber = c.getTaxIdentificationNumber();
		this.gender = c.getGender();
		this.identification = c.getIdentification();
		this.nationality = c.getNationality();
		this.birthPlace = c.getBirthPlace();
		this.logoImage = c.getLogoImage();
		this.websiteAddress = c.getWebsiteAddress();
		this.representative = c.getRepresentative();
		this.idParentCompany = c.getIdParentCompany();
		this.enterpriseIdentificationNumber = c.getEnterpriseIdentificationNumber();
		this.birthday = c.getBirthday();
		this.registrationDate = c.getRegistrationDate();
		this.phoneNumber = c.getPhoneNumber();
		this.idCustomerStatus = c.getIdCustomerStatus();
		this.companyScale = c.getCompanyScale();
		this.classificationCustomer = c.getClassificationCustomer();
		this.industryField = c.getIndustryField();
		this.status = c.getStatus();
	}
	
	
	@OneToMany(mappedBy = "customer")
	List<Contract> contract;
}
