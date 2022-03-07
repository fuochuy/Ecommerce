/*
package cybersoft.javabackend.ecommerce.order.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cybersoft.javabackend.ecommerce.orderDetails.model.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
@MappedSuperclass
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="customer_id", nullable = false)
	private int customer_id;
	
	@Column(name="order_date", nullable = false)
	private Date order_date;
	
	@Column(name="require_date", nullable = false)
	private Date require_date;
	
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
	
	//@OneToMany(mappedBy = "order_id")
	//private Set<OrderDetails> listOrderDetails = new HashSet<>();
	
	
}
*/