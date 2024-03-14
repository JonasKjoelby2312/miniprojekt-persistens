package db;

import java.util.List;

import model.Product;

public interface ProductDAO {
	List<Product> findAllProducts() throws Exception;
	Product findProductByID(int id, boolean fullAssociation) throws Exception;
}
