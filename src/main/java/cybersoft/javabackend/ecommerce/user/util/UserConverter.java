package cybersoft.javabackend.ecommerce.user.util;

import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.ecommerce.product.dto.ProductDTO;
import cybersoft.javabackend.ecommerce.product.model.Product;
import cybersoft.javabackend.ecommerce.product.util.ProductConverter;
import cybersoft.javabackend.ecommerce.user.dto.UserDTO;
import cybersoft.javabackend.ecommerce.user.model.User;

public class UserConverter {
	public static UserDTO toUserDTO(User user) {
		return UserDTO.builder()
				.id(user.getId())
				.username(user.getUsername())
				.email(user.getEmail())
				.password(user.getPassword())
				.first_name(user.getFirst_name())
				.last_name(user.getLast_name())
				.phone(user.getPhone())
				.activated(user.getActivated())
				.build();
	}
	public static List<UserDTO> toUserDTOs(List<User> users){
		List<UserDTO> userDTOs = new ArrayList<>();
		
		for(User u:users) {
			userDTOs.add(UserConverter.toUserDTO(u));
		}
		return userDTOs;
	}

	public static User toUser(UserDTO dto) {
		return User.builder()
				.id(dto.getId())
				.username(dto.getUsername())
				.email(dto.getEmail())
				.password(dto.getPassword())
				.first_name(dto.getFirst_name())
				.last_name(dto.getLast_name())
				.phone(dto.getPhone())
				.activated(dto.getActivated())
				.build();
	}
				
}
