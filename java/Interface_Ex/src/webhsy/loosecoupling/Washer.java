package webhsy.loosecoupling;

public class Washer implements ElectronicDevice {

	private String brandName;
	
	public Washer(String brandName) {
		this.brandName = brandName;
	}
	
	@Override
	public void powerOn() {
		System.out.println(brandName + " 세탁기 가동");
	}

}
