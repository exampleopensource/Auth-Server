package com.info.tech.authserver.domain;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 4732945850257433955L;

	@PrimaryKey(value = "id")
	@Column(value = "id")
	private UUID id;

	@Column(value = "name")
	private String name;

	@Column(value = "email_id")
	private String emailId;

	@Column(value = "password")
	private String password;

	
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

	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
