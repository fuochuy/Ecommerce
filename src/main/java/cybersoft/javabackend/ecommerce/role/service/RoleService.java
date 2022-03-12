package cybersoft.javabackend.ecommerce.role.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import cybersoft.javabackend.ecommerce.role.dto.RoleDTO;
import cybersoft.javabackend.ecommerce.role.dto.UpdateRoleDTO;
import cybersoft.javabackend.ecommerce.role.model.Role;

public interface RoleService {

	List<RoleDTO> findAllDTO();

	RoleDTO create(RoleDTO dto);

	Optional<Role> findByName(String roleName);

	RoleDTO updateRole(long id, UpdateRoleDTO dto);

	void deleteRole(long id);

}
