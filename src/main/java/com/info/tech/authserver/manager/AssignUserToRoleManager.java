package com.info.tech.authserver.manager;

import java.util.List;
import java.util.UUID;

import com.info.tech.authserver.domain.AssignUserToRole;

public interface AssignUserToRoleManager {

	public List<AssignUserToRole> findByUserId(final UUID userId);

}
