package webhsy.inheritance.ex;

public class Rectangle extends Shapes{
	private int width;
	private int height;
	
	public Rectangle(String name, String color, Point p, int width, int height) {
		super(name, color, p);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void drawShape() {
		System.out.println(toString() + "인 사각형이 그려집니다.");
	}

	@Override
	public String toString() {
		return super.toString() + "Rectangle [width=" + width + ", height=" + height + "]";
	}
}
