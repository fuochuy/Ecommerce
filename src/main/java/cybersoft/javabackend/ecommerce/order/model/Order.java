package cybersoft.javabackend.ecommerce.order.model;

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
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="customerId")
	private int customerId;
	
	@Column(name="orderDate")
	private Date orderDate;
	
	@Column(name="requireDate")
	private Date requireDate;
	
	@Column(name="receiver")
	private String receiver;
	
	@Column(name="address")
	private String address;
	
	@Column(name="description")
	private String description;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="phone")
	private String phone;
	
	@OneToMany(mappedBy = "orderId")
	private Set<OrderDetails> listOrderDetails = new HashSet<>();
	
	
}
