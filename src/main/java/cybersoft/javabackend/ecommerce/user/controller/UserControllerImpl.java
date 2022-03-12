package cybersoft.javabackend.ecommerce.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.ecommerce.common.ResponseHandler;
import cybersoft.javabackend.ecommerce.user.dto.UserDTO;
import cybersoft.javabackend.ecommerce.user.service.UserService;

@RestController
public class UserControllerImpl implements UserController{

	@Autowired
	private UserService service;
	
	@Override
	public ResponseEntity<Object> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> createUser(@Valid UserDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		
		UserDTO createdUser = service.create(dto);

		return ResponseHandler.getResponse(createdUser, HttpStatus.OK);
	}

}
