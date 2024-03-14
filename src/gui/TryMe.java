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
			
			CustomerController cc = new CustomerController();
			
			System.out.println(cc.findCustomerByID(1));
			
			
			/*
			 * SaleOrderController soc = new SaleOrderController(); EmployeeController ec =
			 * new EmployeeController(); CustomerController cc = new CustomerController();
			 * cc.findCustomerByID(1); ec.findEmployeeByID(1); soc.registerOrder(2, 2);
			 * soc.addProduct(1, 2); soc.completeSaleOrder();
			 */
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
