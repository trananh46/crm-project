package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Menu;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.service.MenuService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/FPT")
public class UserRoleController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private MenuService menuService;
	
	@Secured({"ROLE_DRT"})
	@GetMapping("/insert-user-role")
	public String displayFormInsertUserRole(@RequestParam("id_user") Long idUser,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		User u1 = userService.findUserById(idUser);
		model.addAttribute("user", u1);
		
		List<Role> listRole = roleService.displayListRoleToInsertUserRole(idUser);
		model.addAttribute("listRole", listRole);
		
		return "user/formInsertUserRole";

	}
	@Secured({"ROLE_DRT"})
	@GetMapping("/insert-user-role-process")
	public String insertUserRoleProcess(@ModelAttribute UserRole u,RedirectAttributes redirectAttributes) {
		User u1 = u.getUser();
		Long idUser = u1.getIdUser();
		userRoleService.insertUserRole(u);
		redirectAttributes.addAttribute("id_user",idUser);
		return "redirect:/FPT/display-information-user";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/delete-user-role")
	public String deleteUserRole(@RequestParam("id_user_role") Long idUserRole,@RequestParam("id_user") Long idUser,RedirectAttributes redirectAttributes) {
		
		userRoleService.deleteUserRole(idUserRole);
		redirectAttributes.addAttribute("id_user", idUser);
		return "redirect:/FPT/display-information-user";
		
	}
}
