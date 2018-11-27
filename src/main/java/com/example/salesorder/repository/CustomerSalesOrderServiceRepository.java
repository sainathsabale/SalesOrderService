package com.example.salesorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.salesorder.model.SalesOrderService;

@Repository
public interface CustomerSalesOrderServiceRepository extends JpaRepository<SalesOrderService, Long> {
	
	

}
