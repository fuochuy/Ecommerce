package cybersoft.javabackend.ecommerce.user.service;

import javax.validation.Valid;

import cybersoft.javabackend.ecommerce.user.dto.UserDTO;
import cybersoft.javabackend.ecommerce.user.model.User;

public interface UserService {
	public User getCustomerById(long id);

	public UserDTO create(@Valid UserDTO dto);
}
