package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountAndInformation;
import com.example.demo.model.Account;
import com.example.demo.model.User;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<AccountAndInformation> displayListAccount(){
		List<AccountAndInformation> l = accountRepository.displayListAccount();
		return l;
	}
	
	
	public long insertAccount(Account a) {
		String email = a.getEmail();
		Account a1 = accountRepository.findAccountByEmail(email);
		if(a1 == null) {
			// status open is 1
			Long status =(long) 1;
			
			Account a2 = new Account();
			a2.setEmail(email);
			a2.setPassword(bCryptPasswordEncoder.encode(a.getPassword()));
			a2.setIdUser(a.getIdUser());
			a2.setStatus(status);
			accountRepository.save(a2);
			
			// we will find account that we have just created
			Account a3 = accountRepository.findAccountByIdUser(a.getIdUser());
			
			// then we'll update user of that account
			User u = userService.findUserById(a.getIdUser());
			u.setAccount(a3);
			userRepository.save(u);
			
			return 0;
		}else {
			return 1;
		}
		
		
	}
	
	public long checkAccountUser(Long idUser) {
		
		Account a = accountRepository.checkAccountUser(idUser);
		
		if(a == null) {
			return 0;
		}else {
			return 1;
		}
	}
	
	public Account findAccountByIdUser(Long idUser) {
		Account a = accountRepository.findAccountByIdUser(idUser);
		return a;
	}
	
	public void lockAccount(Long idAccount) {
		Account a = accountRepository.findAccountById(idAccount);
		// locked status is 0
		Long status = (long)0;
		a.setStatus(status);
		accountRepository.save(a);
	}
	
	public void openAccount(Long idAccount) {
		Account a = accountRepository.findAccountById(idAccount);
		// opened status is 1
		Long status = (long)1;
		a.setStatus(status);
		accountRepository.save(a);
	}
	
	public Account findAccountById(Long idAccount) {
		Account a = accountRepository.findAccountById(idAccount);
		return a;
	}
	
	public Account findAccountByEmail(String email) {
		Account a = accountRepository.findAccountByEmail(email);
		return a;
	}
	
	
	public void updateAccount(Account a) {
		Account a1 = accountRepository.findAccountById(a.getIdAccount());
		a1.setEmail(a.getEmail());
		a1.setPassword(bCryptPasswordEncoder.encode(a.getPassword()));
		accountRepository.save(a1);
	}
	
	public List<AccountAndInformation> searchAccountByEmail(String email){
		List<AccountAndInformation> listAccount = accountRepository.searchAccountByEmail(email);
		return listAccount;
	}
}
