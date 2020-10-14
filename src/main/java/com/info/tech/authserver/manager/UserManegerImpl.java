package com.info.tech.authserver.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.tech.authserver.domain.User;
import com.info.tech.authserver.repository.UserRepository;

@Service("userManager")
public class UserManegerImpl implements UserManager {

	@Autowired
	private UserRepository userRepository ;
	
	@Override
	public List<User> findByEmailId(String emailId) {
		return userRepository.findByEmailId(emailId);
	}

}
