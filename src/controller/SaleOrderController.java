package controller;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.SaleOrderDAO;
import db.SaleOrderDB;
import db.SaleOrderLineDAO;
import db.SaleOrderLineDB;
import model.Customer;
import model.DeliveryStatus;
import model.Employee;
import model.Invoice;
import model.Product;
import model.SaleOrder;
import model.SaleOrderLine;

public class SaleOrderController {
	private ProductController pCtrl;
	private CustomerController cCtrl;
	private EmployeeController eCtrl;
	private SaleOrderDAO saleOrderDB;
	private SaleOrderLineDAO saleOrderLineDB;
	private SaleOrder currentSaleOrder;
	
	public SaleOrderController() throws Exception {
		pCtrl = new ProductController();
		cCtrl = new CustomerController();
		eCtrl = new EmployeeController();
		saleOrderDB = new SaleOrderDB();
		saleOrderLineDB = new SaleOrderLineDB();
	}
	
	public SaleOrder registerOrder(int employeeID, int customerID) throws Exception {
		SaleOrder res = null;
		Employee e = eCtrl.findEmployeeByID(employeeID);
		Customer c = cCtrl.findCustomerByID(customerID);
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
	
	public boolean completeSaleOrder() throws Exception {
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
		currentSaleOrder.addInvoice(new Invoice(currentSaleOrder.getCustomer().getCustomerID() + (int) Instant.now().getEpochSecond(), 
				LocalDate.now(), currentSaleOrder.getAmount() + currentSaleOrder.getFreight()));
		saleOrderDB.insertSaleOrder(currentSaleOrder);
		//saleOrderLineDB.insertSaleOrderLines(currentSaleOrder.getSaleOrderLines());
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
