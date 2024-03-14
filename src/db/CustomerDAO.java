package db;

import java.util.List;

import model.Customer;

public interface CustomerDAO {
	
		List<Customer> findAllCustomers() throws Exception;
		Customer findCustomerByID(int id) throws Exception;
		void updateCustomer(Customer c) throws Exception;
	}



