package com.info.tech.authserver.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.info.tech.authserver.domain.AssignPermissionToRole;

public interface AssignPermissionToRoleRepository extends CassandraRepository<AssignPermissionToRole, UUID> {
	
	public List<AssignPermissionToRole> findByRoleId(final UUID roleId);

}
