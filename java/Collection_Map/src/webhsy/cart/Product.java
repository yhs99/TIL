package webhsy.cart;

public class Product {
	private String productName;
	private int price;
	
	public Product(String productName, int price) {
		this.productName = productName;
		this.price = price;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public int hashCode() {
		String str = productName + price;
		return str.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Product) {
			Product a = (Product) obj;
			return (this.productName.equals(a.productName) && this.price == a.price);
		}
		return false;
	}
}
