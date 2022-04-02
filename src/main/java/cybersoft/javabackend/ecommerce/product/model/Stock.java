package cybersoft.javabackend.ecommerce.product.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name="stock")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="product_id")
	private long product_id;
	
	@Column(name="color_id")
	private long color_id;
	
	@Column(name="size_id")
	private long size_id;
	
	@Column(name="stock")
	private int stock;
	
	@ManyToOne
	@JoinColumn(name="product_id", insertable = false, updatable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="size_id", insertable = false, updatable = false)
	private Size size;
	
	@ManyToOne
	@JoinColumn(name="color_id", insertable = false, updatable = false)
	private Color color;
}
