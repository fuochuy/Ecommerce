package cybersoft.javabackend.ecommerce.product.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cybersoft.javabackend.ecommerce.orderDetails.model.OrderDetails;
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
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name", nullable = false, unique = true)
	private String name;
	
	@Column(name="unitBrief", nullable = false)
	private String unitBrief;
	
	@Column(name="unitPrice", nullable = false)
	private float unitPrice;
	
	@Column(name="image", nullable = false)
	private String image;
	
	@Column(name="productDate", nullable = false)
	private Date productDate;
	
	@Column(name="available", nullable = false)
	private int available;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="categoryId", nullable = false)
	private int categoryId;
	
	@Column(name="supplierId", nullable = false)
	private int supplierId;
	
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
	
	@OneToMany(mappedBy = "productId")
	private Set<OrderDetails> listOrderDetails = new HashSet<>();
	
	
}

