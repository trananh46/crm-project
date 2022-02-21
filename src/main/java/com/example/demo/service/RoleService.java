package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> displayListRole(){
		List<Role> listRole = roleRepository.displayListRole();
		return listRole;
	}
	
	
	public long insertRole(Role r) {
		String roleName = r.getNameRole().toUpperCase();
		String roleCode = r.getCodeRole().toUpperCase();
		
		Role r1 = roleRepository.checkExistToInsert(roleName, roleCode);
		if(r1 == null) {
			Role r3 = new Role();
			r3.setNameRole(roleName);
			r3.setCodeRole(roleCode);
			//opened status of role is 1
			Long status = (long)1;
			r3.setStatus(status);
			roleRepository.save(r3);
			return 0;
		}else {
			return 1;
		}
	}
	
	public Role findRoleById(Long idRole) {
		Role r = roleRepository.findRoleById(idRole);
		return r;
	}
	
	public long updateRole(Role r) {
		String roleName = r.getNameRole().toUpperCase();
		String roleCode = r.getCodeRole().toUpperCase();
		Long idRole = r.getIdRole();
		Role r1 = roleRepository.checkExistToUpdate(roleName, roleCode, idRole);
		if(r1 == null) {
			Role r2 = roleRepository.findRoleById(idRole);
			r2.setNameRole(roleName);
			r2.setCodeRole(roleCode);
			roleRepository.save(r2);
			return 0;
		}else {
			return 1;
		}
	}
	
	public List<Role> displayListRoleToInsertUserRole(Long idUser){
		List<Role> listRole = roleRepository.displayListRoleToInsertUserRole(idUser);
		return listRole;
	}
	
	public void deleteRole(Long idRole) {
		Role r = roleRepository.findRoleById(idRole);
		//locked status of role is 0
		Long status = (long)0;
		r.setStatus(status);
		roleRepository.save(r);
	}
	
	public List<Role> displayListRoleOfUserById(Long idUser){
		List<Role> listRole = roleRepository.displayListRoleOfUserById(idUser);
		return listRole;
	}
}
