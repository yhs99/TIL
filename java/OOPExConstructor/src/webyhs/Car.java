package webyhs;

public class Car {
	//멤버변수
	String brand = "현대";
	String model = "그랜저";
	int price = 45000000;
	String color = "검정";
	
	// 멤버 메서드
	public Car() {
		
	};
	
	public Car(String brand, String model, int price, String color) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.color = color;
	}
	
	void createCar(String brand, String model, int price, String color) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.color = color;
	}
	
	public void displayCar() {
		System.out.printf("브랜드명: %s, 모델명 : %s, 가격: %d, 색상 : %s \n", brand, model, price, color);
	}
}
