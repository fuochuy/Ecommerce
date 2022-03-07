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
	
	@Column(name="unit_brief", nullable = false)
	private String unit_brief;
	
	@Column(name="unit_price", nullable = false)
	private float unit_price;
	
	@Column(name="image", nullable = false)
	private String image;
	
	@Column(name="product_date", nullable = false)
	private Date product_date;
	
	@Column(name="available", nullable = false)
	private int available;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="supplier_id", nullable = false)
	private long supplierId;
	
	@Column(name="quantity", nullable = false)
	private int quantity;
	
	@Column(name="discount", nullable = false)
	private float discount;
	
	@Column(name="special", nullable = false)
	private int special;
	
	@Column(name="latest", nullable = false)
	private int latest;
	
	@Column(name="views", nullable = false)
	private int views;
	
}