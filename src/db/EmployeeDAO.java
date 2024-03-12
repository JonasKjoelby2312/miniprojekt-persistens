package db;

import java.util.List;

import model.Employee;

public interface EmployeeDAO {

	List<Employee> findAll() throws Exception;
	Employee findById(int id, boolean fullAssociation) throws Exception;
	void update(Employee e) throws Exception;

}
