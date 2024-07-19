package webyhs;

public class MobilePhone {
	String brand;
	String model;
	int memory;
	String color;

	public MobilePhone() {
		System.out.println("핸드폰이 개통되었습니다.");
	};
	
	// 생성자 오버로딩
	public MobilePhone(String brand, String model, int memory, String color) {
		this(); // 생성자에서 다른 생성자를 호출할때 가장 첫번째로 와야한다.
		this.brand = brand;
		this.model = model;
		this.memory = memory;
		this.color = color;
	}
	public MobilePhone(String brand, String model) {
		this(brand, model, 256, "검정색");
	}
	public MobilePhone(String brand, int memory) {
		this(brand, null, memory, null);
	}
	
	public String toString() {
		return "[" + this.getClass().getName() + " : " + this.hashCode() + "] = brand : " + brand + ", model : " + model + ", memory : " + memory + ", color : " + color ;
	}
}
