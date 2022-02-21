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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.AccountAndInformation;
import com.example.demo.model.Account;
import com.example.demo.model.Menu;
import com.example.demo.model.User;
import com.example.demo.service.AccountService;
import com.example.demo.service.MenuService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/FPT")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserService userService;
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/account_employee")
	public String displayListAccount(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<AccountAndInformation> listAccount = accountService.displayListAccount();
		model.addAttribute("listAccount", listAccount);
		return "user/listAccount";
	}

	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/insert_account")
	public String displayFormInsertAccount(@RequestParam("id_user") Long idUser, Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		model.addAttribute("idUser", idUser);
		return "user/formInsertAccount";
	}

	@Secured({"ROLE_DRT","ROLE_MNG"})
	@PostMapping("/insert_account_process")
	public String insertAccount(@ModelAttribute Account account, RedirectAttributes redirectAttributes, Model model) {

		long checkExist = accountService.insertAccount(account);
		if (checkExist == 0) {
			redirectAttributes.addAttribute("id_user", account.getIdUser());
			return "redirect:/FPT/display-information-user";
		} else {
			List<Menu> listMenu = menuService.displayListMenu();
			model.addAttribute("listMenu", listMenu);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String email = userDetails.getUsername();
			User u = userService.displayInformationOfUserByEmailAccount(email);
			model.addAttribute("user", u);

			model.addAttribute("account", account);
			model.addAttribute("checkExist", checkExist);
			return "user/formInsertAccountError";
		}
	}

	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/lock-account")
	public String lockAccount(@RequestParam("id_account") Long idAccount, RedirectAttributes redirectAttributes) {
		accountService.lockAccount(idAccount);
		Account a = accountService.findAccountById(idAccount);

		redirectAttributes.addAttribute("id_user", a.getIdUser());
		return "redirect:/FPT/display-information-user";
	}

	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/open-account")
	public String openAccount(@RequestParam("id_account") Long idAccount, RedirectAttributes redirectAttributes) {
		accountService.openAccount(idAccount);
		Account a = accountService.findAccountById(idAccount);

		redirectAttributes.addAttribute("id_user", a.getIdUser());
		return "redirect:/FPT/display-information-user";
	}

	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/update-account")
	public String updatePasswordAccount(@RequestParam("id_account") Long idAccount, Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		Account a = accountService.findAccountById(idAccount);
		model.addAttribute("account", a);
		return "user/formUpdatedAccount";

	}

	@Secured({"ROLE_DRT","ROLE_MNG"})
	@PostMapping("/update-account-process")
	public String updatePasswordAccount(Account a, RedirectAttributes redirectAttributes) {
		accountService.updateAccount(a);
		redirectAttributes.addAttribute("id_user", a.getIdUser());
		return "redirect:/FPT/display-information-user";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG"})
	@GetMapping("/search-account")
	public String searchAccountByEmail(@RequestParam("search") String search,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<AccountAndInformation> listAccount = accountService.searchAccountByEmail(search);
		model.addAttribute("listAccount", listAccount);
		return "user/listAccount";
	}
	
	
}
