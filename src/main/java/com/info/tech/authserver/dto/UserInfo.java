package com.info.tech.authserver.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserInfo extends User implements Serializable {

	private static final long serialVersionUID = 9000846875322341930L;

	private UUID id;

	private String name;

	
	public UserInfo(String username, String password, Collection<? extends GrantedAuthority> authorities, UUID id,
			String name) {
		super(username, password, authorities);
		this.id = id;
		this.name = name;
	}


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
