package org.app.storeStockManagement.repository;

import org.app.storeStockManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository contains all the basic methods required for the database communication
public interface AuthenticationRepository extends JpaRepository<Employee, Integer>{
	public Employee findAllByEmailId(String emailId);
	public Employee findAllByEmailIdAndPassword(String emailId, String password);
}
