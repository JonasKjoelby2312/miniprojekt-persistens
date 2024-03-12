package model;

public class Employee {

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


	@Override
	public String toString() {
		return "Employee [name=" + name + ", companyPosition=" + companyPosition + ", salary=" + salary + "]";
	}

}
