	package controller;

	import db.EmployeeDAO;
	import db.EmployeeDB;
	import model.Employee;
	import java.util.List;


	public class EmployeeController {
		
		private EmployeeDAO employeeDB;
		
		public EmployeeController() throws Exception {
			this.employeeDB = new EmployeeDB();
			
		}
		
		public List<Employee> findAllEmployees() throws Exception {
			return employeeDB.findAll();
		}

		public Employee findByID(int id) throws Exception {
			return employeeDB.findById(id);
		}
		
		public void updateEmployee(Employee e) throws Exception {
			employeeDB.updateEmployee(e);
		}
	}


