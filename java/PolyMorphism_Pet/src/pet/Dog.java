package pet;

import hsy.Pet;

public class Dog extends Pet {

	public Dog(String name, String type, int age) {
		super(name, type, age);
	}
	
	public void doWag() {
		System.out.println(super.getName()+"가 꼬리를 흔드는 중");
	}

	@Override
	public void doCry() {
		System.out.println("멍멍");
	}
	
	@Override
	public String toString() {
		return "[Dog] " + super.toString();
	}

}
