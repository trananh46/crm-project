package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.IndustryField;
import com.example.demo.repository.IndustryFieldRepository;

@Service
public class IndustryFieldService {

	@Autowired
	private IndustryFieldRepository industryFieldRepository;
	
	public long insertIndustryField(IndustryField i) {
		String nameIndustryField = i.getNameIndustryField().toUpperCase();
		
		IndustryField i1 = industryFieldRepository.findIndustryFieldByName(nameIndustryField);
		
		if(i1 == null) {
			IndustryField i2 = new IndustryField();
			i2.setNameIndustryField(nameIndustryField);
			//opened status is 1
			Long status = (long)1;
			i2.setStatus(status);
			industryFieldRepository.save(i2);
			return 0;
		}else {
			return 1;
		}
	}
	
	
	public List<IndustryField> displayListIndustryField(){
		List<IndustryField> l = industryFieldRepository.displayListIndustryField();
		return l;
	}
	
	
	public IndustryField findIndustryFieldById(Long idIndustryField) {
		IndustryField i = industryFieldRepository.findIndustryFieldById(idIndustryField);
		return i;
	}
	
	
	public long updateIndustryField(IndustryField i) {
		String nameIndustryField = i.getNameIndustryField().toUpperCase();
		
		List<IndustryField> l = industryFieldRepository.checkExistByNameToUpdate(nameIndustryField,i.getIdIndustryField());
		long size = l.size();
		if(size == 0) {
			IndustryField i1 = industryFieldRepository.findIndustryFieldById(i.getIdIndustryField());
			i1.setNameIndustryField(nameIndustryField);
			industryFieldRepository.save(i1);
			return 0;
		}else {
			return 1;
		}
	}
	
	public void deleteIndustryFieldById(Long idIndustryField) {
		
		IndustryField i = industryFieldRepository.findIndustryFieldById(idIndustryField);
		//locked status is 0
		Long status = (long)0;
		i.setStatus(status);
		industryFieldRepository.save(i);
	}
	
}
