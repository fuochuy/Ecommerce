package cybersoft.javabackend.ecommerce.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cybersoft.javabackend.ecommerce.common.ResponseHandler;

@RestControllerAdvice
public class StockHandlerException {
	@ExceptionHandler(InvalidProductException.class)
	public Object handleInvalidStockException(InvalidStockException e) {
		
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
