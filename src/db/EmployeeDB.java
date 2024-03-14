package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDB implements EmployeeDAO {
	
	private static final String FIND_ALL_Q = "select employee_id, name, company_position, salary from employee";
	private static final String FIND_BY_ID_Q = FIND_ALL_Q + " where employee_id = ?";
	private static final String UPDATE_Q = "update employee set name = ?, company_position = ?, salary = ? where employee_id = ?";
	private PreparedStatement findAllPS;
	private PreparedStatement findByIdPS;
	private PreparedStatement updatePS;
	
	public EmployeeDB() throws Exception {

		Connection con = DBConnection.getInstance().getConnection();
		try {
			findAllPS = con.prepareStatement(FIND_ALL_Q);
			findByIdPS = con.prepareStatement(FIND_BY_ID_Q);
			updatePS = con.prepareStatement(UPDATE_Q);
		} catch (SQLException e) {
			throw new Exception("Could not prepare qurey", e);
		}


	}

	@Override
	public List<Employee> findAllEmployees() throws Exception {
		ResultSet rs;
		try {
			rs = findAllPS.executeQuery();
			List<Employee> res = buildObjects(rs, false);
			return res;
		} catch(SQLException e) {
			throw new Exception("Could not retrive all employees", e);
		}
		
	}

	@Override
	public Employee findEmployeeByID(int id) throws Exception {
		Employee res = null;
		ResultSet rs;
		try {
			rs = findByIdPS.executeQuery();
			if(rs.next()) {
				res = buildObject(rs, false);
			}
		} catch(SQLException e) {
			throw new Exception("Could not find employee by ID", e);
		}
		return res;
	}


//	@Override
//	public void updateEmployee(Employee emp) throws Exception {
//		final String name = emp.getName();
//		final String companyPosition = emp.getCompanyPosition();
//		final int salary = emp.getSalary();
//		try {
//			updatePS.setString(1, companyPosition);
//			updatePS.setString(2, companyPosition);
//			updatePS.setInt(3, salary);
//		} catch(SQLException e) {
//			throw new Exception("Could not update employee on: " + emp, e );
//			
//		}
//	}
	
	private Employee buildObject(ResultSet rs, boolean fullAssociation) throws SQLException {
		Employee e = new Employee(
				rs.getString("name"),
				rs.getString("company_position"),
				rs.getInt("salary"));
		return e;
	}
	
	
	private List<Employee> buildObjects(ResultSet rs, boolean fullAssociation) throws SQLException {
		List<Employee> res = new ArrayList<>();
		while(rs.next()) {
			res.add(buildObject(rs, false));
		}
		return res;
	}
}
		
