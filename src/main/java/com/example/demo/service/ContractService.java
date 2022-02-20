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

import com.example.demo.dto.ContractAndInformationOfCustomer;
import com.example.demo.dto.ContractDTO;
import com.example.demo.model.Contract;
import com.example.demo.repository.ContractRepository;

@Service
public class ContractService {

	@Autowired
	private ContractRepository contractRepository;
	
	private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
	
	public long insertContract(ContractDTO c) throws IOException {
		String nameContract = c.getNameContract().toUpperCase();
		String contractNumber = c.getContractNumber();
		
		Contract c1 = contractRepository.checkExistToInsert(nameContract, contractNumber);
		if(c1 == null) {
			
			
			
			MultipartFile attachedFile = c.getAttachedFile();	
			Path staticPath = Paths.get("src/main/resources/static/contract-file");
	        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath))) {
	            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath));
	        }
	        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(attachedFile.getOriginalFilename());
	        try (OutputStream os = Files.newOutputStream(file)) {
	            os.write(attachedFile.getBytes());
	        }
	        String attachedFileContract = "\\contract-file"+"\\"+attachedFile.getOriginalFilename().toString(); 
			
			
			Contract c2 = new Contract();
			c2.setNameContract(nameContract);
			c2.setContractNumber(contractNumber);
			c2.setSignedContractByPerson(c.getSignedContractByPerson());
			c2.setCustomer(c.getCustomer());
			c2.setTypeOfContracts(c.getTypeOfContracts());
			c2.setSignedDate(LocalDate.parse(c.getSignedDate()));
			c2.setExpiredDate(LocalDate.parse(c.getExpiredDate()));
			c2.setAttachedFile(attachedFileContract);
			
			//opened status of contract is 1
			Long status = (long)1;
			c2.setStatus(status);
			contractRepository.save(c2);
			return 0;
		}else {
			return 1;
		}
	}
	
	
	public List<ContractAndInformationOfCustomer> displayListContract(){
		List<ContractAndInformationOfCustomer> listContract = contractRepository.displayListContract();
		return listContract;
	}
	
	public List<ContractAndInformationOfCustomer> displayListContractByIdCustomer(Long idCustomer){
		List<ContractAndInformationOfCustomer> listContract = contractRepository.displayListContractByIdCustomer(idCustomer);
		return listContract;
	}
	
	public List<ContractAndInformationOfCustomer> searchContractByContractNumber(String contractNumber){
		List<ContractAndInformationOfCustomer> listContract = contractRepository.searchContractByContractNumber(contractNumber);
		return listContract;
	}
	
	public ContractAndInformationOfCustomer displayContractInformation(Long idContract) {
		ContractAndInformationOfCustomer contract = contractRepository.displayContractInformationById(idContract);
		return contract;
	}
	
	
	public long updateContract(ContractDTO c) {
		String nameContract = c.getNameContract().toUpperCase();
		String contractNumber = c.getContractNumber();
		Long idContract = c.getIdContract();
		Contract c1 = contractRepository.checkExistToUpdate(nameContract, contractNumber, idContract);
		
		if(c1 == null) {
			Contract c2 = contractRepository.findContractById(idContract);
			c2.setNameContract(nameContract);
			c2.setContractNumber(contractNumber);
			c2.setSignedContractByPerson(c.getSignedContractByPerson());
			c2.setCustomer(c.getCustomer());
			c2.setTypeOfContracts(c.getTypeOfContracts());
			c2.setSignedDate(LocalDate.parse(c.getSignedDate()));
			c2.setExpiredDate(LocalDate.parse(c.getExpiredDate()));
			contractRepository.save(c2);
			return 0;
		}else {
			return 1;
		}
		
	}
	
	public Contract findContractById(Long idContract) {
		Contract c = contractRepository.findContractById(idContract);
		return c;
	}
	
	public void updateAttachedFileContract(ContractDTO c) throws IOException {
		
		MultipartFile attachedFile = c.getAttachedFile();	
		Path staticPath = Paths.get("src/main/resources/static/contract-file");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath).resolve(attachedFile.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(attachedFile.getBytes());
        }
        String attachedFileContract = "\\contract-file"+"\\"+attachedFile.getOriginalFilename().toString(); 
        
        
        Long idContract = c.getIdContract();
        Contract c1 = contractRepository.findContractById(idContract);
        c1.setAttachedFile(attachedFileContract);
        contractRepository.save(c1);
	}
	
	
	public void deleteContractById(Long idContract) {
		
		Contract c = contractRepository.findContractById(idContract);
		//locked status of contract is 0
		Long status = (long)0;
		c.setStatus(status);
		contractRepository.save(c);
	}
	
	public void openContractById(Long idContract) {
		
		Contract c = contractRepository.findContractById(idContract);
		//opened status of contract is 1
		Long status = (long)1;
		c.setStatus(status);
		contractRepository.save(c);
	}
	
	
	public List<ContractAndInformationOfCustomer> displayAllContract(){
		List<ContractAndInformationOfCustomer> listContract = contractRepository.displayAllContract();
		return listContract;
	}
	
	public List<ContractAndInformationOfCustomer> displayAllContractShortTermTime(){
		List<ContractAndInformationOfCustomer> listContract = contractRepository.displayAllContractShortTermTime();
		return listContract;
	}
	
	public List<ContractAndInformationOfCustomer> displayAllContractLongTermTime(){
		List<ContractAndInformationOfCustomer> listContract = contractRepository.displayAllContractLongTermTime();
		return listContract;
	}
	
	public List<ContractAndInformationOfCustomer> displayAllContractLocked(){
		List<ContractAndInformationOfCustomer> listContract = contractRepository.displayAllContractLocked();
		return listContract;
	}
	
	
 }
