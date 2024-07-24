package webhsy.inheritance.ex;

public abstract class Shapes {
	private String name;
	private String color;
	private Point point;
	
	public Shapes(String name, String color, Point p) {
		this.name = name;
		this.color = color;
		this.point = p;
	}
	
	public abstract void drawShape();

	@Override
	public String toString() {
		return "Shapes [name=" + name + ", color=" + color + ", point=" + point + "]";
	}
}
