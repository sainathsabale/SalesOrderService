package com.example.salesorder.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


 
import com.example.salesorder.model.OrderedOnlineItem;
import com.example.salesorder.model.SalesOrder;
import com.example.salesorder.modelobject.ProjectStatus;
import com.example.salesorder.modelobject.SalesOrderList;
import com.example.salesorder.repository.SalesOrderRepository;
import com.example.salesorder.repository.CustomerSalesOrderServiceRepository;

@RestController
public class SalesOrderServiceController {

	@Autowired
	private SalesOrderRepository salesOrderRepository ;

	@PostMapping(value="/createOrder")
	public ResponseEntity CreateOrder(@RequestBody SalesOrderList salesOrderList ) {
		
		 String orderDesc = salesOrderList.getOrderDescription();
		 long customerId = salesOrderList.getCustomerId();
		 List<com.example.salesorder.model.Items> itemList = salesOrderList.getItemList();
         int totalPrice = itemList.stream().mapToInt(s -> s.getItemPrice()).sum();
		 System.out.println(orderDesc +"   "+customerId +""+ totalPrice ); 
		
		
		
		
		 SalesOrder salesOrder = new SalesOrder();		
		 salesOrder.setOrderDescription(orderDesc);
		 salesOrder.setCustomerId(customerId);
		 salesOrder.setTotalPrice(totalPrice);
		 
		 
		 //List
		 
		/* List<OrderedOnlineItem> iList = new ArrayList<>();		
		 
		 itemList.forEach(list -> {
			 OrderedOnlineItem orderedItem = new OrderedOnlineItem();
			 
		 });

		 orderedItem.setItemName("Iphone");
		 orderedItem.setQuantity(5);
		 orderedItem.setItemId(11);
		 iList.add(itemList);			
		 System.out.println("1");*/
		 
		 //salesOrder.setItems(iList);		 
		 
		 try {
		 salesOrderRepository.save(salesOrder);		 
		 } catch (Exception e) {			 
			 System.out.println("Exception thrown: "+e.getStackTrace().toString());
		 }
		return  new ResponseEntity<ProjectStatus>(new ProjectStatus("Success..."), HttpStatus.OK);
	}
	
	
	public static String getOrderNumber(){
	    
	    String x =  Double.toString(Math.random());
	    LocalDateTime localDateTime = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = localDateTime.format(formatter);
        String randomNumber = x.concat(formatDateTime); 
	    return x;
	}
	
	
	public static DateTimeFormatter getLocalTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       return formatter;
	}
	
	
}
