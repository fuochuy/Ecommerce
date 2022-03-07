package cybersoft.javabackend.ecommerce.category.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.ecommerce.category.validation.validator.UniqueCategoryNameValidator;

@Constraint(validatedBy = UniqueCategoryNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCategoryName {
	String message() default "Category name is used.";
	
	Class <?>[] groups() default {};
	Class<? extends Payload>[] payload() default{};
}
