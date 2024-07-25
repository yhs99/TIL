package webhsy.loosecoupling;

public class Tv implements ElectronicDevice{
	
	private String brandName;
	
	public Tv(String brandName) {
		this.brandName = brandName;
	}
	
	@Override
	public void powerOn() {
		System.out.println(brandName + " TV on");
	}

}
