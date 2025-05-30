package com.hexaware.firstspringboot.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.hexaware.firstspringboot.authentities.UserData;
import com.hexaware.firstspringboot.repository.IUserRepository;

@Service
public class UserServiceImpl implements UserDetailsService{
	
	private IUserRepository userRepo;
	
	public UserServiceImpl(IUserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	@Override
	 public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        UserData data = userRepo.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username or email: " + usernameOrEmail));

        Set<GrantedAuthority> authorities = data.getRoles().stream()
        	    .map(role -> new SimpleGrantedAuthority(role.getName()))
        	    .collect(Collectors.toSet());
					
 /*       Set<GrantedAuthority> authorities1 = new HashSet<>();
        for(Role role : data.getRoles()) {
        	GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
        	authorities1.add(authority);
        } 
*/
		return new User(usernameOrEmail, null , authorities);
	}
	public Optional<UserData> findByUserName(String userName){
		return userRepo.findByUserName(userName);
	}

	public boolean existsByEmail(String email) {
		return userRepo.existsByEmail(email);
	}

	public Optional<UserData> findByUserNameOrEmail(String userName, String email) {
		return userRepo.findByUserNameOrEmail(userName, email);
	}


}
