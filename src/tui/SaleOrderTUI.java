package tui;

import java.util.Scanner;

import controller.SaleOrderController;
import model.SaleOrder;

public class SaleOrderTUI {
	private SaleOrderController soc;
	
	public SaleOrderTUI() throws Exception {
		soc = new SaleOrderController();
	}
	
	public static void main(String[] args) throws Exception {
		SaleOrderTUI sot = new SaleOrderTUI();
		sot.start();
	}

	private void start() throws Exception {
		boolean exit = false;
		Scanner scanner = new Scanner(System.in);
		while(!exit) {
			int choice = writeSaleOrderMenu(scanner);
			switch(choice) {
				case 1:
					System.out.println("	Type Employee's ID:		");
					int eID = getUserInteger(scanner);
					
					System.out.println("	Type Customer's ID:		");
					int cID = getUserInteger(scanner);
					
					SaleOrder currSaleOrder = soc.registerOrder(eID, cID);
					if(currSaleOrder != null) {
						System.out.println("	Sale Order Successfully Started!");
						System.out.println("	Registered Employee Is: " + currSaleOrder.getEmployee().getName() +
								"	Registered Customer Is: " + currSaleOrder.getCustomer().getName());
						System.out.println();
					} else {
						System.out.println("	Error: Sale Order Not Created!");
						System.out.println();
					}
					break;
					
				case 2:
					System.out.println("	Type Product's ID:		");
					int pID = getUserInteger(scanner);
					
					System.out.println("	Type Quantity of Product:		");
					int pQ = getUserInteger(scanner);
					
					boolean result = soc.addProduct(pID, pQ);
					if(result) {
						System.out.println("	Product Added Successfully!");
						System.out.println();
					} else {
						System.out.println("	Error: Product Not Added!");
						System.out.println("	Try Checking Product ID and Quantity For Any Odd Numbers, Or Try Registering a New Sale Order.");
						System.out.println();
					}
					break;
					
				case 3:
					boolean fResult = soc.completeSaleOrder();
					if(fResult) {
						System.out.println("	Sale Order Successfully Saved!");
						System.out.println();
					} else {
						System.out.println("	Error: Sale Order Could Not Be Saved!");
						System.out.println();
					}
					break;
					
				case 4:
					System.out.println("	Type ID Of Sale Order To Print:		");
					int soID = getUserInteger(scanner);
					SaleOrder saleOrderToPrint = soc.findSaleOrderByID(soID);
					if(saleOrderToPrint != null) {
						printSaleOrder(saleOrderToPrint);
					} else {
						System.out.println("	Error: No Sale Order Found. Try Another ID");
						System.out.println();
					}
					break;
					
				case 0:
					System.out.println("	Goodbye.");
					scanner.close();
					exit = true;
					break;
			}
		}
	}

	private void printSaleOrder(SaleOrder saleOrderToPrint) {
		System.out.println("------Sale Order------");
		System.out.println("	SaleOrderID: " + saleOrderToPrint.getSaleOrderID());
		System.out.println("	Date Of Sale Order: " + saleOrderToPrint.getDate());
		System.out.println("	Delivery Status: " + saleOrderToPrint.getDeliveryStatus());
		System.out.println("	Estimated Delivery Date: " + saleOrderToPrint.getDeliveryDate());
		System.out.println("	Freight Cost: " + saleOrderToPrint.getFreight());
		System.out.println("	Total Amount: " + saleOrderToPrint.getAmount());
		System.out.println("	Sale Order Made By: " + saleOrderToPrint.getEmployee().getName());
		System.out.println();
	}

	private int writeSaleOrderMenu(Scanner scanner) {
		System.out.println("------Sale Order Menu------");
		System.out.println("	1) Register New Sale Order");
		System.out.println("	2) Add Product to Sale Order");
		System.out.println("	3) Finalize Sale Order");
		System.out.println("	4) Print Sale Order");
		System.out.println("	0) Exit");
		System.out.println();
		return getUserInteger(scanner);
	}

	private int getUserInteger(Scanner scanner) {
		while(!scanner.hasNextInt()) {
			System.out.println("	Input Has To Be A Number!");
			System.out.println();
			scanner.nextLine();
		}
		return scanner.nextInt();
	}
}
