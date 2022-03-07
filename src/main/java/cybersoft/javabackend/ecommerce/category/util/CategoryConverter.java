package cybersoft.javabackend.ecommerce.category.util;

import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.ecommerce.category.dto.CategoryDTO;
import cybersoft.javabackend.ecommerce.category.model.Category;

public class CategoryConverter {
	public static CategoryDTO toCategoryDTO(Category category) {
			return CategoryDTO.builder()
					.id(category.getId())
					.name(category.getName())
					.image(category.getImage())
					.icon(category.getIcon())
					.build();
	}
	
	public static List<CategoryDTO> toCategoryDTOs(List<Category> categories){
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		
		for(Category c:categories) {
			categoryDTOs.add(CategoryConverter.toCategoryDTO(c));
		}
		return categoryDTOs;
	}
	
	public static Category toCategory(CategoryDTO dto) {
		return Category.builder()
				.name(dto.getName())
				.image(dto.getImage())
				.icon(dto.getIcon())
				.build();
	}
}
