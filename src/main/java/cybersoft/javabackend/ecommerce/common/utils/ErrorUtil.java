package cybersoft.javabackend.ecommerce.common.utils;

import java.util.LinkedList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ErrorUtil {

	public static Object solveError(BindingResult bindingResult) {
		List<String> errorMessages = new LinkedList<String>();
		List<ObjectError> errors = bindingResult.getAllErrors();
		
		for(ObjectError erorr: errors) {
			errorMessages.add(erorr.getDefaultMessage());
		}
		return errorMessages;
	}

}
