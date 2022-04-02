package cybersoft.javabackend.ecommerce.product.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import cybersoft.javabackend.ecommerce.product.model.Stock;

public interface StockService {
	List<Stock> findAll();

	Stock create(@Valid Stock stock);

	Stock updateStock(long id, @Valid Stock stock);

	void deleteStock(long id);

	Optional<Stock> findById(long id);

	List<Stock> findByProduct_id(long product_id);
}
