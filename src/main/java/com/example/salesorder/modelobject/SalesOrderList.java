package com.example.salesorder.modelobject;

import java.util.List;

import com.example.salesorder.model.Items;


public class SalesOrderList {
	

	private String orderDescription;
	private long customerId;
	private List<Items> itemList;
	
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public List<Items> getItemList() {
		return itemList;
	}
	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}
	

	
	

}
