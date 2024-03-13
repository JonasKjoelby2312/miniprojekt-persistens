package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.SaleOrderDAO;
import db.SaleOrderDB;
import model.Customer;
import model.DeliveryStatus;
import model.Employee;
import model.Product;
import model.SaleOrder;

public class SaleOrderController {
	private ProductController pCtrl;
	private CustomerController cCtrl;
	private EmployeeController eCtrl;
	private SaleOrderDAO saleOrderDB;
	private SaleOrder currentSaleOrder;
	
	public SaleOrderController() {
		pCtrl = new ProductController();
		cCtrl = new CustomerController();
		eCtrl = new EmployeeController();
		saleOrderDB = new SaleOrderDB();
	}
	
	public SaleOrder registerOrder(int employeeID, String customerPhone) {
		SaleOrder res = null;
		Employee e = eCtrl.findEmployeeByID(employeeID);
		Customer c = cCtrl.findCustomerByPhone(customerPhone);
		currentSaleOrder = new SaleOrder(e, c);
		return currentSaleOrder;
	}
	
	public boolean addProduct(int productID, int quantity) {
		boolean res = false;
		Product p = pCtrl.findProductByID(productID);
		currentSaleOrder.addSaleOrderLine(new SaleOrderLine(p, quantity));
		return res;
	}
	
	public boolean completeOrder() {
		
	}
	
	public List<SaleOrder> findAllSaleOrders() {
		return saleOrderDB.findAllSaleOrders();;
	}
	
	public SaleOrder findSaleOrderByID(int id) {
		SaleOrder res = null;
		res = saleOrderDB.findSaleOrderByID(id);
		return res;
	}
	
	public void updateSaleOrder(LocalDate date, double amount, DeliveryStatus deliveryStatus, LocalDate deliveryDate, double freight) {
		SaleOrder so = new SaleOrder(date, amount, deliveryStatus, deliveryDate, freight);
		saleOrderDB.updateSaleOrder(so);
	}
}
