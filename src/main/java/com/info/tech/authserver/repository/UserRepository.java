package com.info.tech.authserver.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.info.tech.authserver.domain.User;

public interface UserRepository extends CassandraRepository<User, UUID> {

	public List<User> findByEmailId(final String emailId);

}
