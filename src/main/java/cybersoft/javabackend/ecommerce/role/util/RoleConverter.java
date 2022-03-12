package cybersoft.javabackend.ecommerce.role.util;

import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.ecommerce.role.dto.RoleDTO;
import cybersoft.javabackend.ecommerce.role.model.Role;

public class RoleConverter {
	public static RoleDTO toRoleDTO(Role role) {
		return RoleDTO.builder()
			.id(role.getId())
			.name(role.getName())
			.code(role.getCode())
			.description(role.getDescription())
			.build();
	}
	
	public static List<RoleDTO> toRoleDTOs(List<Role> roles){
		List<RoleDTO> roleDTOs = new ArrayList<>();
		
		for(Role role : roles) {
			roleDTOs.add(RoleConverter.toRoleDTO(role));
		}
		
		return roleDTOs;
	}

	public static Role toRole(RoleDTO dto) {
		return Role.builder()
				.id(dto.getId())
				.name(dto.getName())
				.code(dto.getCode())
				.description(dto.getDescription())
				.build();
	}
}
