/*
package cybersoft.javabackend.ecommerce.orderDetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import cybersoft.javabackend.ecommerce.order.model.Order;
import cybersoft.javabackend.ecommerce.product.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name="order_details")
@MappedSuperclass
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	

	@Column(name="order_id", nullable = false)
	private int order_id;
	
	
	@Column(name="product_id", nullable = false)
	private int product_id;
	
	@Column(name="unit_price", nullable = false)
	private float unit_price;
	
	@Column(name="quantity", nullable = false)
	private int quantity;
	
	@Column(name="discount", nullable = false)
	private float discount;
	
	
}
*/
