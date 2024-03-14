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
	
	public Customer findCustomerByID(int id) throws Exception {
		return customerDB.findCustomerByID(id);
	}
	
//	public Customer updateCustomer(Customer c) throws Exception {
//		return customerDB.updateCustomer();
//	}
}
