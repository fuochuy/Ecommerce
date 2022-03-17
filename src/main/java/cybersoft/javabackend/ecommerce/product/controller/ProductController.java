package cybersoft.javabackend.ecommerce.product.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import cybersoft.javabackend.ecommerce.product.dto.ProductDTO;
import cybersoft.javabackend.ecommerce.product.dto.UpdateProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Product Controller", description="Product endpoints")
public interface ProductController {
	@Operation(method = "get", description = "get all products")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "get products successfully"),
			@ApiResponse(responseCode = "403", description = "do not have the correct authorization")
	})
	@GetMapping(value = "/products", produces = "application/json")
	public ResponseEntity<Object> getProducts();
	
	
	@Operation(method = "post", description = "create new product")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "invalid product"),
		@ApiResponse(responseCode = "200", description = "created product successfully")
	})
	@PostMapping(value = "/product")
	public ResponseEntity<Object> createProduct(
			@Parameter(description = "product dto") @Valid @RequestBody ProductDTO dto,
				BindingResult bindingResult
			);
	@GetMapping("/contact")
	public ModelAndView contact();
	
	@PutMapping(value = "/product/{id}")
	public ResponseEntity<Object> updateRole(
			@Parameter(description = "product id") @PathVariable("id") long id,
			@Parameter(description = "product dto") @Valid @RequestBody UpdateProductDTO dto,
				BindingResult bindingResult
			);
	
	@Operation(method = "delete", description = "delete product",
			responses = {
					@ApiResponse(responseCode = "400", description = "invalid id"),
					@ApiResponse(responseCode = "200", description = "deleted product successfully")
			})
	@DeleteMapping(value = "/product/{id}")
	public ResponseEntity<Object> deleteProduct(
			@Parameter(description = "product id") @PathVariable("id") long id
			);
	
	@Operation(method = "get", description = "get product by id")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "get product successfully"),
			@ApiResponse(responseCode = "403", description = "do not have the correct authorization")
	})
	@GetMapping(value = "/product{id}", produces = "application/json")
	public ResponseEntity<Object> getProductById(
			@Parameter(description = "product id") @PathVariable("id") long id
			);
	
	@Operation(method = "get", description = "get product by name")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "get product successfully"),
			@ApiResponse(responseCode = "403", description = "do not have the correct authorization")
	})
	@GetMapping(value = "/search-product{name}", produces = "application/json")
	public ResponseEntity<Object> getProductByName(
			@Parameter(description = "product name") @PathVariable("name") String name
			);
	
	
}
