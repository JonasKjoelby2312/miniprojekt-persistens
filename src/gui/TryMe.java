package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import controller.CustomerController;
import controller.EmployeeController;
import controller.SaleOrderController;
import model.SaleOrder;

public class TryMe {
	
	
	public static void main(String[] args) throws Exception {
		
		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=persistens;user=sa;password=dockerStrongPwd123;encrypt=false");
			System.out.println("succes");
			
			
			
			  SaleOrderController soc = new SaleOrderController();
			
			  soc.registerOrder(1, 1);
			  soc.addProduct(1, 2); 
			  soc.completeSaleOrder();
			  
			  System.out.println();
			 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
