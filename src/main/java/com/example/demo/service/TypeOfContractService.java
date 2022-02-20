package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ContractAndInformationOfCustomer;
import com.example.demo.model.Contract;
import com.example.demo.model.TypeOfContract;
import com.example.demo.repository.TypeOfContractRepository;

@Service
public class TypeOfContractService {

	@Autowired
	private TypeOfContractRepository typeOfContractRepository;
	
	public long insertTypeOfContract(TypeOfContract t) {
		
		String nameTypeOfContract = t.getNameTypeOfContract().toUpperCase();
		
		TypeOfContract t1 = typeOfContractRepository.checkExistByName(nameTypeOfContract);
		if(t1 == null) {
			TypeOfContract t2 = new TypeOfContract();
			t2.setNameTypeOfContract(nameTypeOfContract);
			//opened status is 1
			Long status = (long)1;
			t2.setStatus(status);
			typeOfContractRepository.save(t2);
			return 0;
		}else {
			return 1;
		}	
		
		
	}
	
	public List<TypeOfContract> displayListTypeOfContract(){
		List<TypeOfContract> l = typeOfContractRepository.displayListTypeOfContract();
		return l;
	}
	
	
	public TypeOfContract findTypeOfContractById(Long idTypeOfContract) {
		TypeOfContract t = typeOfContractRepository.findTypeOfContractById(idTypeOfContract);
		return t;
	}
	
	
	public long updateTypeOfContract(TypeOfContract t) {
		String nameTypeOfContract = t.getNameTypeOfContract().toUpperCase();
		List<TypeOfContract> checkExist = typeOfContractRepository.checkExistByNameTypeOfContractToUpdate(nameTypeOfContract, t.getIdTypeOfContract());
		long size = checkExist.size();
		if(size == 0) {
			TypeOfContract t1 = typeOfContractRepository.findTypeOfContractById(t.getIdTypeOfContract());
			t1.setNameTypeOfContract(nameTypeOfContract);
			typeOfContractRepository.save(t1);
			return 0;
		}else {
			return 1;
		}
	}
	
	
	public void deleteTypeOfContract(Long idTypeOfContract) {
		TypeOfContract t = typeOfContractRepository.findTypeOfContractById(idTypeOfContract);
		//locked status is 0
		Long status = (long)0;
		t.setStatus(status);
		typeOfContractRepository.save(t);
	}
	
	public List<ContractAndInformationOfCustomer> displayListContractByIdTypeOfContract( Long idTypeOfContract){
		List<ContractAndInformationOfCustomer> listContract = typeOfContractRepository.displayListContractByIdTypeOfContract(idTypeOfContract);
		return listContract;
	}
	
	
}
