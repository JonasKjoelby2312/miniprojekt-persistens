package controller;

import java.util.List;

import db.ProductDAO;
import db.ProductDB;
import model.Product;

public class ProductController {
	private ProductDAO productDB;
	
	public ProductController() throws Exception {
		productDB = new ProductDB();
	}
	
	public List<Product> findAllProducts() throws Exception {
		return productDB.findAllProducts();
	}
	
	public Product findProductByID(int id) throws Exception {
		return productDB.findProductByID(id, false);
	}
}
