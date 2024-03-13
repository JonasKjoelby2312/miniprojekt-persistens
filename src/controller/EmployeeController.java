	package controller;

	import db.EmployeeDAO;
	import db.EmployeeDB;
	import model.Employee;
	import java.util.List;


	public class EmployeeController {
		private EmployeeDAO employeeDB;
		
		public EmployeeController() throws Exception {
			employeeDB = new EmployeeDB();
		}
		
		public List<Employee> findAllEmployees() throws Exception {
			return employeeDB.findAllEmployees();
		}

		public Employee findEmployeeByID(int id) throws Exception {
			return employeeDB.findEmployeeByID(id);
		}
		
//		public void updateEmployee(Employee e) throws Exception {
//			employeeDB.updateEmployee(e);
//		}
	}


