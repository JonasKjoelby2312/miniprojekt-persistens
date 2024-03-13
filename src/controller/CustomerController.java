package controller;

import java.util.ArrayList;

import db.CustomerDB;
import model.Customer;

public class CustomerController {
	//Instance variables
	private CustomerDB customerDB;
	
	//Instantiates an object of the CustomerController class
	public CustomerController() {
		customerDB = CustomerDB.getInstance();
	}
	
	public ArrayList<Customer> findAllCustomers() throws Exception {
		ArrayList<Customer> res = new ArrayList<>();
		return res;
	}
	
	public Customer findCustomerByPhone(String phone) throws Exception {
		return customerDB.findByPhone(phone);
	}
	
	public Customer updateCustomer(Customer c) {
		return customerDB.updateCustomer();
	}
}
