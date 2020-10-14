package com.info.tech.authserver.manager;

import java.util.List;
import java.util.UUID;

import com.info.tech.authserver.domain.AssignPermissionToRole;

public interface AssignPermissionToRoleManager {

	public List<AssignPermissionToRole> findByRoleId(final UUID roleId);
}
