package cybersoft.javabackend.ecommerce.category.service;

import java.util.List;
import java.util.Optional;

import cybersoft.javabackend.ecommerce.category.dto.CategoryDTO;
import cybersoft.javabackend.ecommerce.category.model.Category;

public interface CategoryService {
	List<CategoryDTO> findByCode(String code);
	
	CategoryDTO create(CategoryDTO dto);

	Optional<Category> findByName(String categoryName);
}
