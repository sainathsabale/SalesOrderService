package com.example.salesorder.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OrderedOnlineItem")
public class OrderedOnlineItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="itemId")
	private int itemId;
	
	@Column(name="itemName")
	private String itemName;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="salesOrderId")
	private SalesOrder salesOrderId;
	
	//Hibernate requires no-args constructor
	public OrderedOnlineItem(){}
	
	public OrderedOnlineItem(int itemId, String itemName, int qty, SalesOrder c){
		this.itemId=itemId;
		this.itemName=itemName;
		this.quantity=qty;
		this.salesOrderId=c;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public SalesOrder getSalesOrder() {
		return salesOrderId;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrderId = salesOrder;
	}

	
	
	
}