package cybersoft.javabackend.ecommerce.product.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.ecommerce.product.exception.InvalidProductException;
import cybersoft.javabackend.ecommerce.product.exception.InvalidStockException;
import cybersoft.javabackend.ecommerce.product.model.Stock;
import cybersoft.javabackend.ecommerce.product.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{

	private StockRepository repository;
	
	public StockServiceImpl(StockRepository stockRepository) {
		repository=stockRepository;
	}
	
	



	@Override
	public List<Stock> findAll() {
		return repository.findAll();
	}

	@Override
	public Stock create(@Valid Stock stock) {
		return repository.save(stock);
	}

	@Override
	public Stock updateStock(long id, @Valid Stock stock) {
		Optional<Stock> productOpt = repository.findById(id);

		if (!productOpt.isPresent()) {
			throw new InvalidStockException("Product id is not valid");
		}
		
		Stock stockCurrent = productOpt.get();
		
		
		
		
		stockCurrent.setProduct_id(stock.getProduct_id());
		stockCurrent.setColor_id(stock.getColor_id());
		stockCurrent.setSize_id(stock.getSize_id());
		stockCurrent.setStock(stock.getStock());

		Stock updatedProduct = repository.save(stockCurrent);
		
	
		return updatedProduct;
	}

	@Override
	public void deleteStock(long id) {
		Optional<Stock> stockOpt = repository.findById(id);
		
		if (!stockOpt.isPresent())
			throw new InvalidStockException("Stock ID is not existed.");
		
		repository.delete(stockOpt.get());
		
	}

	@Override
	public Optional<Stock> findById(long id) {
		return repository.findById(id);
	}

	@Override
	public List<Stock> findByProduct_id(long product_id) {
		Optional<List<Stock>> stockOpt = repository.findByProduct_id(product_id);
		
		if (!stockOpt.isPresent()) {
			throw new InvalidProductException("Product id is not valid");
		}
		
		 List<Stock> stocks = stockOpt.get();
		 return stocks;
	}

}
