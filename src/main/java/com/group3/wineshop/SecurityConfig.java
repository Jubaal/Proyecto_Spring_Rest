package com.group3.wineshop;


import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests((authz) -> {
            	authz.antMatchers(HttpMethod.GET).permitAll();
            	authz.antMatchers(HttpMethod.POST).hasRole("USER");
            	authz.antMatchers(HttpMethod.PUT).hasRole("USER");
            	authz.antMatchers(HttpMethod.DELETE).hasRole("ADMIN");
            	authz.anyRequest().authenticated();
            })
            .httpBasic();
        return http.build();
    }
    

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        ArrayList<UserDetails> users = new ArrayList<>();
        
        users.add(User.withUsername("gft").password(new BCryptPasswordEncoder().encode("eduardo")).roles("USER").build());
        users.add(User.withUsername("gft2").password(new BCryptPasswordEncoder().encode("eduardo")).roles("USER", "ADMIN").build());
        return new InMemoryUserDetailsManager(users);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }

}