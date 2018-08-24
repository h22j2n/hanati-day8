
public class ShapeApp {

	public static void main(String[] args) {
//		Shape shape = new Shape(12.5, 35.7);
		Shape shape = null;
		shape.draw();

		Circle circle = new Circle(15.0, 15.0, 30);
		circle.draw();
		System.out.println("원의 둘레 : " + circle.getLength());
		System.out.println("원의 넓이 : " + circle.getArea());

		Rectangle rectangle = new Rectangle(14.0, 13.0, 12.0, 15.0);
		rectangle.draw();
		System.out.println("사각형의 둘레 : " + rectangle.getLength());
		System.out.println("사각형의 넓이 : " + rectangle.getArea());
		
		System.out.println(shape); // object에 있는 toString을 자동호출한 것
		System.out.println(shape.toString());

		String str = "Java Programming";
		System.out.println(str); //얘도 자동호출 됐는데 주소값이 안나옴(오버라이딩 된 것)
		
		System.out.println(circle);
	}

}
