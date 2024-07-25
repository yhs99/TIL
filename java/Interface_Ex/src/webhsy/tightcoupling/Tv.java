package webhsy.tightcoupling;

public class Tv {
	
	private String brandName;
	
	Tv(String brandName) {
		this.brandName = brandName;
	}
	
	public void powerOn() {
		System.out.println(brandName + " TV ON");
	}
	
}
