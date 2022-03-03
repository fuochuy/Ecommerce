package cybersoft.javabackend.ecommerce.categories.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import cybersoft.javabackend.ecommerce.categories.model.Categories;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="CategoriesController", description="Categories endpoints")
public interface CategoriesController {
	
	@Operation(method = "get", description = "get all categories")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "get all categories successfully"),
			@ApiResponse(responseCode = "403", description = "do not have the correct authorization")
	})
	@GetMapping(value = "/categories", produces = "application/json")
	public ResponseEntity<List<Categories>> getCategories();
}
