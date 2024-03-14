package model;

public class Employee {

	private int employeeID;
	private String name;
	private String companyPosition;
	private int salary;



	public Employee(String name, String companyPosition, int salary) {
		this.name = name;
		this.companyPosition = companyPosition;
		this.salary = salary;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCompanyPosition() {
		return companyPosition;
	}


	public void setCompanyPosition(String companyPosition) {
		this.companyPosition = companyPosition;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	


	public int getEmployeeID() {
		return employeeID;
	}


	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}


	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", name=" + name + ", companyPosition=" + companyPosition
				+ ", salary=" + salary + "]";
	}


	

}
