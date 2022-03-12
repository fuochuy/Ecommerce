package cybersoft.javabackend.ecommerce.category.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cybersoft.javabackend.ecommerce.common.ResponseHandler;
import cybersoft.javabackend.ecommerce.role.exception.InvalidRoleException;

@RestControllerAdvice
public class CategoryHandlerException {
	@ExceptionHandler(InvalidRoleException.class)
	public Object handleInvalidRoleException(InvalidRoleException e) {
		
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
