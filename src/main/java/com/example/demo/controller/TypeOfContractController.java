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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.ContractAndInformationOfCustomer;
import com.example.demo.model.Contract;
import com.example.demo.model.Menu;
import com.example.demo.model.TypeOfContract;
import com.example.demo.model.User;
import com.example.demo.service.MenuService;
import com.example.demo.service.TypeOfContractService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/FPT")
public class TypeOfContractController {

	@Autowired
	private TypeOfContractService typeOfContractService;	
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/form-insert-type-of-contract")
	public String displayFormInsertTypeOfContract(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		return "user/formInsertTypeOfContract";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/insert-process")
	public String insertTypeOfContract(@ModelAttribute TypeOfContract t,Model model) {

		long checkExist = typeOfContractService.insertTypeOfContract(t);
		if(checkExist == 0) {
			return "redirect:/FPT/list-type-of-contract";
		}else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("checkExist", checkExist);
			return "user/formInsertTypeOfContract";
		}
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/list-type-of-contract")
	public String listTypeOfContract(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<TypeOfContract> listTypeOfContract = typeOfContractService.displayListTypeOfContract();
		model.addAttribute("listTypeOfContract", listTypeOfContract);
		return "user/listTypeOfContract";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/update-type-of-contract")
	public String displayFormUpdateTypeOfContract(@RequestParam("id_type_of_contract") Long idTypeOfContract,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		TypeOfContract t = typeOfContractService.findTypeOfContractById(idTypeOfContract);
		model.addAttribute("typeOfContract", t);
		return "user/formUpdateTypeOfContract";
		
	}
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/update-type-of-contract-process")
	public String updateTypeOfContractProcess(@ModelAttribute TypeOfContract t,Model model) {
		long checkExist = typeOfContractService.updateTypeOfContract(t);
		if(checkExist == 0) {
			return "redirect:/FPT/list-type-of-contract";
		}else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("checkExist", checkExist);
			return "user/formUpdateTypeOfContract";
		}	
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/delete-type-of-contract")
	public String deleteTypeOfContract(@RequestParam("id_type_of_contract") Long idTypeOfContract) {
		typeOfContractService.deleteTypeOfContract(idTypeOfContract);
		return "redirect:/FPT/list-type-of-contract";
	}
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/list-contract-by-id-type-of-contract")
	public String displayListContractByIdTypeOfContract(@RequestParam("id_type_of_contract") Long idTypeOfContract,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<ContractAndInformationOfCustomer> listContracts = typeOfContractService.displayListContractByIdTypeOfContract(idTypeOfContract);
		model.addAttribute("listContract", listContracts);
		
		return "user/listContract";
	}
}
