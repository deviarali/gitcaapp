package com.ajahsma.caapp.security;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.ajahsma.caapp.dao.ApplicationUserDao;
import com.ajahsma.caapp.model.ApplicationUserModel;
import com.ajahsma.caapp.model.UserRoleModel;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private ApplicationUserDao repo;
	
	String role;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		try {
			UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;

			/*com.ajahsma.carservice.model.User user = repo.findByUsername(token.getName());

	        List<GrantedAuthority> authorities = new ArrayList<>();
	        for (Role role : user.getRoles()){
	        	authorities.add(new SimpleGrantedAuthority(role.getName()));
	        }
	        buildUserForAuthentication(user, authorities);*/
			
			List<GrantedAuthority> authorities = new ArrayList<>();
			ApplicationUserModel user = repo.findByUserName(token.getName());
			if (user != null) {
				
				authorities = buildUserAuthority(user.getUserRoles());

				buildUserForAuthentication(user, authorities);
				
			} else {
				throw new BadCredentialsException("The credentials are invalid");
			}


			return new UsernamePasswordAuthenticationToken(user, user.getPassword(), authorities);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BadCredentialsException("The credentials are invalid");
		}

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

	private User buildUserForAuthentication(ApplicationUserModel user, List<GrantedAuthority> authorities) {
		return new User(user.getUserName(), user.getPassword(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRoleModel> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRoleModel userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRoleName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}
