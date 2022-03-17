package cybersoft.javabackend.ecommerce.product.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.ecommerce.product.dto.ProductDTO;
import cybersoft.javabackend.ecommerce.product.dto.UpdateProductDTO;
import cybersoft.javabackend.ecommerce.product.exception.InvalidProductException;
import cybersoft.javabackend.ecommerce.product.model.Product;
import cybersoft.javabackend.ecommerce.product.repository.ProductRepository;
import cybersoft.javabackend.ecommerce.product.util.ProductConverter;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		repository=productRepository;
	}
	@Override
	public List<ProductDTO> findAllDTO() {
		List<Product> products = repository.findAll();
		
		return ProductConverter.toProductDTOs(products);
	}
	@Override
	public ProductDTO create(@Valid ProductDTO dto) {
		Product product = ProductConverter.toProduct(dto);
		
		Product createdProduct = repository.save(product);
		
		return ProductConverter.toProductDTO(createdProduct);
	}
	@Override
	public ProductDTO updateProduct(long id, @Valid UpdateProductDTO dto) {
		Optional<Product> productOpt = repository.findById(id);

		if (!productOpt.isPresent()) {
			throw new InvalidProductException("Product id is not valid");
		}
		
		Product product = productOpt.get();
		
		if (!product.getName().equals(dto.getName())) {
			if (repository.findByName(dto.getName()).isPresent()) {
				throw new InvalidProductException("Product name has been used.");
			}
			
			product.setName(dto.getName());
		}
		
		
		product.setCategory_id(dto.getCategory_id());
		product.setDescription(dto.getDescription());
		product.setImage1(dto.getImage1());
		product.setImage2(dto.getImage2());
		product.setImage3(dto.getImage3());
		product.setSize(dto.getSize());
		product.setColor(dto.getColor());
		product.setBrand(dto.getBrand());
		product.setPrice(dto.getPrice());
		product.setDiscount(dto.getDiscount());
		product.setQuantity(dto.getQuantity());
		product.setQuantity_sold(dto.getQuantity_sold());
		
		Product updatedProduct = repository.save(product);
		
		return ProductConverter.toProductDTO(updatedProduct);
	}
	@Override
	public void deleteProduct(long id) {
		Optional<Product> productOpt = repository.findById(id);
		
		if (!productOpt.isPresent())
			throw new InvalidProductException("Product ID is not existed.");
		
		repository.delete(productOpt.get());
		
	}
	@Override
	public Optional<Product> findById(long id) {
		return repository.findById(id);
	}
	@Override
	public List<ProductDTO> findByName(String name) {
		Optional<List<Product>> productsOpt = repository.findByNameContaining(name);
		
		if (!productsOpt.isPresent()) {
			throw new InvalidProductException("Product id is not valid");
		}
		
		List<Product> products = productsOpt.get();
		return ProductConverter.toProductDTOs(products);
	}

}
