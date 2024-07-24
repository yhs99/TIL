package hsy;

public abstract class Pet {
	private String name;
	private String type;
	private int age;
	
	protected Pet() {
		
	}
	
	protected Pet(String name, String type, int age) {
		this.name = name;
		this.type = type;
		this.age = age;
	}
	
	public void doWalk() {
		System.out.println("걷는중");
	}
	// 추상메서드
	public abstract void doCry();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", type=" + type + ", age=" + age + "]";
	}
	
	
}
