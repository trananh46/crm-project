package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BirthPlace;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.Nationality;
import com.example.demo.dto.StatisticCount;
import com.example.demo.model.Customer;
import com.example.demo.repository.PersonalCustomerRepository;

@Service
public class PersonalCustomerService {

	@Autowired
	private PersonalCustomerRepository personalCustomerRepository;

	public long insertPersonalCustomer(CustomerDTO c) {
		
		
		Customer c1 = new Customer();
		c1.setNameCustomer(c.getNameCustomer().toUpperCase());
		c1.setAddress(c.getAddress().toUpperCase());
		c1.setEmail(c.getEmail());
		c1.setTaxIdentificationNumber(c.getTaxIdentificationNumber());
		c1.setGender(c.getGender());
		c1.setIdentification(c.getIdentification());
		c1.setNationality(c.getNationality().toUpperCase());
		c1.setBirthPlace(c.getBirthPlace().toUpperCase());
		c1.setBirthday(LocalDate.parse(c.getBirthday()));
		c1.setRegistrationDate(LocalDate.parse(c.getRegistrationDate()));
		c1.setPhoneNumber(c.getPhoneNumber());
		c1.setIdCustomerStatus(c.getIdCustomerStatus());
		c1.setClassificationCustomer(c.getClassificationCustomer());
		
		//opened staus of customer is 1
		Long status = (long)1;
		c1.setStatus(status);
		String nameCustomer = c1.getNameCustomer();
		String Identification = c1.getIdentification();

		// we will check customer throught name and identification
		Customer c2 = personalCustomerRepository.checkExistPersonalCustomerByNameAndIdentification(nameCustomer,
				Identification);

		// if c1 == null , that customer hasn't existed yet , we will create a new
		// customer

		if (c2 == null) {
			Customer c3 = new Customer(c1);
			personalCustomerRepository.save(c3);
			return 0;
		} else {
			return 1;
		}

	}

	public List<Customer> displayListPersonalCustomer() {
		List<Customer> l = personalCustomerRepository.listPersonalCustomer();
		return l;
	}

	public List<Customer> displayAllPersonalCustomer() {
		List<Customer> l = personalCustomerRepository.displayAllPersonalCustomer();
		return l;
	}
	
	
	public Customer findCustomerById(Long idCustomer) {
		Customer c = personalCustomerRepository.findCustomerById(idCustomer);
		return c;
	}

	public long updatePersonalCustomer(CustomerDTO c) {
		Long idCustomer = c.getIdCustomer();
		String nameCustomer = c.getNameCustomer();
		String identification = c.getIdentification();

		Customer c1 = personalCustomerRepository.checkExistPersonalCustomerByNameAndIdentificationExcept(nameCustomer,
				identification, idCustomer);

		if (c1 == null) {
			Customer c2 = personalCustomerRepository.findCustomerById(idCustomer);
			c2.setNameCustomer(c.getNameCustomer().toUpperCase());
			c2.setAddress(c.getAddress().toUpperCase());
			c2.setEmail(c.getEmail());
			c2.setTaxIdentificationNumber(c.getTaxIdentificationNumber());
			c2.setGender(c.getGender());
			c2.setIdentification(c.getIdentification());
			c2.setNationality(c.getNationality().toUpperCase());
			c2.setBirthPlace(c.getBirthPlace().toUpperCase());
			c2.setBirthday(LocalDate.parse(c.getBirthday()));
			c2.setRegistrationDate(LocalDate.parse(c.getRegistrationDate()));
			c2.setPhoneNumber(c.getPhoneNumber());
			c2.setIdCustomerStatus(c.getIdCustomerStatus());
			c2.setClassificationCustomer(c.getClassificationCustomer());
			personalCustomerRepository.save(c2);
			return 0;
		} else {
			return 1;
		}

	}

	public List<Customer> searchPersonalCustomerByName(String nameCustomer) {
		List<Customer> listCustomer = personalCustomerRepository.searchPersonalCustomerByName(nameCustomer);
		return listCustomer;
	}

	public List<Nationality> displayListNationalityPersonalCustomer() {
		List<Nationality> listNationalityPersonalCustomer = personalCustomerRepository.displayListNationalityPersonalCustomer();
		return listNationalityPersonalCustomer;
	}

	public List<BirthPlace> displayListBirthPlacePersonalCustomer() {
		List<BirthPlace> listBirthPlacePersonalCustomer = personalCustomerRepository.displayListBirthPlacePersonalCustomer();
		return listBirthPlacePersonalCustomer;
	}

	public List<Customer> advancedSearchPersonalCustomer(Customer c) {
		String nationality = c.getNationality();
		String birthPlace = c.getBirthPlace();
		String identification = c.getIdentification();
	
		
		if(c.getIdCustomerStatus() == null && c.getGender() == null) {
			List<Customer> listCustomer = personalCustomerRepository.advancedSearchPersonalCustomer( nationality, birthPlace,identification);
			return listCustomer;
			
		}else if(c.getGender() == null) {
			String idCustomerStatus = Long.toString(c.getIdCustomerStatus());
			List<Customer> listCustomer = personalCustomerRepository.advancedSearchPersonalCustomerAndCustomerStatus(nationality, birthPlace, idCustomerStatus, identification);
			return listCustomer;
			
		}else if(c.getIdCustomerStatus() == null) {
			String gender = Long.toString(c.getGender());
			List<Customer> listCustomer = personalCustomerRepository.advancedSearchPersonalCustomerAndGender(gender,nationality, birthPlace,identification);
			return listCustomer;

		}else{
			String gender = Long.toString(c.getGender());
			String idCustomerStatus = Long.toString(c.getIdCustomerStatus());	
			List<Customer> listCustomer = personalCustomerRepository.advancedSearchPersonalCustomerAndGenderAndCustomerStatus(gender, nationality, birthPlace, idCustomerStatus, identification);
			return listCustomer;
		
		}
	}
	
	
	public void lockPersonalCustomer(Long idCustomer) {
		Customer c = personalCustomerRepository.findCustomerById(idCustomer);
		//locked status of customer is 0
		Long status = (long)0;
		c.setStatus(status);
		personalCustomerRepository.save(c);
	}
	
	public void openPersonalCustomer(Long idCustomer) {
		Customer c = personalCustomerRepository.findCustomerById(idCustomer);
		//open status of customer is 0
		Long status = (long)1;
		c.setStatus(status);
		personalCustomerRepository.save(c);
	}
	
	public List<Customer> listPersonalCustomerHasNotActived(){
		List<Customer> listCustomer = personalCustomerRepository.listPersonalCustomerHasNotActived();
		return listCustomer;
	}

	
	public List<Customer> listPersonalCustomerActived(){
		List<Customer> listCustomer = personalCustomerRepository.listPersonalCustomerActived();
		return listCustomer;
	}
	
	public List<Customer> listPersonalCustomerLocked(){
		List<Customer> listCustomer = personalCustomerRepository.listPersonalCustomerLocked();
		return listCustomer;
	}
}
