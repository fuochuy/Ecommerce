package cybersoft.javabackend.ecommerce.order.model;

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
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="customerId", nullable = false)
	private int customerId;
	
	@Column(name="orderDate", nullable = false)
	private Date orderDate;
	
	@Column(name="requireDate", nullable = false)
	private Date requireDate;
	
	@Column(name="receiver", nullable = false)
	private String receiver;
	
	@Column(name="address", nullable = false)
	private String address;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="amount", nullable = false)
	private float amount;
	
	@Column(name="phone", nullable = false)
	private String phone;
	
	@OneToMany(mappedBy = "orderId")
	private Set<OrderDetails> listOrderDetails = new HashSet<>();
	
	
}
