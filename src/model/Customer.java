package model;

public class Customer {

	private int customerID;
	private String name;
	private String address;
	private int zipcode;
	private String phoneNo;
	private String email;
	
	public Customer(int customerID, String name, String address, int zipcode, String phoneNo, String email) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.phoneNo = phoneNo;
		this.email = email;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerID + ", name=" + name + ", address=" + address + ", zipcode=" + zipcode
				+ ", phoneNo=" + phoneNo + ", email=" + email + "]";
	}
	
	
	
	
	}
