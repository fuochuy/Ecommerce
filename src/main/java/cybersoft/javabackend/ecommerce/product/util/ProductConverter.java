package cybersoft.javabackend.ecommerce.product.util;

import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.ecommerce.product.dto.ProductDTO;
import cybersoft.javabackend.ecommerce.product.model.Product;

public class ProductConverter {
	public static ProductDTO toProductDTO(Product product) {
		return ProductDTO.builder()
				.id(product.getId())
				.category_id(product.getCategory_id())
				.name(product.getName())
				.description(product.getDescription())
				.image1(product.getImage1())
				.image2(product.getImage2())
				.image3(product.getImage3())
				.size(product.getSize())
				.color(product.getColor())
				.brand(product.getBrand())
				.price(product.getPrice())
				.discount(product.getDiscount())
				.quantity(product.getQuantity())
				.quantity_sold(product.getQuantity_sold())
				.build();
}

public static List<ProductDTO> toProductDTOs(List<Product> products){
	List<ProductDTO> productDTOs = new ArrayList<>();
	
	for(Product c:products) {
		productDTOs.add(ProductConverter.toProductDTO(c));
	}
	return productDTOs;
}

public static Product toProduct(ProductDTO dto) {
	return Product.builder()
			.id(dto.getId())
			.category_id(dto.getCategory_id())
			.name(dto.getName())
			.description(dto.getDescription())
			.image1(dto.getImage1())
			.image2(dto.getImage2())
			.image3(dto.getImage3())
			.size(dto.getSize())
			.color(dto.getColor())
			.brand(dto.getBrand())
			.price(dto.getPrice())
			.discount(dto.getDiscount())
			.quantity(dto.getQuantity())
			.quantity_sold(dto.getQuantity_sold())
			.build();
}
}
