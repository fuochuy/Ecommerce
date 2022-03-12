package cybersoft.javabackend.ecommerce.user.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.ecommerce.user.dto.UserDTO;
import cybersoft.javabackend.ecommerce.user.dto.UserMapper;
import cybersoft.javabackend.ecommerce.user.model.User;
import cybersoft.javabackend.ecommerce.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	@Override
	public User getCustomerById(long id) {
		Optional<User> customerOpt = repository.findById(id);
		
		if(customerOpt.isPresent()) {
			return customerOpt.get();
		}
		return null;
	}
	@Override
	public UserDTO create(@Valid UserDTO dto) {
		User user = UserMapper.INSTANCE.userDTOToUserEntity(dto);
		User createdUser = repository.save(user);
		return UserMapper.INSTANCE.userEntityToCreateUserDTO(createdUser);
	}

}
