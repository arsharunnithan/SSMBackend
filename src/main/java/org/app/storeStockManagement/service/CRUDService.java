package org.app.storeStockManagement.service;

import java.util.List;
import java.util.Optional;

import org.app.storeStockManagement.model.Product;
import org.app.storeStockManagement.repository.CRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CRUDService {

	@Autowired
	private CRUDRepository crudRepository;
	
	public List<Product> fetchProductsList(){
		return crudRepository.findAll();
	}
	public Product addProductToDb(Product product) {
		return crudRepository.save(product);
	}
	//if product is present it will return it but if not it will return blank product
	public Optional<Product> fetchProductById(int id) {
		return crudRepository.findById(id);
	}
	public String deleteProductById(int id) {
		String result;
//		try {
//			crudRepository.deleteById(id);
//			result="Product succesfully deleted";
//			
//		} catch (Exception e) {
//			result="product is not deleted";
//		}
		Optional<Product> product = crudRepository.findById(id);
	    
	    if (product.isPresent()) {
	        try {
	            crudRepository.deleteById(id);
	            result = "Product successfully deleted";
	        } catch (Exception e) {
	            result = "Product deletion failed";
	        }
	    } else {
	        result = "Product not found";
	    }
	    
		return result;
	}
}
