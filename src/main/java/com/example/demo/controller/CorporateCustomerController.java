package com.example.demo.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.ClassificationCustomer;
import com.example.demo.model.Customer;
import com.example.demo.model.IndustryField;
import com.example.demo.model.Menu;
import com.example.demo.model.User;
import com.example.demo.service.ClassificationCustomerService;
import com.example.demo.service.CorporateCustomerService;
import com.example.demo.service.IndustryFieldService;
import com.example.demo.service.MenuService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/FPT")
public class CorporateCustomerController {

	@Autowired
	private ClassificationCustomerService classificationCustomerService;

	@Autowired
	private IndustryFieldService industryFieldService;

	@Autowired
	private CorporateCustomerService corporateCustomerService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserService userService;
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/insert-corporate-customer")
	public String displayFormInsertCorporateCustomer(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		List<ClassificationCustomer> listClassificationCustomer = classificationCustomerService
				.displayClassificationCustomer();
		model.addAttribute("ClassificationCustomer", listClassificationCustomer);

		List<IndustryField> listIndustryField = industryFieldService.displayListIndustryField();
		model.addAttribute("listIndustryField", listIndustryField);

		List<Customer> listCorporateCustomer = corporateCustomerService.displayAllCorporateCustomer();
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);

		return "user/formInsertCorporateCustomer";
	}

	@Secured({"ROLE_DRT","ROLE_MNG"})
	@PostMapping("/insert-corporate-customer-process")
	public String insertCorporateCustomerProcess(@ModelAttribute CustomerDTO c, Model model) throws IOException {
		long checkExist = corporateCustomerService.insertCorporateCustomer(c);

		if (checkExist == 0) {
			return "redirect:/FPT/advanced-search-corporate-customer";
		} else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("checkExist", checkExist);
			return "user/formInsertCorporateCustomer";
		}
	}

	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/list-corporate-customer")
	public String displayListCorporateCustomer(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		List<Customer> listCorporateCustomer = corporateCustomerService.displayAllCorporateCustomer();
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);
		return "user/listCorporateCustomer";
	}

	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/search-corporate-customer-by-name")
	public String searchCorporateCustomer(@RequestParam("search") String search, Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		List<Customer> listCorporateCustomer = corporateCustomerService.searchCorporateCustomerByName(search);
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);
		return "user/listCorporateCustomer";
	}

	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/display-information-corporate-customer")
	public String displayCorporateCustomer(@RequestParam("id_customer") Long idCustomer, Model model) {
		Customer c = corporateCustomerService.findCorporateCustomerById(idCustomer);

		if (c.getIdParentCompany() == null) {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			IndustryField i = c.getIndustryField();
			String nameIdustryField = i.getNameIndustryField();
			model.addAttribute("corporateCustomer", c);
			model.addAttribute("nameIdustryField", nameIdustryField);
			return "user/informationCorporateCustomer";
		} else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			IndustryField i = c.getIndustryField();
			String nameIdustryField = i.getNameIndustryField();
			model.addAttribute("corporateCustomer", c);
			model.addAttribute("nameIdustryField", nameIdustryField);
			Customer parentCompany = corporateCustomerService.findCorporateCustomerById(c.getIdParentCompany());
			String nameParentCompany = parentCompany.getNameCustomer();
			model.addAttribute("nameParentCompany", nameParentCompany);
			return "user/informationCorporateCustomer";
		}
	}
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/update-corporate-customer")
	public String updateCorporateCustomer(@RequestParam("id_customer") Long idCustomer, Model model) {
		Customer c = corporateCustomerService.findCorporateCustomerById(idCustomer);
		if (c.getIdParentCompany() == null) {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			List<Customer> listParentCompany = corporateCustomerService.displayListCorporateCustomerExcept(idCustomer);
			model.addAttribute("listParentCompany", listParentCompany);

			List<ClassificationCustomer> listClassificationCustomer = classificationCustomerService
					.displayClassificationCustomer();
			model.addAttribute("listClassificationCustomer", listClassificationCustomer);

			ClassificationCustomer selectedClassificationCustomer = classificationCustomerService
					.findClassificationCustomerById(c.getClassificationCustomer());
			model.addAttribute("selectedClassificationCustomer", selectedClassificationCustomer);

			IndustryField selectedIndustryField = c.getIndustryField();
			model.addAttribute("selectedIndustryField", selectedIndustryField);

			List<IndustryField> listIndusList = industryFieldService.displayListIndustryField();
			model.addAttribute("listIndusList", listIndusList);

			IndustryField i = c.getIndustryField();
			String nameIdustryField = i.getNameIndustryField();
			model.addAttribute("corporateCustomer", c);
			model.addAttribute("nameIdustryField", nameIdustryField);

			return "user/updateCorporateCustomer";
		} else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			List<Customer> listParentCompany = corporateCustomerService.displayListCorporateCustomerExcept(idCustomer);
			model.addAttribute("listParentCompany", listParentCompany);

			List<ClassificationCustomer> listClassificationCustomer = classificationCustomerService
					.displayClassificationCustomer();
			model.addAttribute("listClassificationCustomer", listClassificationCustomer);

			ClassificationCustomer selectedClassificationCustomer = classificationCustomerService
					.findClassificationCustomerById(c.getClassificationCustomer());
			model.addAttribute("selectedClassificationCustomer", selectedClassificationCustomer);

			IndustryField selectedIndustryField = c.getIndustryField();
			model.addAttribute("selectedIndustryField", selectedIndustryField);

			List<IndustryField> listIndusList = industryFieldService.displayListIndustryField();
			model.addAttribute("listIndusList", listIndusList);

			IndustryField i = c.getIndustryField();
			String nameIdustryField = i.getNameIndustryField();
			model.addAttribute("corporateCustomer", c);
			model.addAttribute("nameIdustryField", nameIdustryField);
			Customer parentCompany = corporateCustomerService.findCorporateCustomerById(c.getIdParentCompany());
			model.addAttribute("parentCompany", parentCompany);
			return "user/updateCorporateCustomer";
		}

	}

	@Secured({"ROLE_DRT","ROLE_MNG"})
	@PostMapping("/update-corporate-customer-process")
	public String updateCorporateCustomerProcess(@ModelAttribute CustomerDTO c, RedirectAttributes redirectAttributes,
			Model model) {

		long checkExist = corporateCustomerService.updateCorporateCustomer(c);

		if (checkExist == 0) {
			redirectAttributes.addAttribute("id_customer", c.getIdCustomer());
			return "redirect:/FPT/display-information-corporate-customer";
		} else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("checkExist", checkExist);
			return "user/formInsertCorporateCustomer";
		}

	}

	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/update-logo-image")
	public String updateLogoImage(@RequestParam("id_customer") Long idCustomer, Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		model.addAttribute("idCustomer", idCustomer);
		return "user/formUpdateLogoImage";
	}

	@Secured({"ROLE_DRT","ROLE_MNG"})
	@PostMapping("/update-logo-image-process")
	public String updateLogoImageProcess(@ModelAttribute CustomerDTO c, RedirectAttributes redirectAttributes)
			throws IOException {
		corporateCustomerService.updateLogoImage(c);
		redirectAttributes.addAttribute("id_customer", c.getIdCustomer());
		return "redirect:/FPT/display-information-corporate-customer";
	}

	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/advanced-search-corporate-customer")
	public String advancedSearchCorporateCustomer(Model model) {
		
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		List<Customer> listCorporateCustomer = corporateCustomerService.displayAllCorporateCustomer();
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);

		List<IndustryField> listIndustryField = industryFieldService.displayListIndustryField();
		model.addAttribute("listIndustryField", listIndustryField);

		return "user/advancedSearchCorporateCustomer";
	
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/advanced-search-corporate-customer-by-enterprise-indentification-number")
	public String advancedSearchCorporateCustomerByEnterpriseIdentificationNumber(@ModelAttribute CustomerDTO c,
			Model model) {
		
		
		String enterpriseIdentificationNumber = c.getEnterpriseIdentificationNumber();
		List<Customer> listCorporateCustomer = corporateCustomerService
				.advancedSearchCorporateByEnterpriseIdentificationNumber(enterpriseIdentificationNumber);

		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		model.addAttribute("listCorporateCustomer", listCorporateCustomer);
		return "user/advancedSearchCorporateCustomer";
	}

	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/advanced-search-corporate-customer-by-company-scale")
	public String advancedSearchCorporateCustomerByCompanyScale(@RequestParam("id_company_scale") Long idCompanyScale,
			Model model) {

		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		List<Customer> listCorporateCustomer = corporateCustomerService
				.advancedSearchCorporateCustomerByCompanyScale(idCompanyScale);
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);

		List<IndustryField> listIndustryField = industryFieldService.displayListIndustryField();
		model.addAttribute("listIndustryField", listIndustryField);

		return "user/advancedSearchCorporateCustomer";
	}

	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/advanced-search-corporate-customer-by-industry-field")
	public String advancedSearchCorporateCustomerByIndustryField(
			@RequestParam("id_industry_field") Long idIndustryField, Model model) {

		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		List<Customer> listCorporateCustomer = corporateCustomerService
				.advancedSearchCorporateCustomerByIndustryField(idIndustryField);
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);

		List<IndustryField> listIndustryField = industryFieldService.displayListIndustryField();
		model.addAttribute("listIndustryField", listIndustryField);

		return "user/advancedSearchCorporateCustomer";
	}

	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/advanced-search-corporate-customer-by-customer-status")
	public String advancedSearchCorporateCustomerByCustomerStatus(
			@RequestParam("id_customer_status") Long idCustomerStatus, Model model) {

		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		List<Customer> listCorporateCustomer = corporateCustomerService
				.advancedSearchCorporateCustomerByCustomerStatus(idCustomerStatus);
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);

		List<IndustryField> listIndustryField = industryFieldService.displayListIndustryField();
		model.addAttribute("listIndustryField", listIndustryField);

		return "user/advancedSearchCorporateCustomer";
	}


	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/lock-corporate-customer")
	public String lockCorporateCustomer(@RequestParam("id_customer") Long idCustomer, Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		corporateCustomerService.lockCorporateCustomer(idCustomer);
		return "redirect:/FPT/advanced-search-corporate-customer";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/open-corporate-customer")
	public String openCorporateCustomer(@RequestParam("id_customer") Long idCustomer, Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		corporateCustomerService.openCorporateCustomer(idCustomer);
		return "redirect:/FPT/display-all-corporate-customer-deleted";
	}
}
