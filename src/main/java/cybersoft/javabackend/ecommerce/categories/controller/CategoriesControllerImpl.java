package cybersoft.javabackend.ecommerce.categories.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.ecommerce.categories.model.Categories;

@RestController
public class CategoriesControllerImpl implements CategoriesController{

	@Override
	public ResponseEntity<List<Categories>> getCategories() {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(null,HttpStatus.OK);
	}

}
