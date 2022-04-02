package cybersoft.javabackend.ecommerce.category.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import cybersoft.javabackend.ecommerce.category.dto.CategoryDTO;
import cybersoft.javabackend.ecommerce.category.service.CategoryService;
import cybersoft.javabackend.ecommerce.common.ResponseHandler;
import cybersoft.javabackend.ecommerce.product.dto.ProductDTO;
import cybersoft.javabackend.ecommerce.product.service.ProductService;

@Controller
public class CategoryControllerImpl implements CategoryController{

	private CategoryService service;
	private ProductService productService;
	
	public CategoryControllerImpl(CategoryService categoryService, ProductService productService) {
		service = categoryService;
		this.productService = productService;
	}

	@Override
	public String loadShop(Model model) {
		List<CategoryDTO> Women = service.findByCode("Women");
		List<CategoryDTO> Men = service.findByCode("Men");
		List<CategoryDTO> Kid = service.findByCode("Kid");	
		model.addAttribute("Women",Women);
		model.addAttribute("Men",Men);
		model.addAttribute("Kid",Kid);
		
		List<ProductDTO> products = productService.findAllDTO();
		model.addAttribute("products",products);
		
		return "shop";
	}

	@Override
	public ResponseEntity<Object> createCategory(CategoryDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		CategoryDTO createdCategory = service.create(dto);
		
		
		return ResponseHandler.getResponse(createdCategory, HttpStatus.OK);
	}

	
	

}
