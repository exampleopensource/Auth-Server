package com.info.tech.authserver.domain;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "permission")
public class Permission implements Serializable {
		
	private static final long serialVersionUID = -2789945339687937019L;

	@PrimaryKey(value = "id")
	@Column(value = "id")
	private UUID id ;
	
	@Column(value = "permission_name")
	private String name ;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
