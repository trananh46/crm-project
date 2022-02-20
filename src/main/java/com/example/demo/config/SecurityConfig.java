package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.MyUserDetailService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDetailService myUserDetailService;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
    private SimpleAuthenticationSuccessHandler successHandler;
	
	
	public void configure(WebSecurity web) {
        web.ignoring();
    }
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }

    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		.antMatchers("/assets/**").permitAll()
        		.antMatchers("/images/*").permitAll()
        		.antMatchers("/contract-file/*").permitAll()
                .antMatchers("/login-user").permitAll()
                .antMatchers("/FPT/insert-user").permitAll()
                .antMatchers("/FPT/insert-user-process").permitAll()
                .antMatchers("/FPT/display-list-user").permitAll()
                .antMatchers("/FPT/display-information-user").permitAll()
                .antMatchers("/FPT/insert_account").permitAll()
                .antMatchers("/FPT/insert_account_process").permitAll()       
                .antMatchers("/FPT/insert-user-role").permitAll()
                .antMatchers("/FPT/insert-user-role-process").permitAll()
                .antMatchers("/FPT/list_department").permitAll()
                .antMatchers("/FPT/insert_department").permitAll()
                .antMatchers("/FPT/insert_department_process").permitAll()
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login-user")
                .and().formLogin().successHandler(successHandler)
                .permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied")
                .and()
                .csrf().disable()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login-user").permitAll();

    }
}
