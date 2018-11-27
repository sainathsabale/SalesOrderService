package com.example.salesorder.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank; 
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

 
@Entity
@Table(name="SalesOrderService")
@EntityListeners(AuditingEntityListener.class)
public class SalesOrderService implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)  
	@Column(name="CustomerId")
	private Long customerId;
	
	@NotBlank
	@Column(name="CustFirstName")
	private String custFirstName;
	
	@NotBlank
	@Column(name="CustLastName")
	private String custLastName;
	
	@NotBlank
	@Column(name="CustEmailID")
	private String custEmailId;
	
	public SalesOrderService() {
		
	}
	
	public SalesOrderService(Long customerId, String firstName, String lastName, String emailId) {
		super();
		this.customerId = customerId;
		this.custFirstName = firstName;
		this.custLastName = lastName;
		this.custEmailId = emailId;		
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustEmailId() {
		return custEmailId;
	}

	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}
 

}
