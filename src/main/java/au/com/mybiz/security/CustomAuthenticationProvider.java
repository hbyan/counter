package au.com.mybiz.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import au.com.mybiz.model.User;
import au.com.mybiz.service.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
	
		return isValidAuthentication(userName, password);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	private Authentication isValidAuthentication(String userName, String password){
	
		User user = userService.find(userName);
		
		if ( password.equals(user.getPassword())) {
			final List<GrantedAuthority> grantedAuths = new ArrayList<>();
			grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
			final Authentication auth = new UsernamePasswordAuthenticationToken(userName, password, grantedAuths);
			return auth;
		} else {
			return null;
		}
	}
	
	
}