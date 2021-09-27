//package com.springboot.bankingApp.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//@Configuration
//@EnableWebSecurity
//public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService);
//
//	}
//	
//
//
//
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//		// NoOpPasswordEncoder.getInstance();
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.csrf().disable().authorizeRequests()
//		.antMatchers("/","index","home","/css/*","/js/*").permitAll()
//		.antMatchers("/manager/**").hasAnyAuthority("MANAGER")
//		.antMatchers("/employee/**").hasAnyAuthority("ADMIN","MANAGER","EMPLOYEE")
//		.anyRequest()
//		.authenticated().and().logout().and().formLogin().loginPage("/login").permitAll()
//		.defaultSuccessUrl("/main",true).and()
//		.rememberMe().tokenValiditySeconds(30).key("helloKey")
//		.and()
//		.logout()
//		.clearAuthentication(true)
//		.invalidateHttpSession(true)
//		.deleteCookies("JSESSIONID","remember-me")
//		.logoutUrl("/logout")
//		.and()
//		.exceptionHandling()
//		.accessDeniedPage("/403")
//		;
//
//		
//		
//
//	}
//
//}
