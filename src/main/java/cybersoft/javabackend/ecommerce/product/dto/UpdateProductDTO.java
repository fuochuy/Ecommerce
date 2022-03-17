package cybersoft.javabackend.ecommerce.product.dto;

import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.ecommerce.category.validation.annotation.UniqueCategoryName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateProductDTO {

	
	private long category_id;
	
	@NotBlank()
	@UniqueCategoryName()
	private String name;
	
	@NotBlank()
	private String description;
	
	private String image1;
	
	private String image2;
	
	private String image3;
	
	private String size;
	
	private String color;
	
	private String brand;
	
	private float price;
	
	private float discount;
	
	private int quantity;
	
	private int quantity_sold;
}
