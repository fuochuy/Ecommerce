package cybersoft.javabackend.ecommerce.category.exception;

public class InvalidCategoryException extends RuntimeException{
	public InvalidCategoryException() {
		super();
	}
	
	public InvalidCategoryException(String message) {
		super(message);
	}
	
	public InvalidCategoryException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
	