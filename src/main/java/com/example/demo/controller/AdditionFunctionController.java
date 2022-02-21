package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ContractAndInformationOfCustomer;
import com.example.demo.model.Customer;
import com.example.demo.model.Menu;
import com.example.demo.model.User;
import com.example.demo.service.ContractService;
import com.example.demo.service.CorporateCustomerService;
import com.example.demo.service.MenuService;
import com.example.demo.service.PersonalCustomerService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/FPT")
public class AdditionFunctionController {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private PersonalCustomerService personalCustomerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CorporateCustomerService corporateCustomerService;
	
	@Autowired
	private ContractService contractService;
	
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/display-all-personal-deleted")
	public String displayAllPersonalCustomerDeleted(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<Customer> listPersonalCustomer = personalCustomerService.listPersonalCustomerLocked();
		model.addAttribute("listPersonalCustomer", listPersonalCustomer);
		return "user/listPersonalCustomer";
	}
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/display-all-corporate-customer-deleted")
	public String displayAllCorporateCustomerDeleted(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<Customer> listCorporateCustomer = corporateCustomerService.displayListCorporateCustomerLocked();
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);
				
		return "user/listCorporateCustomer";
	}
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/display-all-contract-deleted")
	public String displayAllContractDeleted(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<ContractAndInformationOfCustomer> listContract = contractService.displayAllContractLocked();
		model.addAttribute("listContract", listContract);
		return "user/listContractStatistic";

	}
}
