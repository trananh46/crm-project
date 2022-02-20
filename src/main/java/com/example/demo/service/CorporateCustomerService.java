package com.example.demo.service;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;
import com.example.demo.repository.CorporateCustomerRepository;

@Service
public class CorporateCustomerService {

	@Autowired
	private CorporateCustomerRepository corporateCustomerRepository;
	
	private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
	
	public long insertCorporateCustomer(CustomerDTO c) throws IOException {
		
		
		
		String nameCustomer = c.getNameCustomer().toUpperCase();
		String enterpriseIdentificationNumber = c.getEnterpriseIdentificationNumber();
		Customer c1 = corporateCustomerRepository.checkExistCorporateCustomerToInsert(enterpriseIdentificationNumber, nameCustomer);
		if(c1 == null) {
			
			
			// store images into folder in project
			// if image has existed in folder we don't need to store
			MultipartFile image = c.getLogoImage();	
			Path staticPath = Paths.get("src/main/resources/static/images");
	        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath))) {
	            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath));
	        }
	        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(image.getOriginalFilename());
	        try (OutputStream os = Files.newOutputStream(file)) {
	            os.write(image.getBytes());
	        }
	        String logoImage = "\\images"+"\\"+image.getOriginalFilename().toString(); 
			
	        
	        // store new record in database
			Customer c2 = new Customer();	
			c2.setNameCustomer(c.getNameCustomer().toUpperCase());
			c2.setAddress(c.getAddress());
			c2.setEmail(c.getEmail());
			c2.setTaxIdentificationNumber(c.getTaxIdentificationNumber());
			c2.setWebsiteAddress(c.getWebsiteAddress());
			c2.setRepresentative(c.getRepresentative());
			c2.setIdParentCompany(c.getIdParentCompany());
			c2.setEnterpriseIdentificationNumber(c.getEnterpriseIdentificationNumber());
			c2.setClassificationCustomer(c.getClassificationCustomer());
			c2.setIndustryField(c.getIndustryField());
			c2.setRegistrationDate(LocalDate.parse(c.getRegistrationDate()));
			c2.setPhoneNumber(c.getPhoneNumber());
			c2.setIdCustomerStatus(c.getIdCustomerStatus());
			c2.setCompanyScale(c.getCompanyScale());
			c2.setLogoImage(logoImage);
			//opened status is 1
			Long status = (long)1;
			c2.setStatus(status);
			corporateCustomerRepository.save(c2);
			return 0;
		}else {
			return 1;
		}
		
	}
	
	
	public List<Customer> displayAllCorporateCustomer(){
		List<Customer> l = corporateCustomerRepository.displayListCorporateCustomer();
		return l;
	}
	
	public List<Customer> displayAllCorporateCustomerByIdIndustryFiled(Long idIndustryField){
		List<Customer> l = corporateCustomerRepository.displayListCorporateCustomerByIdIndustryField(idIndustryField);
		return l;
	}
	
	public List<Customer> searchCorporateCustomerByName(String search){
		String nameCustomer = search.toUpperCase();
		List<Customer> l = corporateCustomerRepository.searchCorporateCustomerByName(nameCustomer);
		return l;
	}
	
	
	public Customer findCorporateCustomerById(Long idCustomer) {
		Customer c = corporateCustomerRepository.findCorporateCustomerById(idCustomer);
		return c;
	}
	
	public List<Customer> displayListCorporateCustomerExcept(Long idCustomer){
		List<Customer> listCorporateCustomer = corporateCustomerRepository.displayListCorporateCustomerExcept(idCustomer);
		return listCorporateCustomer;
	}
	
	public long updateCorporateCustomer(CustomerDTO c) {
		String nameCustomer = c.getNameCustomer().toUpperCase();
		String enterpriseIdentificationNumber = c.getEnterpriseIdentificationNumber();
		Long idCustomer = c.getIdCustomer();
		
		Customer c1 = corporateCustomerRepository.checkExistCorporateCustomerToUpdate(enterpriseIdentificationNumber, nameCustomer, idCustomer);
		
		if(c1 == null) {
			Customer c2 = corporateCustomerRepository.findCorporateCustomerById(idCustomer);
			c2.setNameCustomer(nameCustomer);
			c2.setAddress(c.getAddress());
			c2.setEmail(c.getEmail());
			c2.setTaxIdentificationNumber(c.getTaxIdentificationNumber());
			c2.setWebsiteAddress(c.getWebsiteAddress());
			c2.setRepresentative(c.getRepresentative());
			c2.setIdParentCompany(c.getIdParentCompany());
			c2.setEnterpriseIdentificationNumber(c.getEnterpriseIdentificationNumber());
			c2.setClassificationCustomer(c.getClassificationCustomer());
			c2.setIndustryField(c.getIndustryField());
			c2.setRegistrationDate(LocalDate.parse(c.getRegistrationDate()));
			c2.setPhoneNumber(c.getPhoneNumber());
			c2.setIdCustomerStatus(c.getIdCustomerStatus());
			c2.setCompanyScale(c.getCompanyScale());
			corporateCustomerRepository.save(c2);
			return 0;
		}else {
			return 1;
		}	
	}
	
	
	public void updateLogoImage(CustomerDTO c) throws IOException {
		MultipartFile image = c.getLogoImage();	
		Path staticPath = Paths.get("src/main/resources/static/images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(image.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(image.getBytes());
        }
        String logoImage = "\\images"+"\\"+image.getOriginalFilename().toString();
        
        
        
        Long idCustomer = c.getIdCustomer();
        Customer c1 = corporateCustomerRepository.findCorporateCustomerById(idCustomer);
        c1.setLogoImage(logoImage);
        corporateCustomerRepository.save(c1);
	}
	
	public List<Customer> advancedSearchCorporateByEnterpriseIdentificationNumber(String enterpriseIdentificationNumber){
		List<Customer> listCorporateCustomer = corporateCustomerRepository.advancedSearchCorporateByEnterpriseIdentificationNumber(enterpriseIdentificationNumber);
		return listCorporateCustomer;
	}
	
	public List<Customer> advancedSearchCorporateCustomerByCompanyScale(Long idCompanyScale){
		List<Customer> listCorporateCustomer = corporateCustomerRepository.advancedSearchCorporateCustomerByCompanyScale(idCompanyScale);
		return listCorporateCustomer;
	}
	
	
	public List<Customer> advancedSearchCorporateCustomerByIndustryField(Long idIndustryField){
		List<Customer> listCorporateCustomer = corporateCustomerRepository.advancedSearchCorporateCustomerByIndustryField(idIndustryField);
		return listCorporateCustomer;
	}
	
	
	public List<Customer> advancedSearchCorporateCustomerByCustomerStatus(Long idCustomerStatus){
		List<Customer> listCorporateCustomer = corporateCustomerRepository.advancedSearchCorporateCustomerByCustomerStatus(idCustomerStatus);
		return listCorporateCustomer;
	}
	
	public List<Customer> displayListCorporateCustomerHasNotActived(){
		List<Customer> listCorporateCustomer = corporateCustomerRepository.displayListCorporateCustomerHasNotActived();
		return listCorporateCustomer;
	}
	
	
	public List<Customer> displayListCorporateCustomerActived(){
		List<Customer> listCorporateCustomer = corporateCustomerRepository.displayListCorporateCustomerActived();
		return listCorporateCustomer;
	}
	
	public List<Customer> displayListCorporateCustomerLocked(){
		List<Customer> listCorporateCustomer = corporateCustomerRepository.displayListCorporateCustomerLocked();
		return listCorporateCustomer;
	}
	
	public void lockCorporateCustomer(Long idCustomer) {
		Customer c = corporateCustomerRepository.findCorporateCustomerById(idCustomer);
		//locked status is 0
		Long status = (long)0;
		c.setStatus(status);
		corporateCustomerRepository.save(c);
	}
	
	public void openCorporateCustomer(Long idCustomer) {
		Customer c = corporateCustomerRepository.findCorporateCustomerById(idCustomer);
		//opened status is 1
		Long status = (long)1;
		c.setStatus(status);
		corporateCustomerRepository.save(c);
	}
}
