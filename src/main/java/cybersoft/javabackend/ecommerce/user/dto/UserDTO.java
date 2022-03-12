package cybersoft.javabackend.ecommerce.user.dto;


import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
	
	private long id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String first_name;
	
	@NotBlank
	private String last_name;
	
	@NotBlank
	private String phone;
	
	private int activated;


}

