
public class Foo {

	public void someMethod() {
//		String message = null;
//		System.out.println(message.length()); 
		// Exception 발생 new NullpointException 생성됨 쟤도 클래스라서 화면에 출력되는 것

//		System.out.println(10/0);
		// new ArithmeticException

		int[] array = { 1, 2, 3 };
		System.out.println(array[3]);
		// ArrayIndexOutOfBoundsException
	}

	public void someMethod2() {
		try {
			String message = null;
//			System.out.println(message.length()); 
			// Exception 발생 new NullpointException 생성됨 쟤도 클래스라서 화면에 출력되는 것
			
//			System.out.println(10/0);
			// new ArithmeticException
			
			int[] array = {1,2,3};
			System.out.println(array[3]);
			//ArrayIndexOutOfBoundsException
		
		}catch(NullPointerException e) {
//			System.out.println("인스턴스 생성 안됐다.");
			System.out.println(e.getMessage());
			e.printStackTrace(); // call stack 에 있는 것 출력
		}catch(ArithmeticException e) {
//			System.out.println("인스턴스 생성 안됐다.");
			System.out.println(e.getMessage());
			e.printStackTrace(); // call stack 에 있는 것 출력
		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("인스턴스 생성 안됐다.");
			System.out.println(e.getMessage());
			e.printStackTrace(); // call stack 에 있는 것 출력
		}catch(Exception e) {
//			System.out.println("인스턴스 생성 안됐다.");
			System.out.println(e.getMessage());
			e.printStackTrace(); // call stack 에 있는 것 출력
		}finally {
			System.out.println("예외 발생 여부와 상관없이 항상 실행 코드");
		}
		
	}
	
	public void someMethod3() throws NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException{
		String message = null;
		System.out.println(message.length()); 
		System.out.println(10/0);
		int[] array = { 1, 2, 3 };
		System.out.println(array[3]);
	}

	public static void main(String[] args) {
		System.out.println("JVM에 의해 프로그램 시작됨");
		Foo foo = new Foo();
		
		try {
			foo.someMethod3();
		}catch(Exception e){
			System.out.println("메인에서 모든 예외처리 완료");
		}

		System.out.println("프로그램 종료됨");

	}

}
