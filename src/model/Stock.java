package model;

public class Stock {
	
	private int stockID;
	private int minStock;
	private int maxStock;
	private int currentStock;
	

	public Stock(int minStock, int maxStock, int currentStock) {
		this.maxStock = maxStock;
		this.minStock = minStock;
		this.currentStock = currentStock;
		
	}

	public int getMinStock() {
		return minStock;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	public int getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}
	

	public int getCurrentStock() {
		return currentStock;
	}

	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}
	
	

	public int getStockID() {
		return stockID;
	}

	public void setStockID(int stockID) {
		this.stockID = stockID;
	}

	@Override
	public String toString() {
		return "Stock [stockID=" + stockID + ", minStock=" + minStock + ", maxStock=" + maxStock + ", currentStock="
				+ currentStock + "]";
	}

	

	
	
}
