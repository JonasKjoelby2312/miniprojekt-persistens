package controller;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.InvoiceDAO;
import db.InvoiceDB;
import db.SaleOrderDAO;
import db.SaleOrderDB;
import db.SaleOrderLineDAO;
import db.SaleOrderLineDB;
import model.Club;
import model.Customer;
import model.DeliveryStatus;
import model.Employee;
import model.Invoice;
import model.Product;
import model.SaleOrder;
import model.SaleOrderLine;

public class SaleOrderController {
	//Instancevariables of the class SaleOrderController
	private ProductController pCtrl;
	private CustomerController cCtrl;
	private EmployeeController eCtrl;
	private SaleOrderDAO saleOrderDB;
	private SaleOrderLineDAO saleOrderLineDB;
	private InvoiceDAO invoiceDB;
	private SaleOrder currentSaleOrder;
	
	//Contructor of SaleOrderController, assigning values to instancevariables
	public SaleOrderController() throws Exception {
		pCtrl = new ProductController();
		cCtrl = new CustomerController();
		eCtrl = new EmployeeController();
		saleOrderDB = new SaleOrderDB();
		saleOrderLineDB = new SaleOrderLineDB();
		invoiceDB = new InvoiceDB();
	}
	
	//This method creates a new SaleOrder object with ID's from an employee and costumer, and saves it in an instancevariable
	public SaleOrder registerOrder(int employeeID, int customerID) throws Exception {
		SaleOrder res = null;
		Employee e = eCtrl.findEmployeeByID(employeeID);
		Customer c = cCtrl.findCustomerByID(customerID);
		
		if(e != null & c != null) {
			currentSaleOrder = new SaleOrder(e, c);
		}
		return currentSaleOrder;
	}
	
	//This method adds a SaleOrderLine to the currentSaleOrder variable, it can be called multiple times.
	public boolean addProduct(int productID, int quantity) throws Exception {
		boolean res = false;
		Product p = pCtrl.findProductByID(productID);
		if(currentSaleOrder != null && quantity > 0 && p != null) {
			currentSaleOrder.addSaleOrderLine(new SaleOrderLine(p, quantity));
			res = true;
		}
		return res;
	}
	
	//This method finalizes the sale by assigning values to remaining variables on currentSaleOrder
	public boolean completeSaleOrder() throws Exception {
		boolean res = false;
		if(currentSaleOrder != null && currentSaleOrder.getSaleOrderLines().size() > 0) {
			currentSaleOrder.setDate(LocalDate.now());
			currentSaleOrder.setDeliveryDate(LocalDate.now().plusMonths(1));
			currentSaleOrder.setDeliveryStatus(DeliveryStatus.ONGOING);
			currentSaleOrder.setAmount(currentSaleOrder.calculateTotal());
			if(currentSaleOrder.getCustomer() instanceof Club || currentSaleOrder.getAmount() > 2500d) {
				currentSaleOrder.setFreight(0d);
			} else {
				currentSaleOrder.setFreight(45d);
			}
			currentSaleOrder.addInvoice(new Invoice(currentSaleOrder.getCustomer().getCustomerID() + (int) Instant.now().getEpochSecond(), 
					LocalDate.now(), currentSaleOrder.getAmount() + currentSaleOrder.getFreight()));
			saleOrderDB.insertSaleOrder(currentSaleOrder);
			saleOrderLineDB.insertSaleOrderLines(currentSaleOrder);
			invoiceDB.insertInvoice(currentSaleOrder);
			
			currentSaleOrder = null;
			res = true;
		}
		return res;
	}
	
	//This method calls upon another method of the same name, on the saleOrderDB class. It returns a List of all SaleOrderObjects
	public List<SaleOrder> findAllSaleOrders() throws Exception {
		return saleOrderDB.findAllSaleOrders();
	}
	
	//This method calls upon another method of the same name, on the saleOrderDB class. It returns a single SaleOrderObject matching the id of the input parameter
	public SaleOrder findSaleOrderByID(int id) throws Exception {
		SaleOrder res = null;
		if(id > 0) {
			res = saleOrderDB.findSaleOrderByID(id);
		}
		return res;
	}
}
