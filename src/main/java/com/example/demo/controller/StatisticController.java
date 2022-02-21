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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.ContractAndInformationOfCustomer;
import com.example.demo.dto.StatisticCount;
import com.example.demo.dto.StatisticCountEmployeeByDepartment;
import com.example.demo.dto.UserAndInformation;
import com.example.demo.model.Customer;
import com.example.demo.model.Menu;
import com.example.demo.model.User;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import com.example.demo.service.CorporateCustomerService;
import com.example.demo.service.MenuService;
import com.example.demo.service.PersonalCustomerService;
import com.example.demo.service.StatisticService;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/FPT")
public class StatisticController {

	@Autowired
	private PersonalCustomerService personalCustomerService;
	
	@Autowired
	private StatisticService statisticService;
	
	@Autowired
	private CorporateCustomerService corporateCustomerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private MenuService menuService;
	/**
	 * statistic of customer
	 * @param model
	 * @return
	 */
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/statistic-customer")
	public String statisticCustomer(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		// personal customer
		StatisticCount totalPersonalCustomer = statisticService.countTotalPersonalCustomer();
		model.addAttribute("totalPersonalCustomer", totalPersonalCustomer);
		
		StatisticCount totalPersonalCustomerHasNotActived = statisticService.countPersonalCustomerHasNotActived();
		model.addAttribute("totalPersonalCustomerHasNotActived", totalPersonalCustomerHasNotActived);
		
		StatisticCount totalPersonalCustomerActived = statisticService.countPersonalCustomerActived();
		model.addAttribute("totalPersonalCustomerActived", totalPersonalCustomerActived);
		
		StatisticCount totalPersonalCustomerLocked = statisticService.countPersonalCustomerLocked();
		model.addAttribute("totalPersonalCustomerLocked", totalPersonalCustomerLocked);
		
		//corporate customer
		StatisticCount totalCorporateCustomer = statisticService.countAllCorporateCustomer();
		model.addAttribute("totalCorporateCustomer", totalCorporateCustomer);
		
		StatisticCount totalCorporateCustomerHasNotActived = statisticService.countAllCorporateCustomerHasNotActived();
		model.addAttribute("totalCorporateCustomerHasNotActived", totalCorporateCustomerHasNotActived);
		
		StatisticCount totalCorporateCustomerActived = statisticService.countAllCorporateCustomerActived();
		model.addAttribute("totalCorporateCustomerActived", totalCorporateCustomerActived);
		
		StatisticCount totalCorporateCustomerLocked = statisticService.countAllCorporateCustomerLocked();
		model.addAttribute("totalCorporateCustomerLocked", totalCorporateCustomerLocked);
		
		return "user/statisticCustomer";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/all-personal-customer-statistic")
	public String displayAllPersonalCustomerStatistic(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<Customer> listPersonalCustomer = personalCustomerService.displayAllPersonalCustomer();
		model.addAttribute("listPersonalCustomer", listPersonalCustomer);
		return "user/listPersonalCustomer";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/all-personal-customer-has-not-actived")
	public String displayAllPersonalCustomerHasNotActived(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<Customer> listPersonalCustomer = personalCustomerService.listPersonalCustomerHasNotActived();
		model.addAttribute("listPersonalCustomer", listPersonalCustomer);
		return "user/listPersonalCustomer";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/all-personal-customer-actived")
	public String displayAllPersonalCustomerActived(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<Customer> listPersonalCustomer = personalCustomerService.listPersonalCustomerActived();
		model.addAttribute("listPersonalCustomer", listPersonalCustomer);
		return "user/listPersonalCustomer";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/all-personal-customer-locked")
	public String displayAllPersonalCustomerLocked(Model model) {
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
	@GetMapping("/all-corporate-customer")
	public String displayAllCorporateCustomer(Model model) {
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
	@GetMapping("/all-corporate-customer-has-not-actived")
	public String displayAllCorporateCustomerHasNotActived(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<Customer> listCorporateCustomer = corporateCustomerService.displayListCorporateCustomerHasNotActived();
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);
				
		return "user/listCorporateCustomer";
	}
	
	@GetMapping("/all-corporate-customer-actived")
	public String displayAllCorporateCustomerActived(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<Customer> listCorporateCustomer = corporateCustomerService.displayListCorporateCustomerActived();
		model.addAttribute("listCorporateCustomer", listCorporateCustomer);
				
		return "user/listCorporateCustomer";
	}
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/all-corporate-customer-locked")
	public String displayAllCorporateCustomerLocked(Model model) {
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
	
	/**
	 * END
	 */
	
	
	
	/**
	 * Statistic of Employee
	 */
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/statistic-employee")
	public String statisticEmployee(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		//
		StatisticCount totalEmployee = statisticService.countAllEmployee();
		model.addAttribute("totalEmployee", totalEmployee);
		
		StatisticCount totalEmployeeHasNotHadAccount = statisticService.countAllEmployeeHasNotHadAccount();
		model.addAttribute("totalEmployeeHasNotHadAccount", totalEmployeeHasNotHadAccount);
		
		StatisticCount totalEmployeeHasAccount = statisticService.countAllEmployeeHasAccount();
		model.addAttribute("totalEmployeeHasAccount", totalEmployeeHasAccount);
		
		StatisticCount totalEmployeeLocked = statisticService.countAllEmployeeLocked();
		model.addAttribute("totalEmployeeLocked", totalEmployeeLocked);
		
		
		//count employee by department
		
		List<StatisticCountEmployeeByDepartment> totalEmployeeByDepartment = statisticService.countAllEmployeeByDepartment();
		model.addAttribute("totalEmployeeByDepartment", totalEmployeeByDepartment);
		
		return "user/statisticEmployee";
		
	}
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/all-employee")
	public String displayAllEmployee(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<UserAndInformation> listUser = userService.displayAllUser();
		model.addAttribute("listUser", listUser);
		return "user/listStatisticUser";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/all-employee-has-not-had-account")
	public String displayAllEmployeeHasNotHadAccount(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<UserAndInformation> listUser = userService.displayAllUserHasNotHadAccount();
		model.addAttribute("listUser", listUser);
		return "user/listStatisticUser";
	}
	
	
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/all-employee-has-account")
	public String displayAllEmployeeHasAccount(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<UserAndInformation> listUser = userService.displayAllUserHasAccount();
		model.addAttribute("listUser", listUser);
		return "user/listStatisticUser";
	}
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/all-employee-locked")
	public String displayAllEmployeeLoked(Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<UserAndInformation> listUser = userService.displayAllUserLocked();
		model.addAttribute("listUser", listUser);
		return "user/listStatisticUser";
	}
	
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/all-employee-by-department")
	public String displayAllEmployeeByDepartment(@RequestParam("name_department") String nameDepartment,Model model) {
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<UserAndInformation> listUser = userService.displayAllUserByDepartment(nameDepartment);
		model.addAttribute("listUser", listUser);
		return "user/listStatisticUser";
	}
	
	
	/**
	 * END
	 */
	
	
	/**
	 * Statistic of contract
	 */
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/statistic-of-contract")
	public String statisticContract(Model model) {	
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		StatisticCount totalContract = statisticService.countAllContract();
		model.addAttribute("totalContract", totalContract);
		
		StatisticCount totalContractShortTermTime = statisticService.countAllContractShortTermTime();
		model.addAttribute("totalContractShortTermTime", totalContractShortTermTime);
		
		StatisticCount totalContractLongTermTime = statisticService.countAllContractLongTermTime();
		model.addAttribute("totalContractLongTermTime", totalContractLongTermTime);
		
		StatisticCount totalContractLocked = statisticService.countAllContractLoked();
		model.addAttribute("totalContractLocked", totalContractLocked);
		
		return "user/statisticContract";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/statistic-all-contract")
	public String displayAllContractStatistic(Model model) {	
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<ContractAndInformationOfCustomer> listContract = contractService.displayAllContract();
		model.addAttribute("listContract", listContract);
		return "user/listContractStatistic";
	}
	
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/statistic-all-contract-short-term-time")
	public String displayAllContractStatisticShortTermTime(Model model) {	
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<ContractAndInformationOfCustomer> listContract = contractService.displayAllContractShortTermTime();
		model.addAttribute("listContract", listContract);
		return "user/listContractStatistic";
	}
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/statistic-all-contract-long-term-time")
	public String displayAllContractStatisticLongTermTime(Model model) {	
		List<Menu> listMenu = menuService.displayListMenu();
		model.addAttribute("listMenu", listMenu);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String email = userDetails.getUsername();
		User u = userService.displayInformationOfUserByEmailAccount(email);
		model.addAttribute("user", u);
		
		List<ContractAndInformationOfCustomer> listContract = contractService.displayAllContractLongTermTime();
		model.addAttribute("listContract", listContract);
		return "user/listContractStatistic";
	}
	@Secured({"ROLE_DRT","ROLE_MNG","ROLE_STF"})
	@GetMapping("/statistic-all-contract-locked")
	public String displayAllContractStatisticLocked(Model model) {	
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
	/**
	 * AND
	 */
}
