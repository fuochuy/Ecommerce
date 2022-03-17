package cybersoft.javabackend.ecommerce.product.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
	
	@ManyToOne
	private Category category;
	
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
	
}