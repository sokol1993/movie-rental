package pl.ksokolowski.movierental.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ksokolowski.movierental.dao.UserDAO;
import pl.ksokolowski.movierental.domain.UserRole;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
 
	@Autowired
	private UserDAO userDAO;
	
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String login) 
		throws UsernameNotFoundException {
 
		pl.ksokolowski.movierental.domain.User user = userDAO.findByLogin(login);
		List<GrantedAuthority> authorities = 
                                      buildUserAuthority(user.getUserRole());
 
		return buildUserForAuthentication(user, authorities);
	}
 
	// Converts service.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(pl.ksokolowski.movierental.domain.User user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getLogin(), user.getPassword(), 
			user.isEnabled(), true, true, true, authorities);
	}
 
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
		return Result;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}
