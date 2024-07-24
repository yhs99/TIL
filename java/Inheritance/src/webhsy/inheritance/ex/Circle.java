package webhsy.inheritance.ex;

public class Circle extends Shapes {
	private int radius;

	public Circle(String name, String color,Point p, int radius) {
		super(name, color, p);
		this.radius = radius;
	}
	
	@Override
	public void drawShape() {
		System.out.println(toString() + "인 원이 그려집니다.");
	}

	@Override
	public String toString() {
		return super.toString() + "Circle [radius=" + radius + "]";
	}
}
