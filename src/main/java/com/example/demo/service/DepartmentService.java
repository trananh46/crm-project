package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentAndUser;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private UserService userService;
	
	public int insertDepartment(String nameDepartment) {
		String nameDepartmentUpperCase = nameDepartment.toUpperCase();
		
		Department d = departmentRepository.findDepartmentByName(nameDepartmentUpperCase);
		if (d == null) {
			Department p = new Department();
			p.setNameDepartment(nameDepartmentUpperCase);
			//opened status of department is 1
			Long status = (long)1;
			p.setStatus(status);
			departmentRepository.save(p);
			return 0;
		}
		return 1;
	}

	public List<Department> displayDepartment() {
		List<Department> l = departmentRepository.displayListDepartment();
		return l;
	}

	public List<Department> findListDepartment(String search) {
		String nameDepartment = search.toUpperCase();
		List<Department> l = departmentRepository.findListDepartment(nameDepartment);
		return l;
	}

	public Department findDepartmentById(Long idDepartment) {
		Department d = departmentRepository.findDepartmentById(idDepartment);
		return d;
	}

	public int checkDepartmentExistAndUpdate(Long idDepartment, String nameDepartment) {

		Department d = departmentRepository.findDepartmentByName(nameDepartment);
		if (d == null) {
			departmentRepository.updateDepartment(idDepartment, nameDepartment);
			return 0;
		}
		return 1;
	}
	
	public void deleteDepartment(Long idDepartment) {
		Department d = findDepartmentById(idDepartment);
		//locked status of department is 0
		Long status = (long)0;
		d.setStatus(status);
		departmentRepository.save(d);
		
		// locked users from that department
		userService.updateStatusOfUserByIdDepartment(idDepartment);
	}
	
	public List<DepartmentAndUser> displayListUserOfDepartment(Long idDepartment){
		List<DepartmentAndUser> listUser = departmentRepository.displayListUserOfDepartment(idDepartment);
		return listUser;
	}
}
