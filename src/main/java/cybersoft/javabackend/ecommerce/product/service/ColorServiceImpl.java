package cybersoft.javabackend.ecommerce.product.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.ecommerce.product.model.Color;
import cybersoft.javabackend.ecommerce.product.repository.ColorRepository;

@Service
public class ColorServiceImpl implements ColorService{

	private ColorRepository repository;
	
	public ColorServiceImpl(ColorRepository colorRepository) {
		repository=colorRepository;
	}
	@Override
	public Color create(@Valid Color size) {
		// TODO Auto-generated method stub
		return repository.save(size);
	}

	@Override
	public Optional<Color> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}
