package db;

import java.util.List;

import model.Product;

public interface ProductDAO {
	List<Product> findAll() throws Exception;
	Product findById(int id, boolean fullAssociation) throws Exception;
	void updateEmployee(Product p) throws Exception;

}
