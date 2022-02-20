package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StatisticCount;
import com.example.demo.dto.StatisticCountEmployeeByDepartment;
import com.example.demo.repository.ContractRepository;
import com.example.demo.repository.CorporateCustomerRepository;
import com.example.demo.repository.PersonalCustomerRepository;
import com.example.demo.repository.UserRepository;

@Service
public class StatisticService {
	
	@Autowired
	private PersonalCustomerRepository personalCustomerRepository;

	@Autowired
	private CorporateCustomerRepository corporateCustomerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContractRepository contractRepository;
	
	/**
	 * statistic of customer
	 * @return
	 */
	
	public StatisticCount countTotalPersonalCustomer() {
		StatisticCount totalPersonalCustomer = personalCustomerRepository.countTotalPersonalCustomer();
		return totalPersonalCustomer;
	}
	
	public StatisticCount countPersonalCustomerHasNotActived() {
		StatisticCount totalPersonalCustomerHasNotActived = personalCustomerRepository.countPersonalCustomerHasNotActived();
		return totalPersonalCustomerHasNotActived;
	}
	
	public StatisticCount countPersonalCustomerActived() {
		StatisticCount totalPersonalCustomerActived = personalCustomerRepository.countPersonalCustomerActived();
		return totalPersonalCustomerActived;
	}
	
	public StatisticCount countPersonalCustomerLocked() {
		StatisticCount totalPersonalCustomerActived = personalCustomerRepository.countPersonalCustomerLocked();
		return totalPersonalCustomerActived;
	}
	
	
	public StatisticCount countAllCorporateCustomer() {
		StatisticCount totalCorporateCustomer = corporateCustomerRepository.countAllCorporateCustomer();
		return totalCorporateCustomer;
	}
	
	public StatisticCount countAllCorporateCustomerHasNotActived(){
		StatisticCount totalCorporateCustomerHasNoteActived = corporateCustomerRepository.countAllCorporateCustomerHasNotActived();
		return totalCorporateCustomerHasNoteActived;
	}
	
	public StatisticCount countAllCorporateCustomerActived(){
		StatisticCount totalCorporateCustomerActived = corporateCustomerRepository.countAllCorporateCustomerActived();
		return totalCorporateCustomerActived;
	}
	
	public StatisticCount countAllCorporateCustomerLocked() {
		StatisticCount totalCorporateCustomerLocked = corporateCustomerRepository.countAllCorporateCustomerLocked();
		return totalCorporateCustomerLocked;
	}
	
	/**
	 * END
	 */
	
	
	
	/**
	 * statistic of employee
	 */
	
	
	public StatisticCount countAllEmployee() {
		StatisticCount totalEmployee = userRepository.countAllEmployee();
		return totalEmployee;
	}
	
	
	public StatisticCount countAllEmployeeHasNotHadAccount() {
		StatisticCount totalEmployee = userRepository.countAllEmployeeHasNotHadAccount();
		return totalEmployee;
	}
	
	public StatisticCount countAllEmployeeHasAccount() {
		StatisticCount totalEmployee = userRepository.countAllEmployeeHasAccount();
		return totalEmployee;
	}
	
	public StatisticCount countAllEmployeeLocked() {
		StatisticCount totalEmployee = userRepository.countAllEmployeeLocked();
		return totalEmployee;
	}
	
	public List<StatisticCountEmployeeByDepartment> countAllEmployeeByDepartment() {
		List<StatisticCountEmployeeByDepartment> totalEmployeeByDepartment = userRepository.countAllEmployeeByDepartment();
		return totalEmployeeByDepartment;
	}
	
	/**
	 * END
	 */
	
	
	/**
	 * Statistic of contract
	 */
	
	public StatisticCount countAllContract() {
		StatisticCount totalContract = contractRepository.countAllContract();
		return totalContract;
	}
	
	public StatisticCount countAllContractShortTermTime() {
		StatisticCount totalContract = contractRepository.countAllContractShortTermTime();
		return totalContract;
	}
	
	
	public StatisticCount countAllContractLongTermTime() {
		StatisticCount totalContract = contractRepository.countAllContractLongTermTime();
		return totalContract;
	}
	
	public StatisticCount countAllContractLoked() {
		StatisticCount totalContract = contractRepository.countAllContractLocked();
		return totalContract;
	}
	/**
	 * END
	 */
}
