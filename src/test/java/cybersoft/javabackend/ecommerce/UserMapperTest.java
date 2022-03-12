package cybersoft.javabackend.ecommerce;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import cybersoft.javabackend.ecommerce.user.dto.UserDTO;
import cybersoft.javabackend.ecommerce.user.dto.UserMapper;
import cybersoft.javabackend.ecommerce.user.model.User;

@SpringBootTest
public class UserMapperTest {
	@Test
	public void shouldMapUserDTOToUserEntity() {
		UserDTO dto = new UserDTO();
		dto.setUsername("fuochuy");
		dto.setPassword("fuochuy1234");
		dto.setEmail("Example@gmail.com");
		dto.setFirst_name("Nguyen");
		dto.setLast_name("Phuoc Huy");
		dto.setPhone("0917955321");
		dto.setActivated(0);
		
		User user = UserMapper.INSTANCE.userDTOToUserEntity(dto);
		
		assertThat(user.getUsername()).isEqualTo(dto.getUsername());
		assertThat(user.getPassword()).isEqualTo(dto.getPassword());
		assertThat(user.getEmail()).isEqualTo(dto.getEmail());
		assertThat(user.getFirst_name()).isEqualTo(dto.getFirst_name());
		assertThat(user.getLast_name()).isEqualTo(dto.getLast_name());
		assertThat(user.getPhone()).isEqualTo(dto.getPhone());
		assertThat(user.getActivated()).isEqualTo(dto.getActivated());
	}
}
