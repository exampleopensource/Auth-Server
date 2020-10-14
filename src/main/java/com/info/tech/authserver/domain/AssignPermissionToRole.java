package com.info.tech.authserver.domain;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "assign_permission_to_role")
public class AssignPermissionToRole implements Serializable {
	private static final long serialVersionUID = 8477521584609580666L;

	@PrimaryKey(value = "id")
	@Column(value = "id")
	private UUID id ;
	
	@Column(value = "permission_id")
	private UUID permissionId ;
	
	@Column(value = "role_id")
	private UUID roleId;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(UUID permissionId) {
		this.permissionId = permissionId;
	}

	public UUID getRoleId() {
		return roleId;
	}

	public void setRoleId(UUID roleId) {
		this.roleId = roleId;
	}
	
	
	
}
