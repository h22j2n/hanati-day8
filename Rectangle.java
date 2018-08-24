/**
 * 직사각형의 속성과 기능 정의
 * @author 조희진
 *
 */
public class Rectangle extends Shape {

	private double width, height;

	public Rectangle() {
		this(0.0, 0.0, 0.0, 0.0);
	}

	public Rectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println(x + "," + y + "," + width + "," + height + "인 직사각형입니다.");
	}

	@Override
	public double getLength() {
		return 2 * (width + height);
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
