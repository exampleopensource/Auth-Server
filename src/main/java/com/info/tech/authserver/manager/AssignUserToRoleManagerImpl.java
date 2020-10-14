package com.info.tech.authserver.manager;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.tech.authserver.domain.AssignUserToRole;
import com.info.tech.authserver.repository.AssignUserToRoleRepository;

@Service("assignUserToRoleManager")
public class AssignUserToRoleManagerImpl implements AssignUserToRoleManager {

	@Autowired
	private AssignUserToRoleRepository assignUserToRoleRepository;

	@Override
	public List<AssignUserToRole> findByUserId(UUID userId) {
		return assignUserToRoleRepository.findByUserId(userId);
	}

}
