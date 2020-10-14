package com.info.tech.authserver.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.info.tech.authserver.domain.Role;


public interface RoleRepository extends CassandraRepository<Role, UUID> {

}
