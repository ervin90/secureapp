package com.talent4gig.secureapp.security;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.talent4gig.secureapp.entity.Role;
import com.talent4gig.secureapp.entity.User;
import com.talent4gig.secureapp.repository.RoleRepository;
import com.talent4gig.secureapp.repository.UserRepository;
import com.talent4gig.secureapp.util.PasswordEncrypter;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired private UserRepository userRepository;
	@Autowired private RoleRepository roleRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String mail = authentication.getName();
		String password = authentication.getCredentials().toString();

		User user = userRepository.findByEmail(mail);
		List<Role> roles = roleRepository.findByEmail(mail);

		if (PasswordEncrypter.matches(password, user.getPassword())) {

			List<SimpleGrantedAuthority> authorities = roles.stream().map(r -> r.getRole())
					.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
			return new UsernamePasswordAuthenticationToken(mail, password, authorities);
		}
		
		throw new BadCredentialsException("Invalid credentials");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
