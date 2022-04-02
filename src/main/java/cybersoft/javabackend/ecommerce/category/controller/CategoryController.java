package cybersoft.javabackend.ecommerce.category.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cybersoft.javabackend.ecommerce.category.dto.CategoryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Category Controller", description="Category endpoints")
public interface CategoryController {
	
	@Operation(method = "get", description = "get all categories")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "get categories successfully"),
			@ApiResponse(responseCode = "403", description = "do not have the correct authorization")
	})
	@GetMapping(value = "/shop", produces = "application/json")
	public String loadShop(Model model);
	
	
	@Operation(method = "post", description = "create new category")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "invalid category"),
		@ApiResponse(responseCode = "200", description = "created category successfully")
	})
	@PostMapping(value = "/category")
	public ResponseEntity<Object> createCategory(
			@Parameter(description = "category dto") @Valid @RequestBody CategoryDTO dto,
				BindingResult bindingResult
			);
	
}
