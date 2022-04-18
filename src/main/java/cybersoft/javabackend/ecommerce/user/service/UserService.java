package cybersoft.javabackend.ecommerce.user.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import cybersoft.javabackend.ecommerce.user.dto.UserDTO;
import cybersoft.javabackend.ecommerce.user.model.User;

public interface UserService {
	public List<User> getUsers();

	public UserDTO create(@Valid UserDTO dto);

	public User findByUsernamePassword(String username, String password);

	public Optional<User> findByUsername(String username);
	
	public Optional<User> findByEmail(String email);
}
