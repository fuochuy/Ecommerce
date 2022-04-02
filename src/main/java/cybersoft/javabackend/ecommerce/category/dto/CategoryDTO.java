package cybersoft.javabackend.ecommerce.category.dto;

import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.ecommerce.category.validation.annotation.UniqueCategoryName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {
	
	
	private long id;
	
	@NotBlank(message = "{category.name.not-blank}")
	private String name;
	
	@NotBlank(message = "{category.image.not-blank}")
	private String code;
	
	
}
