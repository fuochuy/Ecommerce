package cybersoft.javabackend.ecommerce.category.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.ecommerce.category.dto.CategoryDTO;
import cybersoft.javabackend.ecommerce.category.model.Category;
import cybersoft.javabackend.ecommerce.category.repository.CategoryRepository;
import cybersoft.javabackend.ecommerce.category.util.CategoryConverter;



@Service
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository repository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		repository=categoryRepository;
	}
	
	@Override
	public List<CategoryDTO> findByCode(String code) {
		List<Category> categories = repository.findByCode(code);
		
		return CategoryConverter.toCategoryDTOs(categories);
	}

	@Override
	public CategoryDTO create(CategoryDTO dto) {
		Category category = CategoryConverter.toCategory(dto);
		
		Category createdCategory = repository.save(category);
		
		return CategoryConverter.toCategoryDTO(createdCategory);
	}

	@Override
	public Optional<Category> findByName(String categoryName) {
		
		return repository.findByName(categoryName);
	}
	
}
