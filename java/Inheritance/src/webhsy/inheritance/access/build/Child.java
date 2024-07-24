package webhsy.inheritance.access.build;

import webhsy.inheritance.access.parent.Parent;

public class Child extends Parent{
	public void displayChild() {
		publicVal = 1;
		protectedVal = 1;
		displayParent();
	}
}
