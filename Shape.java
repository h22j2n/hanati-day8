
/**
 * 모든 도형의 공통적인 속성과 기능 정의한 추상클래스
 * 
 * @author 조희진
 *
 */
public abstract class Shape {

	protected double x, y;

	// 추상메소드
	// 서브클래스가 반드시 구현(재정의)해야 할 수직적 규약
	public abstract void draw();
	public abstract double getLength();
	public abstract double getArea();
	
	
}
