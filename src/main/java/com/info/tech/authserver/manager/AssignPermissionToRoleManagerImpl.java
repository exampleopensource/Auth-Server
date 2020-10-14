package com.info.tech.authserver.manager;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.tech.authserver.domain.AssignPermissionToRole;
import com.info.tech.authserver.repository.AssignPermissionToRoleRepository;

@Service("assignPermissionToRoleManager")
public class AssignPermissionToRoleManagerImpl implements AssignPermissionToRoleManager {

	@Autowired
	private AssignPermissionToRoleRepository assignPermissionToRoleRepository ;
	
	@Override
	public List<AssignPermissionToRole> findByRoleId(UUID roleId) {
		return assignPermissionToRoleRepository.findByRoleId(roleId);
	}

}
