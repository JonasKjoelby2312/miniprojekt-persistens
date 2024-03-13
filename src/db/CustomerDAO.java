package db;

import java.util.List;

import model.Customer;

public interface CustomerDAO {
	
		List<Customer> findAllCustomers() throws Exception;
		Customer findByPhone(String phone) throws Exception;
		void updateCustomer(Customer c) throws Exception;
	}



