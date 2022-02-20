package com.example.demo.dto;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.ClassificationCustomer;
import com.example.demo.model.IndustryField;

public class CustomerDTO {

	private Long idCustomer;

	private String nameCustomer;

	private String address;

	private String email;

	private String taxIdentificationNumber;

	private Long gender;

	private String identification;

	private String nationality;

	private String birthPlace;

	private MultipartFile logoImage;

	private String websiteAddress;

	private String representative;

	private Long idParentCompany;

	private String enterpriseIdentificationNumber;

	private String birthday;

	private String registrationDate;

	private String phoneNumber;

	private Long idCustomerStatus;

	private Long companyScale;

	private ClassificationCustomer classificationCustomer;

	private IndustryField industryField;

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

	public MultipartFile getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(MultipartFile logoImage) {
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
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

	public CustomerDTO(Long idCustomer, String nameCustomer, String address, String email, String taxIdentificationNumber,
			Long gender, String identification, String nationality, String birthPlace, MultipartFile logoImage,
			String websiteAddress, String representative, Long idParentCompany, String enterpriseIdentificationNumber,
			String birthday, String registrationDate, String phoneNumber, Long idCustomerStatus, Long companyScale,
			ClassificationCustomer classificationCustomer, IndustryField industryField) {
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
	}
	
	public CustomerDTO() {
		
	}
	
}
