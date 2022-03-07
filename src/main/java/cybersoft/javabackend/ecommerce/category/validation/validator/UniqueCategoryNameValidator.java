package cybersoft.javabackend.ecommerce.category.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.ecommerce.category.model.Category;
import cybersoft.javabackend.ecommerce.category.service.CategoryService;
import cybersoft.javabackend.ecommerce.category.validation.annotation.UniqueCategoryName;

public class UniqueCategoryNameValidator implements ConstraintValidator<UniqueCategoryName, String>{

	@Autowired
	private CategoryService service;
	private String message;
	
	@Override
	public void initialize(UniqueCategoryName uniqueCategoryNameAnnotation) {
		ConstraintValidator.super.initialize(uniqueCategoryNameAnnotation);
		this.message = uniqueCategoryNameAnnotation.message();
	}
	@Override
	public boolean isValid(String categoryName, ConstraintValidatorContext context) {
		Optional<Category> categoryOpt = service.findByName(categoryName);
		if(!categoryOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
		       .addConstraintViolation()
		       .disableDefaultConstraintViolation();
		return false;
	}
	
}
