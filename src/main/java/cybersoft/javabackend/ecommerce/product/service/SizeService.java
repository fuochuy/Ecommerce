package cybersoft.javabackend.ecommerce.product.service;

import java.util.Optional;

import javax.validation.Valid;

import cybersoft.javabackend.ecommerce.product.model.Size;

public interface SizeService {
	
	Size create(@Valid Size dto);
	Optional<Size> findById(long id);
}
