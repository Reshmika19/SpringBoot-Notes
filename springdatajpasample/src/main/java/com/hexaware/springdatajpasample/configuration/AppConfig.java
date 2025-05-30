package com.hexaware.springdatajpasample.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class AppConfig {
	// Letting Spring know to create ModelMapper
	/* Why Configuring needed ?
	 * Without a Spring-managed bean, we have to do:

		ModelMapper mapper = new ModelMapper(); // every time

	 */
	AuthenticationFilter y = null;
	@Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
	
	// This is from Spring Security
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails reshmika = User.builder().username("reshmika").password(passwordEncoder().encode("password")).roles("USER").build();
		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin..")).roles("ADMIN").build();
		
		return new InMemoryUserDetailsManager(reshmika, admin);
	}
	
	// Encode Password - BCrypt uses SHA (Secure Hash Algorithm)
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	
			http.csrf((csrf) -> csrf.disable()).authorizeHttpRequests((authorize) -> {
//			authorize.requestMatchers(HttpMethod.POST, "/saveProduct").hasRole("ADMIN");
//			authorize.requestMatchers(HttpMethod.GET, "/products/get**").hasAnyRole("USER", "ADMIN");
			authorize.anyRequest().authenticated();
		}).httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	}