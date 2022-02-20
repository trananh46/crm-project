package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.DepartmentAndUser;
import com.example.demo.model.Department;
import com.example.demo.model.Menu;
import com.example.demo.model.User;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.MenuService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/FPT")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list_department")
	public String displayListDepartment(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<Department> listDepartment = departmentService.displayDepartment();
		model.addAttribute("listDepartment", listDepartment);
		return "user/listDepartment";
	}
	
	
	@GetMapping("/find_department_name")
	public String findDepartment(@RequestParam("search") String search,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<Department> listDepartment = departmentService.findListDepartment(search);
		model.addAttribute("listDepartment", listDepartment);
		return "user/listDepartment";
	}
	
	@GetMapping("/insert_department")
	public String displayFormInsertDepartment(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		return "user/formInsertDepartment";
	}
	
	
	@GetMapping("/insert_department_process")
	public String insertDepartmentProcess(@RequestParam("name_department") String nameDepartment,Model model) {
		int i = departmentService.insertDepartment(nameDepartment);
		if(i == 1) {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
//			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//			String email = userDetails.getUsername();
//			User u = userService.displayInformationOfUserByEmailAccount(email);
//			model.addAttribute("user", u);
			
			model.addAttribute("checkExist", i);
			return "user/formInsertDepartment";
		}
		return "redirect:/FPT/list_department";
	}	
	
	@GetMapping("/update_department")
	public String displayFormUpdateDepartment(@RequestParam("id_department") Long idDepartment,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		Department d = departmentService.findDepartmentById(idDepartment);
		model.addAttribute("department", d);
		return "user/formUpdateDepartment";
	}
	
	@GetMapping("/update_department_process")
	public String updateDepartmentProcess(@RequestParam("id_department") Long idDepartment,@RequestParam("name_department") String nameDepartment,Model model) {
		int i = departmentService.checkDepartmentExistAndUpdate(idDepartment, nameDepartment);
		if(i == 1) {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			Department d = departmentService.findDepartmentById(idDepartment);
			model.addAttribute("department", d);
			model.addAttribute("checkExist", i);
			return "user/formUpdateDepartment";
		}
		return "redirect:/FPT/list_department";
	}
	
	@GetMapping("/delete_department")
	public String deleteDepartment(@RequestParam("id_department") Long idDepartment) {
		departmentService.deleteDepartment(idDepartment);
		return "redirect:/FPT/list_department";
	}
	
	@GetMapping("/list-user-of-department")
	public String displayListUserOfDepartment(@RequestParam("id_department") Long idDepartment,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<DepartmentAndUser> listUser = departmentService.displayListUserOfDepartment(idDepartment);
		model.addAttribute("listUser", listUser);
		
		Department department = departmentService.findDepartmentById(idDepartment);
		String nameDepartment = department.getNameDepartment();
		model.addAttribute("nameDepartment", nameDepartment);
		
		Department d = departmentService.findDepartmentById(idDepartment);
		model.addAttribute("department", d);
		return "user/listUserOfDepartment";
		
	
	}
	
}
