package cybersoft.javabackend.ecommerce.product.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import cybersoft.javabackend.ecommerce.product.model.Size;
import cybersoft.javabackend.ecommerce.product.repository.SizeRepository;

@Service
public class SizeServiceImpl implements SizeService{

	private SizeRepository repository;
	
	public SizeServiceImpl(SizeRepository sizeRepository) {
		repository=sizeRepository;
	}
	@Override
	public Size create(@Valid Size size) {
		// TODO Auto-generated method stub
		return repository.save(size);
	}

	@Override
	public Optional<Size> findById(long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

}
