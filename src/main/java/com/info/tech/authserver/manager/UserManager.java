package com.info.tech.authserver.manager;

import java.util.List;

import com.info.tech.authserver.domain.User;

public interface UserManager {

	public List<User> findByEmailId(final String emailId);
}

