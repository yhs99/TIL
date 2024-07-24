package webhsy.inheritance.ex;

public class ShapeMain {

	public static void main(String[] args) {
		Circle circle = new Circle("원", "검정",new Point(10,20), 50);
		Rectangle rec = new Rectangle("사각", "빨강", new Point(30, 30), 30, 50);
		Triangle triangle = new Triangle("삼각", "파랑", new Point(50, 50), 30, 50);
		rec.drawShape();
		triangle.drawShape();
		circle.drawShape();
	}

}
