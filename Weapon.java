/**
 * 무기에 대한 수평적 규격 역할의 인터페이스
 * @author 조희진
 *
 */

// 컴파일 시 자동으로 추가되는 것 : default 생성자 / extends object /super / interface의 method의 public 
public interface Weapon {
	
	int WEIGHT = 10;
	//public static final 이 앞에 자동으로 붙어서 상수처리 됨
	
	public void attack();
	//public void 생략가능

}
