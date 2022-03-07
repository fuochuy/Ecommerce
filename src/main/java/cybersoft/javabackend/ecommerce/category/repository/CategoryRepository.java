package cybersoft.javabackend.ecommerce.category.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.ecommerce.category.dto.CategoryDTO;
import cybersoft.javabackend.ecommerce.category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	@Query(value = "SELECT c.id, c.name, c.image, c.icon FROM categories c",nativeQuery = true)
	List<CategoryDTO> findAllDTO();

	Optional<Category> findByName(String categoryName);
}
