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
import model.SaleOrderLine;

public class SaleOrderController {
	private ProductController pCtrl;
	private CustomerController cCtrl;
	private EmployeeController eCtrl;
	private SaleOrderDAO saleOrderDB;
	private SaleOrder currentSaleOrder;
	
	public SaleOrderController() throws Exception {
		pCtrl = new ProductController();
		cCtrl = new CustomerController();
		eCtrl = new EmployeeController();
		saleOrderDB = new SaleOrderDB();
	}
	
	public SaleOrder registerOrder(int employeeID, String customerPhone) throws Exception {
		SaleOrder res = null;
		Employee e = eCtrl.findEmployeeByID(employeeID);
		Customer c = cCtrl.findCustomerByPhone(customerPhone);
		currentSaleOrder = new SaleOrder(e, c);
		return currentSaleOrder;
	}
	
	public boolean addProduct(int productID, int quantity) throws Exception {
		boolean res = false;
		Product p = pCtrl.findProductByID(productID);
		if(p != null) {
			currentSaleOrder.addSaleOrderLine(new SaleOrderLine(p, quantity));
			res = true;
		}
		return res;
	}
	
	public boolean completeOrder() {
		boolean res = false;
		currentSaleOrder.setDate(LocalDate.now());
		currentSaleOrder.setDeliveryDate(LocalDate.now().plusMonths(1));
		currentSaleOrder.setDeliveryStatus(DeliveryStatus.ONGOING);
		currentSaleOrder.setAmount(currentSaleOrder.calculateTotal());
		if(currentSaleOrder.getCustomer() instanceof Customer) {
			currentSaleOrder.setFreight(45d);
		} else {
			currentSaleOrder.setFreight(0d);
		}
		currentSaleOrder = null;
		res = true;
		return res;
	}
	
	public List<SaleOrder> findAllSaleOrders() throws Exception {
		return saleOrderDB.findAllSaleOrders();
	}
	
	public SaleOrder findSaleOrderByID(int id) throws Exception {
		SaleOrder res = null;
		res = saleOrderDB.findSaleOrderByID(id);
		return res;
	}
	
	//public void updateSaleOrder(LocalDate date, double amount, DeliveryStatus deliveryStatus, LocalDate deliveryDate, double freight) {
	//	SaleOrder so = new SaleOrder(date, amount, deliveryStatus, deliveryDate, freight);
	//	saleOrderDB.updateSaleOrder(so);
	//}
}
