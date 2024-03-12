package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import model.Employee;

public class EmployeeDB implements EmployeeDAO {
	
	private static final String FIND_ALL_Q = "select name, company_position, salary from employee";
	private static final String FIND_BY_ID_Q = FIND_ALL_Q + " where id = ?";
	private PreparedStatement findAllPS;
	private PreparedStatement findByIdPS;
	
	public EmployeeDB() throws Exception {
		Connection con = new Conncetion();
		findAllPS = con.prepareStatement(FIND_ALL_Q);
		findByIdPS = con.prepareStatement(FIND_ALL_Q);
	}

	@Override
	public List<Employee> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findById(int id, boolean fullAssociation) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(Employee e) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
