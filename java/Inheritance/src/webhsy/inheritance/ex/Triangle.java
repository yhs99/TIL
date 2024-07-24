package webhsy.inheritance.ex;

public class Triangle extends Shapes{
	public int height;
	public int bottom;
	
	public Triangle(String name, String color,Point p , int height, int bottom) {
		super(name, color, p);
		this.height = height;
		this.bottom = bottom;
	}
	
	@Override
	public void drawShape() {
		System.out.println(toString() + "인 삼각형을 그립니다.");
	}

	@Override
	public String toString() {
		return super.toString() + "Triangle [height=" + height + ", bottom=" + bottom + "]";
	}
	
	
}
