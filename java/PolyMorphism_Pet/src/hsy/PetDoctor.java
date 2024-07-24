package hsy;

import pet.Cat;
import pet.Dog;

public class PetDoctor {
	private String name;
	private int age;
	
	protected PetDoctor(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void doClinic(Pet pet) {
		if(pet instanceof Cat) {
			System.out.println(this.toString() + "가 " + pet + "을 케어합니다.");
		}else if(pet instanceof Dog) {
			System.out.println(pet + "을 케어합니다.");
		}
	}

	@Override
	public String toString() {
		return "PetDoctor [name=" + name + ", age=" + age + "]";
	}
	
}
