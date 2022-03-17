package cybersoft.javabackend.ecommerce.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.ecommerce.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	public List<Product> findAll();
	public Optional<Product> findByName(String name);
	public Optional<List<Product>> findByNameContaining(String name);

}
