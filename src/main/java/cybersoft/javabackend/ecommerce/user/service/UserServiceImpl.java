package cybersoft.javabackend.ecommerce.user.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.ecommerce.product.exception.InvalidProductException;
import cybersoft.javabackend.ecommerce.user.dto.UserDTO;
import cybersoft.javabackend.ecommerce.user.model.User;
import cybersoft.javabackend.ecommerce.user.repository.UserRepository;
import cybersoft.javabackend.ecommerce.user.util.UserConverter;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	@Override
	public List<User> getUsers() {
		List<User> users = repository.findAll();

		return users;
	}
	@Override
	public UserDTO create(@Valid UserDTO dto) {
		User user = UserConverter.toUser(dto);
		
		User createdUser = repository.save(user);
		
		return UserConverter.toUserDTO(createdUser);
	}
	@Override
	public User findByUsernamePassword(String username, String password) {
		
		return repository.findByUsernameAndPassword(username, password);
	}
	@Override
	public Optional<User> findByUsername(String username) {
		Optional<User> userOpt = repository.findByUsername(username);
		if (!userOpt.isPresent()) {
			throw new InvalidProductException("Product id is not valid");
		}
		return userOpt;
	}

}
