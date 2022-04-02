package cybersoft.javabackend.ecommerce.product.exception;

public class InvalidStockException extends RuntimeException{
	public InvalidStockException() {
		super();
	}
	
	public InvalidStockException(String message) {
		super(message);
	}
	
	public InvalidStockException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
