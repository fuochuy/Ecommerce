package cybersoft.javabackend.ecommerce.categories.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cybersoft.javabackend.ecommerce.product.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name="categories")
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name", unique = true)
	private String name;
	
	@Column(name="image", nullable = false)
	private String image;
	
	@Column(name="icon")
	private String icon;
	
	@OneToMany(mappedBy = "categoryId")
	private Set<Product> listProduct = new HashSet<>();
	
}

