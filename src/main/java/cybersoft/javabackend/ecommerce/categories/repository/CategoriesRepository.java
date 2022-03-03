package cybersoft.javabackend.ecommerce.categories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.ecommerce.categories.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>{

}
