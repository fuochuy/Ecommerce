package cybersoft.javabackend.ecommerce.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.ecommerce.product.model.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long>{

}
