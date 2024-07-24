package hsy;

import pet.Cat;
import pet.Dog;

public class PetMain {

	public static void main(String[] args) {
		Dog dog = new Dog("강아지", "치와와", 3);
		Cat cat = new Cat("고양이", "아메리칸 쇼트헤어", 5);
		PetDoctor doctor = new PetDoctor("ㅇㅇ", 25);
		dog.doWag();
		cat.doWalk();
		System.out.println(dog.toString());
		System.out.println(cat.toString());
		doctor.doClinic(dog);
		doctor.doClinic(cat);
	}

}
