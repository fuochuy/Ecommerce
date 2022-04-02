package cybersoft.javabackend.ecommerce.product.service;

import java.util.Optional;

import javax.validation.Valid;

import cybersoft.javabackend.ecommerce.product.model.Color;

public interface ColorService {
	Color create(@Valid Color color);
	Optional<Color> findById(long id);
}
