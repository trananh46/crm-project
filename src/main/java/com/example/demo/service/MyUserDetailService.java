package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRoleAndInformation;
import com.example.demo.model.Account;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserRoleService userRoleService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Account a = accountService.findAccountByEmail(email);
		if (a != null) {
			List<UserRoleAndInformation> roleList = userRoleService.displayListRoleByIdUser(a.getIdUser());
			Set<String> roleSet = new HashSet<String>();
			for(UserRoleAndInformation r : roleList) {
				roleSet.add("ROLE_"+r.getMa_quyen());
			}
			
			List<GrantedAuthority> authorities = roleSet.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

            return new User(a.getEmail(),a.getPassword(), authorities);
		}

		return null;
	}

}
