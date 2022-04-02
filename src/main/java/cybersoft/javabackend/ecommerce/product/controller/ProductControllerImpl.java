package cybersoft.javabackend.ecommerce.product.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cybersoft.javabackend.ecommerce.common.ResponseHandler;
import cybersoft.javabackend.ecommerce.product.dto.ProductDTO;
import cybersoft.javabackend.ecommerce.product.dto.UpdateProductDTO;
import cybersoft.javabackend.ecommerce.product.exception.InvalidProductException;
import cybersoft.javabackend.ecommerce.product.model.Product;
import cybersoft.javabackend.ecommerce.product.service.ProductService;
import cybersoft.javabackend.ecommerce.product.util.ProductConverter;

@RestController
public class ProductControllerImpl implements ProductController{
	
	private ProductService service;
	
	public ProductControllerImpl(ProductService productService) {
		service = productService;
	}
	
	@Override
	public ResponseEntity<Object> getProducts() {
		List<ProductDTO> products = service.findAllDTO();
		
		return ResponseHandler.getResponse(products, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createProduct(@Valid ProductDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		ProductDTO createdProduct = service.create(dto);
		
		return ResponseHandler.getResponse(createdProduct, HttpStatus.OK);
	}

	@Override
	public ModelAndView contact() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("contact");
	    return modelAndView;
	}

	@Override
	public ResponseEntity<Object> updateRole(long id, @Valid UpdateProductDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		ProductDTO updatedProduct = service.updateProduct(id, dto);
		
		return ResponseHandler.getResponse(updatedProduct, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteProduct(long id) {
		
		service.deleteProduct(id);
		return ResponseHandler.getResponse("Deleted role successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getProductById(long id) {
		Optional<Product> productOpt = service.findById(id);
		
		if (!productOpt.isPresent()) {
			throw new InvalidProductException("productOpt id is not valid");
		}
		
		Product product = productOpt.get();
		ProductDTO productDTO = ProductConverter.toProductDTO(product);
		return ResponseHandler.getResponse(productDTO, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getProductByName(String name) {
		List<ProductDTO> productDTO = service.findByName(name);

		return ResponseHandler.getResponse(productDTO, HttpStatus.OK);
	}
}
