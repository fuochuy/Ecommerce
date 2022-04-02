package cybersoft.javabackend.ecommerce.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.ecommerce.role.model.Role;
import cybersoft.javabackend.ecommerce.security.dto.CustomUserDetails;
import cybersoft.javabackend.ecommerce.user.model.User;
import cybersoft.javabackend.ecommerce.user.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOpt = repository.findByUsername(username);
		
		
		if(!userOpt.isPresent()) {
			throw new UsernameNotFoundException("username is not existed.");
		}
		User currentUser = userOpt.get();
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.addAll(getAuthorities(currentUser));
		return new CustomUserDetails(currentUser.getEmail(), currentUser.getPassword(), authorities);
	}

	private List<? extends GrantedAuthority> getAuthorities(final User currentUser) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role role: currentUser.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}
		
}
