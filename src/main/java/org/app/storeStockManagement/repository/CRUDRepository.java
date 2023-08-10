package org.app.storeStockManagement.repository;

import org.app.storeStockManagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CRUDRepository extends JpaRepository<Product, Integer>{
	
	
}
