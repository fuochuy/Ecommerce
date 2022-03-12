package cybersoft.javabackend.ecommerce.user.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.ecommerce.user.model.User;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User userDTOToUserEntity(UserDTO dto);
	UserDTO userEntityToCreateUserDTO(User entity);
}
