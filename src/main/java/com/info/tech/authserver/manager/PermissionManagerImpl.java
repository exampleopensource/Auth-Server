package com.info.tech.authserver.manager;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.tech.authserver.domain.Permission;
import com.info.tech.authserver.repository.PermissionRepository;

@Service("permissionManager")
public class PermissionManagerImpl implements PermissionManager {

	@Autowired
	private PermissionRepository permissionRepository ;

	@Override
	public Optional<Permission> findById(UUID id) {
		return permissionRepository.findById(id);
	}
	
}
