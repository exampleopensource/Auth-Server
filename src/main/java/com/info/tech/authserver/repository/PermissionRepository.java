package com.info.tech.authserver.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.info.tech.authserver.domain.Permission;

public interface PermissionRepository extends CassandraRepository<Permission, UUID> {

}
