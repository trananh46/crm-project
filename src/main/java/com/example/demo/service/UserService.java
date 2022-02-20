package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserAndInformation;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public long insertUser(UserDTO u) {
		String nameUser = u.getNameUser().toUpperCase();
		String identification = u.getIdentification();
		
		User u1 = userRepository.checkExistToInsert(nameUser, identification);
		if(u1 == null) {
			
			//opened status of user is 1
			Long status = (long)1;
			User u2 = new User();
			u2.setNameUser(nameUser);
			u2.setIdentification(identification);
			u2.setPhoneNumber(u.getPhoneNumber());
			u2.setEmail(u.getEmail());
			u2.setDepartment(u.getDepartment());
			u2.setDateEnterCompany(LocalDate.parse(u.getDateEnterCompany()));
			u2.setBirthday(LocalDate.parse(u.getBirthday()));
			u2.setStatus(status);
			userRepository.save(u2);
			return 0;
		}else {
			return 1;
		}
	}
	
	public List<UserAndInformation> displayListUser(){
		List<UserAndInformation> listUser = userRepository.displayListUser();
		return listUser;
	}
	
	public User findUserById(Long idUser) {
		User u = userRepository.findUserById(idUser);
		return u;
	}
	
	public User displayInformationOfUserByEmailAccount(String email) {
		User u = userRepository.displayInformationOfUserByEmailAccount(email);
		return u;
	}
	public long updateUser(UserDTO u) {
		String nameUser = u.getNameUser().toUpperCase();
		String identification = u.getIdentification();
		Long idUser = u.getIdUser();
		
		User u1 = userRepository.checkExistToUpdate(nameUser, identification,idUser);
		if(u1 == null) {
			
			User u2 = userRepository.findUserById(idUser);
			u2.setNameUser(nameUser);
			u2.setIdentification(identification);
			u2.setBirthday(LocalDate.parse(u.getBirthday()));
			u2.setDateEnterCompany(LocalDate.parse(u.getDateEnterCompany()));
			u2.setPhoneNumber(u.getPhoneNumber());
			u2.setEmail(u.getEmail());
			u2.setDepartment(u.getDepartment());
			userRepository.save(u2);
			return 0;
		}else {
			return 1;
		}
	}
	
	public List<UserAndInformation> searchUserByName(String search){
		String nameUser = search.toUpperCase();
		List<UserAndInformation> listUser = userRepository.searchUserByName(nameUser);
		return listUser;
	}
	
	public void lockStatusUser(Long idUser) {
		User u = userRepository.findUserById(idUser);
		// locked status of user is 0
		Long status = (long)0;
		u.setStatus(status);
		userRepository.save(u);
	}
	
	public void updateStatusOfUserByIdDepartment(Long idDepartment) {
		userRepository.updateStatusOfUserByIdDepartment(idDepartment);
	}
	
	
	public List<UserAndInformation> displayAllUser(){
		List<UserAndInformation> listUser = userRepository.displayAllUser();
		return listUser;
	}
	
	public List<UserAndInformation> displayAllUserHasNotHadAccount(){
		List<UserAndInformation> listUser = userRepository.displayAllUserHasNotHadAccount();
		return listUser;
	}
	
	public List<UserAndInformation> displayAllUserHasAccount(){
		List<UserAndInformation> listUser = userRepository.displayAllUserHasAccount();
		return listUser;
	}
	
	public List<UserAndInformation> displayAllUserLocked(){
		List<UserAndInformation> listUser = userRepository.displayAllUserLocked();
		return listUser;
	}
	
	public List<UserAndInformation> displayAllUserByDepartment(String nameDepartment){
		List<UserAndInformation> listUser = userRepository.displayAllUserByDepartment(nameDepartment);
		return listUser;
	}
}
