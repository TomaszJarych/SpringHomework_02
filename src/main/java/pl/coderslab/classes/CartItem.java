package pl.coderslab.classes;


public class CartItem {
	private  int quantity;
	private final Product product;

	public CartItem(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
