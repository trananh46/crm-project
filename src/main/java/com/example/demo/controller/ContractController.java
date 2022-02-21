package com.example.demo.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ContractAndInformationOfCustomer;
import com.example.demo.dto.ContractDTO;
import com.example.demo.model.Contract;
import com.example.demo.model.Customer;
import com.example.demo.model.Menu;
import com.example.demo.model.TypeOfContract;
import com.example.demo.model.User;
import com.example.demo.service.ContractService;
import com.example.demo.service.CorporateCustomerService;
import com.example.demo.service.MenuService;
import com.example.demo.service.TypeOfContractService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/FPT")
public class ContractController {

	@Autowired
	private CorporateCustomerService corporateCustomerService;
	
	@Autowired
	private TypeOfContractService typeOfContractService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private UserService userService;
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/insert-contract")
	public String displayFormInsertContract(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<Customer> listCorporateCustomer = corporateCustomerService.displayAllCorporateCustomer();
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);
		
		List<TypeOfContract> listTypeOfContract = typeOfContractService.displayListTypeOfContract();
		model.addAttribute("listTypeOfContract", listTypeOfContract);
		
		
		return "user/formInsertContract";
	}
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@PostMapping("/insert-contract-process")
	public String inserContract(@ModelAttribute ContractDTO c,Model model) throws IOException {
		
		long checkExist = contractService.insertContract(c);
		
		if(checkExist == 0) {
			return "redirect:/FPT/list-contract";
		}else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("checkExist", checkExist);
			return "user/formInsertContract";
		}
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/list-contract")
	public String displayListContract(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<ContractAndInformationOfCustomer> listContracts = contractService.displayListContract();
		model.addAttribute("listContract", listContracts);
		return "user/listContract";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/list-contract-by-id-customer")
	public String displayListContractByIdCustomer(@RequestParam("id_customer") Long idCustomer,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<ContractAndInformationOfCustomer> listContracts = contractService.displayListContractByIdCustomer(idCustomer);
		model.addAttribute("listContract", listContracts);
		return "user/listContract";
	}
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/search-contract-by-contract-number")
	public String searchContractByContractNumber(@Param("search") String search,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<ContractAndInformationOfCustomer> listContracts = contractService.searchContractByContractNumber(search);
		model.addAttribute("listContract", listContracts);
		return "user/listContract";
	}
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/display-contract-information")
	public String displayContractInformation(@RequestParam("id_contract") Long idContract,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		ContractAndInformationOfCustomer contract = contractService.displayContractInformation(idContract);
		model.addAttribute("contract", contract);
		return "user/informationContract";
	}
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/update-contract")
	public String displayFormUpdateContract(@RequestParam("id_contract") Long idContract,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		ContractAndInformationOfCustomer contract = contractService.displayContractInformation(idContract);
		model.addAttribute("contract", contract);
		
		List<Customer> listCorporateCustomer = corporateCustomerService.displayAllCorporateCustomer();
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);
		
		List<TypeOfContract> listTypeOfContract = typeOfContractService.displayListTypeOfContract();
		model.addAttribute("listTypeOfContract", listTypeOfContract);
		
		
		return "user/formUpdateContract";
	}
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@PostMapping("/update-contract-process")
	public String updateContractProcess(@ModelAttribute ContractDTO c,RedirectAttributes redirectAttributes,Model model) {
		
		long checkExist = contractService.updateContract(c);
		if(checkExist == 0) {
			redirectAttributes.addAttribute("id_contract", c.getIdContract());
			return "redirect:/FPT/display-contract-information";
		
		}else {
		
			
			redirectAttributes.addAttribute("id_contract", c.getIdContract());
			redirectAttributes.addAttribute("checkExist",checkExist);
			return "redirect:/FPT/update-contract-error";
		}
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/update-contract-error")
	public String displayFormUpdateContractError(@RequestParam("id_contract") Long idContract,@RequestParam("checkExist") Long checkExist,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		ContractAndInformationOfCustomer contract = contractService.displayContractInformation(idContract);
		model.addAttribute("contract", contract);
		
		List<Customer> listCorporateCustomer = corporateCustomerService.displayAllCorporateCustomer();
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);
		
		List<TypeOfContract> listTypeOfContract = typeOfContractService.displayListTypeOfContract();
		model.addAttribute("listTypeOfContract", listTypeOfContract);
		
		model.addAttribute("checkExist", checkExist);
		
		return "user/formUpdateContract";
	}
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/update-attached-file-contract")
	public String displayFormUpdateAttachedFile(@RequestParam("id_contract") Long idContract,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		Contract c = contractService.findContractById(idContract);
		String attachedFile = c.getAttachedFile();
		model.addAttribute("contract", c);
		return "user/formUpdateAttachedFileContract";
	}
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@PostMapping("/update-attached-file-contract-process")
	public String displayFormUpdateAttachedFileProcess(@ModelAttribute ContractDTO c,RedirectAttributes redirectAttributes) throws IOException {
		contractService.updateAttachedFileContract(c);
		
		redirectAttributes.addAttribute("id_contract",c.getIdContract());
		return "redirect:/FPT/display-contract-information";
	}
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/delete-contract")
	public String deleteContract(@RequestParam("id_contract") Long idContract) {
		contractService.deleteContractById(idContract);
		return "redirect:/FPT/list-contract";
	}
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/open-contract")
	public String openContract(@RequestParam("id_contract") Long idContract) {
		contractService.openContractById(idContract);
		return "redirect:/FPT/display-all-contract-deleted";
	}
}
