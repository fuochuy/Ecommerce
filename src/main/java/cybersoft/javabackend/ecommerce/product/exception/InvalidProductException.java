package cybersoft.javabackend.ecommerce.product.exception;

public class InvalidProductException extends RuntimeException{
	public InvalidProductException() {
		super();
	}
	
	public InvalidProductException(String message) {
		super(message);
	}
	
	public InvalidProductException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
