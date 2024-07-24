package webhsy.polymorph.instof;

class ParentA {
	public void a(Child d) {
		Child c = ((Child) d);
		((Child) c).get();
		c.get();
	}
}

class Child extends ParentA {
	void get() {
		System.out.println("get");
	}
	
}

public class InstanceOfMain {
	public static void main(String[] args) {
		ParentA parentA = new ParentA();
		Child child = new Child();
		// ~가 ~의 인스턴스인가?
		// ParentA ref = new ParentA();
		System.out.println("parentA instanceof ParentA : " + (parentA instanceof ParentA)); // true
		// ParentA ref = new Child();
		System.out.println("child instanceof ParentA : " + (child instanceof ParentA)); // true
		// Child ref = new ParentA();
		System.out.println("parentA instanceof Child : " + (parentA instanceof Child)); // false
		// Child ref = new Child();
		System.out.println("child instanceof Child : " + (child instanceof Child)); // true
		
	}
}
