package com.info.tech.authserver.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.info.tech.authserver.domain.AssignUserToRole;



public interface AssignUserToRoleRepository extends CassandraRepository<AssignUserToRole, UUID> {
	
	public List<AssignUserToRole> findByUserId(final UUID userId);

}
