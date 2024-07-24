package webhsy.inheritance.super2;

class Parent {
	Parent() {
		System.out.println("부모 생성");
	}
	Parent(int a) {
		System.out.println("부모 생성 a : " + a);
	}

}
class Child extends Parent {
	
	Child(int a) {
		System.out.println("자식 생성 a : " + a);
	}
	Child(int a, int b) {
		System.out.println("a : " + a + " b : " + b);
	}
}

class GrandChild extends Child {
	GrandChild() {
		super(10);
		System.out.println("손자 생성");
	}
}

public class SuperConstruncMain {
	public static void main(String[] args) {
		GrandChild gC = new GrandChild();

	}
}
