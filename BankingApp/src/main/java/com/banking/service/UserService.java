package com.banking.service;



import org.springframework.security.core.userdetails.UserDetailsService;

import com.banking.dto.UserRegistrationDto;
import com.banking.model.User;



public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
}
