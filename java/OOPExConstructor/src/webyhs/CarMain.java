package webyhs;

public class CarMain {

	public static void main(String[] args) {
		// Car 객체 생성
		Car car1 = new Car();
		car1.displayCar();
		
		Car car2 = new Car();
		car2.createCar("기아", "K5", 25000000, "흰색");
		car2.displayCar();
		
		Car car3 = new Car("제네시스", "GV70", 70000000, "회색");
		car3.displayCar();
	}

}
