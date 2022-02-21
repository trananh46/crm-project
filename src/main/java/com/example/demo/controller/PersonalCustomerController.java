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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.BirthPlace;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.Nationality;
import com.example.demo.model.ClassificationCustomer;
import com.example.demo.model.Customer;
import com.example.demo.model.Menu;
import com.example.demo.model.User;
import com.example.demo.service.ClassificationCustomerService;
import com.example.demo.service.PersonalCustomerService;
import com.example.demo.service.UserService;
import com.example.demo.service.MenuService;

@Controller
@RequestMapping("/FPT")
public class PersonalCustomerController {

	@Autowired
	private ClassificationCustomerService classificationCustomerService;

	@Autowired
	private PersonalCustomerService personalCustomerService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserService userService;
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/insert-personal-customer")
	public String displayFormInsertPersonalCustomer(Model model) {

		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		List<ClassificationCustomer> c = classificationCustomerService.displayClassificationCustomer();
		model.addAttribute("listClassificationCustomer", c);
		return "user/formInsertPersonalCustomer";
	}

	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@PostMapping("/insert-personal-customer-process")
	public String insertPersonalCustomerProcess(@ModelAttribute CustomerDTO c, Model model) {
		long a = personalCustomerService.insertPersonalCustomer(c);

		if (a == 0) {
			return "redirect:/FPT/advanced-search-personal-customer";

		} else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			model.addAttribute("checkExist", a);
			return "user/formInsertPersonalCustomer";

		}
	}

	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/display-list-personal-customer")
	public String displayListPersonalCustomer(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		List<Customer> listPersonalCustomer = personalCustomerService.displayListPersonalCustomer();
		model.addAttribute("listPersonalCustomer", listPersonalCustomer);
		return "user/listPersonalCustomer";
	}

	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/display-information-personal-customer")
	public String displayInformationPersonalCustomer(@RequestParam("id_customer") Long idCustomer, Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		Customer c = personalCustomerService.findCustomerById(idCustomer);
		model.addAttribute("personalCustomer", c);
		return "user/informationPersonalCustomer";
	}

	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/update-personal-customer")
	public String updatePersonalCustomer(@RequestParam("id_customer") Long idCustomer, Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		Customer c = personalCustomerService.findCustomerById(idCustomer);
		model.addAttribute("personalCustomer", c);

		List<ClassificationCustomer> listClassificationCustomer = classificationCustomerService
				.displayClassificationCustomer();
		model.addAttribute("listClassificationCustomer", listClassificationCustomer);

		ClassificationCustomer selectedClassificationCustomer = classificationCustomerService
				.findClassificationCustomerById(c.getClassificationCustomer());
		model.addAttribute("selectedClassificationCustomer", selectedClassificationCustomer);
		return "user/formUpdatePersonalCustomer";
	}

	@Secured({"ROLE_DRT","ROLE_MNG"})
	@PostMapping("/update-personal-customer-process")
	public String updatePersonalCustomerProcess(@ModelAttribute CustomerDTO c, RedirectAttributes redirectAttributes,
			Model model) {

		long checkExist = personalCustomerService.updatePersonalCustomer(c);
		if (checkExist == 0) {
			redirectAttributes.addAttribute("id_customer", c.getIdCustomer());
			return "redirect:/FPT/display-information-personal-customer";
		} else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);
			
			Customer c1 = personalCustomerService.findCustomerById(c.getIdCustomer());

			List<ClassificationCustomer> listClassificationCustomer = classificationCustomerService
					.displayClassificationCustomer();
			model.addAttribute("listClassificationCustomer", listClassificationCustomer);

			ClassificationCustomer selectedClassificationCustomer = classificationCustomerService
					.findClassificationCustomerById(c1.getClassificationCustomer());
			model.addAttribute("selectedClassificationCustomer", selectedClassificationCustomer);

			model.addAttribute("personalCustomer", c1);
			model.addAttribute("checkExist", checkExist);

			return "user/formUpdatePersonalCustomer";
		}
	}

	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@RequestMapping("/search-personal-customer-by-name")
	public String searchPersonalCustomerByName(@RequestParam("search") String search, Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		String nameCustomer = search.toUpperCase();
		List<Customer> listCustomer = personalCustomerService.searchPersonalCustomerByName(nameCustomer);
		model.addAttribute("listPersonalCustomer", listCustomer);
		return "user/listPersonalCustomer";
	}

	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@RequestMapping("/advanced-search-personal-customer")
	public String advancedSearchPersonalCustomer(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		List<Customer> listPersonalCustomer = personalCustomerService.displayListPersonalCustomer();
		model.addAttribute("listPersonalCustomer", listPersonalCustomer);

		List<Nationality> listNationalityPersonalCustomer = personalCustomerService
				.displayListNationalityPersonalCustomer();
		model.addAttribute("listNationalityPersonalCustomer", listNationalityPersonalCustomer);

		List<BirthPlace> listBirthPlacePersonalCustomer = personalCustomerService
				.displayListBirthPlacePersonalCustomer();
		model.addAttribute("listBirthPlacePersonalCustomer", listBirthPlacePersonalCustomer);

		return "user/advancedSearchPersonalCustomer";

	}

	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@RequestMapping("/advanced-search-personal-customer-process")
	public String advancedSearchPersonalCustomerProcess(@ModelAttribute Customer c, Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);

		List<Customer> listPersonalCustomer = personalCustomerService.advancedSearchPersonalCustomer(c);
		model.addAttribute("listPersonalCustomer", listPersonalCustomer);

		List<Nationality> listNationalityPersonalCustomer = personalCustomerService
				.displayListNationalityPersonalCustomer();
		model.addAttribute("listNationalityPersonalCustomer", listNationalityPersonalCustomer);

		List<BirthPlace> listBirthPlacePersonalCustomer = personalCustomerService
				.displayListBirthPlacePersonalCustomer();
		model.addAttribute("listBirthPlacePersonalCustomer", listBirthPlacePersonalCustomer);

		return "user/advancedSearchPersonalCustomer";

	}

	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/lock-personal-customer")
	public String lockPersonalCustomer(@RequestParam("id_customer") Long idCustomer) {
		personalCustomerService.lockPersonalCustomer(idCustomer);
		return "redirect:/FPT/advanced-search-personal-customer";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/open-personal-customer")
	public String openPersonalCustomer(@RequestParam("id_customer") Long idCustomer,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		personalCustomerService.openPersonalCustomer(idCustomer);
		return "redirect:/FPT/display-all-personal-deleted";
	}
}
