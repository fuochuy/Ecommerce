package cybersoft.javabackend.ecommerce.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDTO {
	private long id; 
	
	@NotBlank(message = "{role.name.not-blank}")
	private String name;
	
	@NotBlank(message = "{role.code.not-blank}")
	//@UniqueRoleCode
	private String code;
	
	@NotBlank(message = "{role.description.not-blank}")
	private String description;
}
