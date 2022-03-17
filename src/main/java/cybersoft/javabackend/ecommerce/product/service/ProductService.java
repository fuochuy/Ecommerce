package cybersoft.javabackend.ecommerce.product.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import cybersoft.javabackend.ecommerce.product.dto.ProductDTO;
import cybersoft.javabackend.ecommerce.product.dto.UpdateProductDTO;
import cybersoft.javabackend.ecommerce.product.model.Product;

public interface ProductService {

	List<ProductDTO> findAllDTO();

	ProductDTO create(@Valid ProductDTO dto);

	ProductDTO updateProduct(long id, @Valid UpdateProductDTO dto);

	void deleteProduct(long id);

	Optional<Product> findById(long id);

	List<ProductDTO> findByName(String name);

}
