package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Menu;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.MenuService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/FPT")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/role")
	public String displayListRole(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<Role> listRole = roleService.displayListRole();
		model.addAttribute("listRole", listRole);
		return "user/listRole";
	}
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/insert-role")
	public String displayFormInsertRole(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		return "user/formInsertRole";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/insert-role-process")
	public String insertRoleProcess(@ModelAttribute Role r,Model model) {
		
		long checkExist = roleService.insertRole(r);
		if(checkExist == 0) {
			return "redirect:/FPT/role";
		}else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("role", r);
			model.addAttribute("checkExist", checkExist);
			return "user/formInsertRoleError";
		}
		
	}
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/update-role")
	public String updateRole(@RequestParam("id_role") Long idRole,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		Role r = roleService.findRoleById(idRole);
		model.addAttribute("role", r);
		return "user/formUpdateRole";
	}
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/update-role-process")
	public String updateRoleProcess(@ModelAttribute Role r,Model model) {
		long checkExist = roleService.updateRole(r);
		if(checkExist == 0) {
			return "redirect:/FPT/role";
		}else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("checkExist", checkExist);
			return "user/formUpdateRoleError";
		}
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/delete-role")
	public String deleteRole(@RequestParam("id_role") Long idRole) {
		roleService.deleteRole(idRole);
		return "redirect:/FPT/role";
	}
}
