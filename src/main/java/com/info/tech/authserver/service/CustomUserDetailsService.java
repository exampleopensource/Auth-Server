package com.info.tech.authserver.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.info.tech.authserver.domain.AssignPermissionToRole;
import com.info.tech.authserver.domain.AssignUserToRole;
import com.info.tech.authserver.domain.Permission;
import com.info.tech.authserver.domain.User;
import com.info.tech.authserver.dto.UserInfo;
import com.info.tech.authserver.manager.AssignPermissionToRoleManager;
import com.info.tech.authserver.manager.AssignUserToRoleManager;
import com.info.tech.authserver.manager.PermissionManager;
import com.info.tech.authserver.manager.UserManager;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserManager userManager;

	@Autowired
	private PermissionManager permissionManager;

	@Autowired
	private AssignUserToRoleManager assignUserToRoleManager;

	@Autowired
	private AssignPermissionToRoleManager assignPermissionToRoleManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> userEntity = null;
		try {
			System.out.println("Pass parameter username " +username);
			userEntity = userManager.findByEmailId(username);
			if (CollectionUtils.isNotEmpty(userEntity)) {
				User user = userEntity.get(0);
				System.out.println("userEntity is not empty  " + user.getEmailId());
				Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
				List<AssignUserToRole> assignUserToRoles = assignUserToRoleManager.findByUserId(user.getId());
				if (CollectionUtils.isNotEmpty(assignUserToRoles)) {
					System.out.println("Assign User To Roles is not empty");
					assignUserToRoles.forEach(assignUserToRole -> {
						System.out.println("Assign User To Roles now role id  "+ assignUserToRole.getRoleId());
						List<AssignPermissionToRole> assignPermissionToRoles = assignPermissionToRoleManager
								.findByRoleId(assignUserToRole.getRoleId());
						if (CollectionUtils.isNotEmpty(assignPermissionToRoles)) {
							System.out.println("Assign Permission To Roles is not empty ");
							assignPermissionToRoles.forEach(assignPermissionToRole -> {
								System.out.println("Assign Permission To Role now permission id  "+ assignPermissionToRole.getPermissionId());
								Optional<Permission> permission = permissionManager
										.findById(assignPermissionToRole.getPermissionId());
								System.out.println("Permission have " +permission.isPresent());

								if (permission.isPresent()) {
									String role_="ROLE_"+permission.get().getName();
									GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role_);
									System.out.println("SimpleGrantedAuthority " + role_);
									grantedAuthoritiesList.add(grantedAuthority);
								}

							});

						}
					});
				}

				UserInfo userInfo = new UserInfo(user.getEmailId(), user.getPassword(), grantedAuthoritiesList,
						user.getId(), user.getName());

				return userInfo;
			} else {
				throw new UsernameNotFoundException("User " + username + " was not found in the database");
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}

	}

}
