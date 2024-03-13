package controller;

import db.EmployeeDAO;

public class EmployeeController {
	
	private EmployeeDAO employeeDB;
	
	public EmployeeController() {
		this.employeeDB = new EmployeeDB();
	}

}
