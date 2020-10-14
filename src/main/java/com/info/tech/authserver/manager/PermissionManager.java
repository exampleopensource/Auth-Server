package com.info.tech.authserver.manager;

import java.util.Optional;
import java.util.UUID;

import com.info.tech.authserver.domain.Permission;

public interface PermissionManager {

	public Optional<Permission> findById(final UUID id);
}
