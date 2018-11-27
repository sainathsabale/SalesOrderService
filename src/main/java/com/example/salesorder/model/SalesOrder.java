package com.example.salesorder.model;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SalesOrder")
public class SalesOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="salesOrderId")
	private long salesOrderId;
	
	@Column(name="customerId")
	private long customerId;
	
	
	@Column(name="orderDescription")
	private String orderDescription;
	
	@Column(name="totalPrice")
	private double totalPrice;
	
	@Column(name="orderedDate")
	private Date orderedDate;
	
	@OneToMany(mappedBy="salesOrder")
	private Set<OrderedOnlineItem> items;

		
	public SalesOrder() {
		super();
	}

	public SalesOrder(long id, long customerId, String orderDescription, double totalPrice, Date orderedDate,
			Set<OrderedOnlineItem> items) {
		super();
		this.salesOrderId = id;
		this.customerId = customerId;
		this.orderDescription = orderDescription;
		this.totalPrice = totalPrice;
		this.orderedDate = orderedDate;
		this.items = items;
	}

	public long getId() {
		return salesOrderId;
	}

	public void setId(long id) {
		this.salesOrderId = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId2) {
		this.customerId = customerId;
	}
	
	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Set<OrderedOnlineItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderedOnlineItem> items) {
		this.items = items;
	}
	
	
	
	
}