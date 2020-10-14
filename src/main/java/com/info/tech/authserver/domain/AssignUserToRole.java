package com.info.tech.authserver.domain;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "assign_user_to_role")
public class AssignUserToRole implements Serializable {

	private static final long serialVersionUID = 4432916604732571760L;

	@PrimaryKey(value = "id")
	@Column(value = "id")
	private UUID id ;
	
	@Column(value = "user_id")
	private UUID userId ;

	@Column(value = "role_id")
	private UUID roleId ;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public UUID getRoleId() {
		return roleId;
	}

	public void setRoleId(UUID roleId) {
		this.roleId = roleId;
	}
	
	
}
