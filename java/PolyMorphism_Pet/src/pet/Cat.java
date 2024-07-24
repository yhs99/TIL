package pet;

import hsy.Pet;

public class Cat extends Pet {
	
	public Cat() {
		super();
	}

	public Cat(String name, String type, int age) {
		super(name, type, age);
	}

	@Override
	public void doCry() {
		System.out.println("야옹");
	}

	@Override
	public String toString() {
		return "[Cat] " + super.toString();
	}
}
