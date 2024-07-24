package webhsy.inheritance.super1;

class Parent {
	int a = 10;
	Parent() {
		System.out.println(a);
		System.out.println("부모호출");
	}
}

class Child extends Parent {
	int a = 20;
	Child() {
		super.a = 11;
		System.out.println("자식 a : " + a);
		System.out.println("부모 a : " + super.a);
	}
}

public class SuperEx1Main {
	public static void main(String[] args) {
		Child child = new Child();
	}
}
