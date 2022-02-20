package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRoleAndInformation;
import com.example.demo.model.UserRole;
import com.example.demo.repository.UserRoleRepository;

@Service
public class UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	public void insertUserRole(UserRole u) {
		UserRole u1 = new UserRole();
		u1.setRole(u.getRole());
		u1.setUser(u.getUser());
		userRoleRepository.save(u1);
	}
	
	public List<UserRoleAndInformation> displayListRoleByIdUser(Long idUser){
		 List<UserRoleAndInformation> listRole = userRoleRepository.displayListRoleByIdUser(idUser);
		 return listRole;
	}
	
	public void deleteUserRole(Long idUserRole) {
		userRoleRepository.deleteUserRole(idUserRole);
	}
}
