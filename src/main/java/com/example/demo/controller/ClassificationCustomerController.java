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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.ClassificationCustomer;
import com.example.demo.model.Menu;
import com.example.demo.model.User;
import com.example.demo.service.ClassificationCustomerService;
import com.example.demo.service.MenuService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/FPT")
public class ClassificationCustomerController {

	@Autowired
	private ClassificationCustomerService classificationCustomerService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list-classifition-customer")
	public String displayListClassificationCustomer(Model model) {
//		List<Menu> listMenu = menuService.displayListMenu();
//		model.addAttribute("listMenu", listMenu);
//		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//		String email = userDetails.getUsername();
//		User u = userService.displayInformationOfUserByEmailAccount(email);
//		model.addAttribute("user", u);
		
		List<ClassificationCustomer> listClassificationCustomer = classificationCustomerService.displayClassificationCustomer();
		model.addAttribute("listClassificationCustomer", listClassificationCustomer);
		return "user/listClassificationCustomer";
	}
	
	@GetMapping("/insert-classification-customer")
	public String displayFormInsertClassificationCustomer(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		return "user/formInsertClassificationCustomer";
	}
	
	@GetMapping("/insert-classification-customer-process")
	public String insertClassificationCustomerProcess(@ModelAttribute ClassificationCustomer c,Model model) {
		long checkExist = classificationCustomerService.insertClassificationCustomer(c);
		if(checkExist == 0) {
			return "redirect:/FPT/list-classifition-customer";
		}else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("checkExist", checkExist);
			return "user/formInsertClassificationCustomer";
		}
	}
	
	@GetMapping("/update-classification-customer")
	public String displayFormUpdateClassificationCustomer(@RequestParam("id_classification_customer") Long idClassificationCustomer,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		ClassificationCustomer c = classificationCustomerService.findClassificationCustomerById(idClassificationCustomer);
		model.addAttribute("classificationCustomer", c);
		return "user/formUpdateClassificationCustomer";
	}
	
	@GetMapping("/update-classification-customer-process")
	public String updateClassificationCustomer(@ModelAttribute ClassificationCustomer c,Model model) {
		long checkExist = classificationCustomerService.updateClassificationCustomer(c);
		if(checkExist == 0) {
			return "redirect:/FPT/list-classifition-customer";
		}else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("checkExist", checkExist);
			return "user/formUpdateClassificationCustomer";
		}
	}
	
	
	@GetMapping("/delete-classification-customer")
	public String deleteClassificationCustomer(@RequestParam("id_classification_customer") Long idClassificationCustomer) {
		classificationCustomerService.deleteClassificationCustomer(idClassificationCustomer);
		return "redirect:/FPT/list-classifition-customer";
	}
}
