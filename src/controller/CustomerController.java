package controller;

import java.util.List;

import db.CustomerDAO;
import db.CustomerDB;
import model.Customer;


public class CustomerController {
	//Instance variables
	private CustomerDAO customerDB;
	
	//Instantiates an object of the CustomerController class
	public CustomerController() throws Exception{
		customerDB = new CustomerDB();
	}
	
	public List<Customer> findAllCustomers() throws Exception {
		return customerDB.findAllCustomers();
	}
	
	public Customer findCustomerByPhone(String phone) throws Exception {
		return customerDB.findCustomerByPhone(phone);
	}
	
//	public Customer updateCustomer(Customer c) throws Exception {
//		return customerDB.updateCustomer();
//	}
}
