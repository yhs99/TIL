package webhsy.inheritance.basic1;

public class CarMain {

	public static void main(String[] args) {
		Car car = new Car();
		car.startEngine();
		car.accelerate();
		
		GasCar gasCar = new GasCar();
		gasCar.fillUp();
		gasCar.startEngine();
		gasCar.accelerate();
		
		ElectricCar eleCar = new ElectricCar();
		eleCar.charge();
		eleCar.startEngine();
		eleCar.accelerate();
		eleCar.stopEngine();
		
		FireEngine fireEngine = new FireEngine();
		fireEngine.hoseWater();
		
		HybridCar hybrid = new HybridCar();
		hybrid.startEngine();
		hybrid.chargeOnBreak();
		hybrid.fillUp();
		hybrid.stopEngine();
	}

}
