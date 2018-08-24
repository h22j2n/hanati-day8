
/**
 * 원의 속성과 기능 정의
 * 
 * @author 조희진
 *
 */

public class Circle extends Shape {

	private double radian;

	public Circle() {
		this(0.0, 0.0, 0.0);
	}

	public Circle(double x, double y, double radian) {
		this.x = x;
		this.y = y;
		this.radian = radian;
	}

	public double getRadian() {
		return radian;
	}

	public void setRadian(double radian) {
		this.radian = radian;
	}

	@Override
	public void draw() {
		System.out.println(x + "," + y + "," + getRadian() + "의 원 입니다.");
	}

	@Override
	public double getLength() {
		return 2 * Math.PI * radian;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(radian, 2);
	}

	@Override
	public String toString() {
		return "Circle [radian=" + radian + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	


}
