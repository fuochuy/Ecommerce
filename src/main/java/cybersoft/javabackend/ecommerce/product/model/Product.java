package cybersoft.javabackend.ecommerce.product.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import cybersoft.javabackend.ecommerce.category.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name="products")
public class Product{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	
	
	@Column(name="name", nullable = false, unique = true)
	private String name;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="image1")
	private String image1;
	
	@Column(name="image2")
	private String image2;
	
	@Column(name="image3")
	private String image3;
	
	@Column(name="size")
	private String size;
	
	@Column(name="color")
	private String color;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="price")
	private float price;
	
	@Column(name="discount")
	private float discount;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="quantity_sold")
	private int quantity_sold;
	
	@Column(name="category_id")
	private long category_id;
	
	@ManyToOne
	@JoinColumn(name="category_id", insertable = false, updatable = false)
	private Category category;
	
}