package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.UserAndInformation;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserRoleAndInformation;
import com.example.demo.model.Account;
import com.example.demo.model.Department;
import com.example.demo.model.Menu;
import com.example.demo.model.User;
import com.example.demo.service.AccountService;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.MenuService;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/FPT")
public class UserController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@GetMapping("/insert-user")
	public String displayFormInsertUser(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<Department> listDepartment = departmentService.displayDepartment();
		model.addAttribute("listDepartment", listDepartment);
		
		return "user/formInsertUser";
	
	}
	
	@PostMapping("/insert-user-process")
	public String insertUserProcess(@ModelAttribute UserDTO u,Model model) {
		long checkExist = userService.insertUser(u);
		
		if(checkExist == 0) {
			return "redirect:/FPT/display-list-user";
		}else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u1 = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u1);
			
			model.addAttribute("checkExist", checkExist);
			model.addAttribute("user", u);
			
			Department d = u.getDepartment();
			model.addAttribute("selectedDepartment", d);
			
			List<Department> listDepartment = departmentService.displayDepartment();
			model.addAttribute("listDepartment", listDepartment);
			
			return "user/formInsertUserError";
		}
		
		
	}
	
	@GetMapping("/display-list-user")
	public String displayListUser(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<UserAndInformation> listUser = userService.displayListUser();
		model.addAttribute("listUser", listUser);	
		
		return "user/listUser";
		
	}
	  
	@GetMapping("/display-information-user")
	public String displayInformationUser(@RequestParam("id_user") Long idUser,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u1 = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u1);
		
		User u = userService.findUserById(idUser);	
		model.addAttribute("user", u);
		
		Department d = u.getDepartment();
		model.addAttribute("selectedDepartment", d);
		
		Account a = accountService.findAccountByIdUser(idUser);
		model.addAttribute("account", a);
		
		List<UserRoleAndInformation> listUserRole = userRoleService.displayListRoleByIdUser(idUser);
		model.addAttribute("listUserRole", listUserRole);
		
		
		
		return "user/informationUser";
	
	}
	
	@GetMapping("/update-user")
	public String displayFormUpdateUser(@RequestParam("id_user") Long idUser,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u1 = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u1);
		
		User u = userService.findUserById(idUser);	
		model.addAttribute("user", u);
		
		Department d = u.getDepartment();
		model.addAttribute("selectedDepartment", d);
		
		List<Department> listDepartment = departmentService.displayDepartment();
		model.addAttribute("listDepartment", listDepartment);
		
		return "user/formUpdateUser";
	}
	
	
	@PostMapping("/update-user-process")
	public String updateUserProcess(UserDTO u,RedirectAttributes redirectAttributes,Model model) {
		long checkExist = userService.updateUser(u);
		if(checkExist == 0) {
			redirectAttributes.addAttribute("id_user", u.getIdUser());
			return "redirect:/FPT/display-information-user";
		}else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u1 = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u1);
			
			model.addAttribute("checkExist", checkExist);
			
			model.addAttribute("user", u);
			
			Department d = u.getDepartment();
			model.addAttribute("selectedDepartment", d);
			
			List<Department> listDepartment = departmentService.displayDepartment();
			model.addAttribute("listDepartment", listDepartment);
			return "user/formUpdateUserError";
		}
	}
	
	@GetMapping("/search-user-by-name")
	public String searchUserByName(@RequestParam("search") String search,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<UserAndInformation> listUser = userService.searchUserByName(search);
		model.addAttribute("listUser", listUser);
		
		return "user/listUser";
	}
	
	@GetMapping("/delete-user")
	public String deleteUser(@RequestParam("id_user") Long idUser) {
		userService.lockStatusUser(idUser);
		return "redirect:/FPT/display-list-user";
	
	}
	
	@GetMapping("/user-page")
	public String userPage(@RequestParam("id_user") Long idUser,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		User u1 = userService.findUserById(idUser);	
		model.addAttribute("userInformation", u1);
		
		Department d = u1.getDepartment();
		model.addAttribute("selectedDepartment", d);
		
		Account a = accountService.findAccountByIdUser(idUser);
		model.addAttribute("account", a);
		
		return "user/userPage";
	
	}
}
