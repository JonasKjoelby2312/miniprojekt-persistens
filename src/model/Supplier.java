package model;

public class Supplier {
	
	private int supplierID;
	private String name;
	private String address;
	private String country;
	private String phoneNo;
	private String email;
	private String cvr;
	
	public Supplier(String name, String address, String country, String phoneNo, String email, String cvr) {
		super();
		this.name = name;
		this.address = address;
		this.country = country;
		this.phoneNo = phoneNo;
		this.email = email;
		this.cvr = cvr;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getCvr() {
		return cvr;
	}

	public void setCvr(String cvr) {
		this.cvr = cvr;
	}
	
	

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	@Override
	public String toString() {
		return "Supplier [supplierID=" + supplierID + ", name=" + name + ", address=" + address + ", country=" + country
				+ ", phoneNo=" + phoneNo + ", email=" + email + ", cvr=" + cvr + "]";
	}

	
}
