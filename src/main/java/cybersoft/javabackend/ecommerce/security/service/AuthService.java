package cybersoft.javabackend.ecommerce.security.service;

import cybersoft.javabackend.ecommerce.security.dto.LoginDTO;

public interface AuthService {
	public String login(LoginDTO dto);
}
