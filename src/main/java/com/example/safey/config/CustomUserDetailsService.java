package com.example.safey.config;

import com.example.safey.config.domain.User;
import com.example.safey.repository.UserRepository;
import com.example.safey.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		
			
		User user = userRepository.findByUsername(username);
		if (user != null) {
			roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
		}
		throw new UsernameNotFoundException("User not found with the name " + username);
	}
	
	public User save(UserDto userDTO) throws Exception {
		if (userRepository.findOneByUsername(userDTO.getUsername().toLowerCase()).isPresent()) {
			throw new Exception("Login name already used!");
		}
		else {
			User newUser = new User();
			newUser.setUsername(userDTO.getUsername());
			newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
			newUser.setRole(userDTO.getRole());
			return userRepository.save(newUser);
		}


	}

}
