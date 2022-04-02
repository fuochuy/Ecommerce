package cybersoft.javabackend.ecommerce.common.exception;

public class IncorrectLoginException extends EcommerceRuntimeException{
	public IncorrectLoginException (String message) {
		super(message);
	}
}
