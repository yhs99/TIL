package webhsy.inheritance.basic1;

public class GasCar extends Car{
	
	@Override
	public void startEngine() {
		super.startEngine();
	}
	
	@Override
	public void accelerate() {
		super.accelerate();
	}
	
	public void fillUp() {
		System.out.println("주유중");
	}
}
