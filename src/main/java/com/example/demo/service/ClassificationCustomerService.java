package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ClassificationCustomer;
import com.example.demo.repository.ClassificationCustomerRepository;

@Service
public class ClassificationCustomerService {

	@Autowired
	private ClassificationCustomerRepository classificationCustomerRepository;
	
	public List<ClassificationCustomer> displayClassificationCustomer(){
		List<ClassificationCustomer> l = classificationCustomerRepository.listClassificationCustomer();
		return l;
	}
	
	
	public long insertClassificationCustomer(ClassificationCustomer c) {
		String nameClassification = c.getNameClassificationCustomer().toUpperCase();
		ClassificationCustomer c1 = classificationCustomerRepository.findClassificationCustomerByName(nameClassification);
		if(c1 == null) {
			ClassificationCustomer c2 = new ClassificationCustomer();
			c2.setNameClassificationCustomer(nameClassification);
			//opened status is 1
			Long status = (long)1;
			c2.setStatus(status);
			classificationCustomerRepository.save(c2);
			return 0;
		}else {
			return 1;
		}
	}
	
	public ClassificationCustomer findClassificationCustomerById(Long idClassificationCustomer) {
		ClassificationCustomer c = classificationCustomerRepository.findClassificationCustomerById(idClassificationCustomer);
		return c;
	}
	
	public ClassificationCustomer findClassificationCustomerById(ClassificationCustomer c) {
		Long idClassificationCustomer = c.getIdClassificationCustomer();
		ClassificationCustomer c1 = classificationCustomerRepository.findClassificationCustomerById(idClassificationCustomer);
		return c1;
	}
	
	public long updateClassificationCustomer(ClassificationCustomer c) {
		String nameClassification = c.getNameClassificationCustomer().toUpperCase();
		ClassificationCustomer c1 = classificationCustomerRepository.checkExistClassificationCustomerByNameToUpdate(nameClassification, c.getIdClassificationCustomer());
		if(c1 == null) {
			ClassificationCustomer c2 = classificationCustomerRepository.findClassificationCustomerById(c.getIdClassificationCustomer());
			c2.setNameClassificationCustomer(nameClassification);
			classificationCustomerRepository.save(c2);
			return 0;
		}else {
			return 1;
		}
	}
	
	public void deleteClassificationCustomer(Long idClassificationCustomer) {
		
		ClassificationCustomer c = classificationCustomerRepository.findClassificationCustomerById(idClassificationCustomer);
		//locked status is 0
		Long status = (long)0;
		c.setStatus(status);
		classificationCustomerRepository.save(c);
	}
}
