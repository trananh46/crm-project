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

import com.example.demo.model.Customer;
import com.example.demo.model.IndustryField;
import com.example.demo.model.Menu;
import com.example.demo.model.User;
import com.example.demo.service.CorporateCustomerService;
import com.example.demo.service.IndustryFieldService;
import com.example.demo.service.MenuService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/FPT")
public class IndustryFieldController {

	@Autowired
	private IndustryFieldService industryFieldService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CorporateCustomerService corporateCustomerService;
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/insert-industry-field")
	public String displayFormInsertIndustryField(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		return "user/formInsertIndustryField";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/insert-industry-field-process")
	public String insertFormIndustryFieldProcess(@ModelAttribute IndustryField i,Model model) {
		long checkExist = industryFieldService.insertIndustryField(i);
		
		if(checkExist == 0) {
			return "redirect:/FPT/list-industry-field";
		}else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("checkExist", checkExist);
			return "user/formInsertIndustryField";
		}
		
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/list-industry-field")
	public String displayListIndustryField(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<IndustryField> listIndustryField = industryFieldService.displayListIndustryField();
		model.addAttribute("listIndustryField", listIndustryField);
		return "user/listIndustryField";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/update-industry-field")
	public String displayFormUpdateIndustryField(@RequestParam("id_industry_field") Long idIndustryField,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		IndustryField i = industryFieldService.findIndustryFieldById(idIndustryField);
		model.addAttribute("industryField", i);
		return "user/formUpdateIndustryField";
		
	}
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/update-industry-field-process")
	public String updateIndustryFieldProcess(@ModelAttribute IndustryField i,Model model) {
		long checkExist = industryFieldService.updateIndustryField(i);
		if(checkExist == 0) {
			return "redirect:/FPT/list-industry-field";
		}else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("checkExist", checkExist);
			return "user/formUpdateIndustryField";
		}
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/delete-industry-field")
	public String deleteIndustryField(@RequestParam("id_industry_field") Long idIndustryField) {
		industryFieldService.deleteIndustryFieldById(idIndustryField);
		return "redirect:/FPT/list-industry-field";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/list-corporate-customer-by-id-industry-field")
	public String displayListCorporateCustomerByIdIndustryField(@RequestParam("id_industry_field") Long idIndustryField,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		List<Customer> listCorporateCustomer = corporateCustomerService.displayAllCorporateCustomerByIdIndustryFiled(idIndustryField);
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);

		List<IndustryField> listIndustryField = industryFieldService.displayListIndustryField();
		model.addAttribute("listIndustryField", listIndustryField);
		
		return "user/advancedSearchCorporateCustomer";

	}
}
