package cybersoft.javabackend.ecommerce.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.ecommerce.product.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

	//@Query("select stock.id, stock.product_id, stock.size_id, stock.color_id, stock.stock from stock where stock.product_id = :product_id")
	Optional<List<Stock>> findByProduct_id(long product_id);
}
