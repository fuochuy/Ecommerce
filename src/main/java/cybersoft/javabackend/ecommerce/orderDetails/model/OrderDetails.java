package cybersoft.javabackend.ecommerce.orderDetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="orderDetails")
public class OrderDetails {
	
	@ManyToOne
	@JoinColumn(name="orderId", nullable = false)
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name="productId", nullable = false)
	private int productId;
	
	@Column(name="unitPrice", nullable = false)
	private float unitPrice;
	
	@Column(name="quantity", nullable = false)
	private int quantity;
	
	@Column(name="discount", nullable = false)
	private float discount;
	
	
}
