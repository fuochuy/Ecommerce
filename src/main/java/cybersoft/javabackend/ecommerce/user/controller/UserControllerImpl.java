package cybersoft.javabackend.ecommerce.user.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import cybersoft.javabackend.ecommerce.common.ResponseHandler;
import cybersoft.javabackend.ecommerce.user.dto.UserDTO;
import cybersoft.javabackend.ecommerce.user.model.User;
import cybersoft.javabackend.ecommerce.user.service.UserService;

@Controller
public class UserControllerImpl implements UserController{

	@Autowired
	private UserService service;
	
	
	@Override
	public ResponseEntity<Object> getUsers() {
		
		return ResponseHandler.getErrorResponse(service.getUsers(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createUser(@Valid UserDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		
		UserDTO createdUser = service.create(dto);

		return ResponseHandler.getResponse(createdUser, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getUserByUserName(String username) {
		
		Optional<User> userOpt = service.findByUsername(username);
		return ResponseHandler.getResponse(userOpt, HttpStatus.OK);
	}

	

	
}
