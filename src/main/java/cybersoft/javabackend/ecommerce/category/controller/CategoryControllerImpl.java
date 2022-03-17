package cybersoft.javabackend.ecommerce.category.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cybersoft.javabackend.ecommerce.category.dto.CategoryDTO;
import cybersoft.javabackend.ecommerce.category.service.CategoryService;
import cybersoft.javabackend.ecommerce.common.ResponseHandler;

@RestController
public class CategoryControllerImpl implements CategoryController{

	private CategoryService service;
	
	public CategoryControllerImpl(CategoryService categoryService) {
		service = categoryService;
	}

	@Override
	public ResponseEntity<Object> getCategories() {
		List<CategoryDTO> categories = service.findAllDTO();
		
		return ResponseHandler.getResponse(categories, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createCategory(CategoryDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		CategoryDTO createdCategory = service.create(dto);
		
		return ResponseHandler.getResponse(createdCategory, HttpStatus.OK);
	}

	@Override
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index");
	    return modelAndView;
	}
	

}
