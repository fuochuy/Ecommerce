package cybersoft.javabackend.ecommerce.product.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="unitBrief")
	private String unitBrief;
	
	@Column(name="unitPrice")
	private float unitPrice;
	
	@Column(name="image")
	private String image;
	
	@Column(name="productDate")
	private Date productDate;
	
	@Column(name="available")
	private int available;
	
	@Column(name="description")
	private String description;
	
	@Column(name="categoryId")
	private int categoryId;
	
	@Column(name="supplierId")
	private int supplierId;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="discount")
	private float discount;
	
	@Column(name="special")
	private int special;
	
	@Column(name="latest")
	private int latest;
	
	@Column(name="views")
	private int views;
	
	@OneToMany(mappedBy = "productId")
	private Set<OrderDetails> listOrderDetails = new HashSet<>();
	
	
}

