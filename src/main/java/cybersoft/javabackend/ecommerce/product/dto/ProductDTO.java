package cybersoft.javabackend.ecommerce.product.dto;

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
public class ProductDTO {
	
	private long id;
	
	private long category_id;
	
	@NotBlank()
	@UniqueCategoryName()
	private String name;
	
	@NotBlank()
	private String description;
	
	private String image1;
	
	private String image2;
	
	private String image3;
	
	private String brand;
	
	private float price;
	
	private float discount;
	
	
}
