# 하나금융티아이 20180827

[복습]

- 다형성을 기술적으로 지원하는 것 : 클래스 형변환

  - Up Casting
  - Down Casting (왜 해야하는지 기억하기)

- 추상클래스 : 부모자식간에 어느정도 규칙을 만들고 싶음(확장할건 확장하고 ~ ) / 규격화시키고 싶음(왜? 사용하는 입장에서 일관된 메소드 호출가능) => 수직적 규격 

- 인터페이스 : 스펙에 맞춰서 클래스만들어 놓으면 사용하는 입장에서 일관된 메소드 호출가능/거대한 팀 프로젝트 할 때 (특히 서버쪽)

  - 인터페이스는 추상메소드 뿐 아니라 상수도 가질 수 있음! 

  - UML에서 대문자로 쓰고 밑줄그어져있으면 상수!!!!!!!

  - 인터페이스는 다중구현 가능

  - 상수는 두 단어 조합할때 _ 사용 : MAX_VOLUMN

  - 인터페이스는 추상메소드와 상수의 집합이다.

  - 추가된 메소드는 호출 불가능 => Down Casting 해야 함

    - 추상메소드말고 다른 메소드를 추가하면 그건 Down Casting 해서 사용해야한다.

      ``` java
      	public static void main(String[] args) {
      		RemoteControl tv = new SamsongTV();
      		tv.turnOn();
      		tv.setChannel(10);
      		
      		System.out.println(((SamsongTV) tv).getCurrentChannel());
      
               tv.volumnUp();
      		tv.volumnUp();
      		tv.volumnUp();
      		System.out.println(((SamsongTV) tv).getCurrentVolumn());
      	
               System.out.println(RemoteControl.MAX_CHANNEL);
      		//SamsongTV.MAX_CHANNEL 해도 됨
      		
      		tv.turnOff();		
      	}
      
      /* 출력
      전원을 켭니다.
      10
      3
      전원을 끕니다.
      */
      ```

- Star UML 에 순공학 / 역공학 기능이 있음

  - 순공학(Generate Code) : Star UML에서 만든 클래스와 메소드를 eclipse에 자동으로 ~
  - 역공학 : 반대



## Java5.0 추가기능

- 실용주의!

- ## 확장for문 

  - 단점 : index가 필요할 경우에는 쓸 수 없다

- ## Autoboxing / Unboxing

  - Autoboxing : 자동으로 형변환 하는것

  - Unboxing : 값을 벗겨내는 것 / 객체가 늘어나는 것이 아님 메모리 늘어나는 것 아님

    ![그림1](C:\Users\kosta\Desktop\까마귀\img\그림1.png)

![그림2](C:\Users\kosta\Desktop\까마귀\img\그림2.png)

``` java
public class AutoBoxingExample {
	public static void main(String[] args) {
		//Autoboxing
		Double obj = 78.56;
		System.out.println(obj);
		
		//Unboxing
		double value = new Double(169.45);
		System.out.println(value);
	}
}
```

- ## Static import

  - 클래스의 클래스변수나 클래스메소드를 사용할 때 Static import를 사용해서 코드량을 줄여 사용할 수 있다. 원래는 Math.random(); 으로 호출해야 하는데 그냥 random(); 으로 호출 가능

    ``` java
    import static java.lang.System.out;
    import static java.lang.Math.*;
    public class Test {
    
         public static void main(String[] args) {
              System.out.println("스태틱임포트 사용하지 않을 경우");
              out.println("스태틱임포트 사용");
              random();
         }
    }
    ```

  - 권장하지는 않음(random이 현재 클래스가 제공하는 것인지 헷갈림 => 가독성이 떨어질 수 있음)

- ## Varargs(가변인자)

  - C/C++ 처럼 메소드 인자의 개수가 일정하지 않은 가변길이 인자를 지원한다. 
  - 5.0 이전에는 가변인자가 허용되지 않기 때문에 인자가 여러 개인 메서드를 정의할    경우 배열을 이용하여야 하는 번거로움이 있었다.

  ``` java
  public class VarargsExample {
  	// 5.0 이전 버전
  	public static int sum(int[] args) {
  		int result= 0;
  		for (int i : args) {
  			result += i;
  		}
  		return result;
  	}
      
      // 5.0 이후
  	public static int summ(int... args) {
  		int result = 0;
  		for (int i : args) {
  			result += i;
  		}
  		return result;
  	}    
  	
  	public static void main(String[] args) {
  		
  		int[] values = {10,20};
  		System.out.println(sum(values));
          
          System.out.println(summ(10,20));
  	}
  }
  ```

  

  ``` java
  public class VarargsExample {
       // 가변 인자를 받아 덧셈 처리
       public static int sum(int... arg){
           //arg를 배열이라고 생각하자
            int sum = 0;
            for (int i : arg) {
                 sum += i;
            }
            return sum;		
       }
       
       public static void main(String[] args) {
            System.out.println(sum(55, 40));
            System.out.println(sum(55, 40, 23, 23, 34, 343, 3453, 343, 55));
       }
  }
  ```

- ## Enum(열거형 자료형) : 하나의 데이터 타입

  - 타입에 안전하지 않은 기존의 열거형 문제를 해결하기 위해 5.0 에서 enum 타입을 제공한다.

  - 상수를 대체하기 위해 나옴

  - 상수는 대부분 interface로 만든다. 상관은 없음

    ``` java
    // 5.0 이전 상수를 이용한 기존의 열거형 처리
    
    public class/*interface*/ Direction {
         public static final int NORTH = 0;
         public static final int WEST = 1;
         public static final int EAST = 2;
         public static final int SOUTH = 3;
    }
    
    public class Some {
         public void move(int direction){
         //direction에 들어올 수를 제어하고 싶은데 제어를 못함
         // int형을 받기 때문에 안전하지 않음
              switch (direction) {// 0, 1, 2, 3 이외의 값이 전달된 경우 버그 발생 소지가 있다.
                   case Direction.NORTH: System.out.println("북쪽으로 이동>>>"); break;
                   case Direction.WEST: System.out.println("서쪽으로 이동>>>");    break;
                   case Direction.EAST: System.out.println("동쪽으로 이동>>>");     break;
                   case Direction.SOUTH: System.out.println("남쪽으로 이동>>>");  break;
              }
         }
    }
    ```

    ``` java
    //5.0 이후 타입에 안전한 열거형(enum)
    
    public enum Direction {
        //값을 전달받는 이름만 나열하면 된다.
        //관례적으로 상수처럼 대문자로 씀
         NORTH, WEST, EAST, SOUTH;
    }
    public class Some {
         public void move(Direction direction){
              switch (direction) {// NORTH, WEST, EAST, SOUTH 이외의 값이 전달된 경우 컴파일 에러
                   case NORTH: System.out.println("북쪽으로 이동>>>"); break;
                   case WEST: System.out.println("서쪽으로 이동>>>");    break;
                   case EAST: System.out.println("동쪽으로 이동>>>");     break;
                   case SOUTH: System.out.println("남쪽으로 이동>>>");  break;
              }
         }
    }
    ```

    

    ``` java
    public enum Directions {
    	// 상수목록을 가진 클래스라고 생각하자
    	NORTH, WEST, EAST, SOUTH;
    
    }
    ```

    ``` java
    public class Foo {
    	
    	public void move(Directions directions) {
    		switch (directions) {
    		case EAST:System.out.println("동쪽 이동"); break;
    		case WEST:System.out.println("서쪽 이동"); break;
    		case SOUTH:System.out.println("남쪽 이동"); break;
    		case NORTH:System.out.println("북쪽 이동"); break;
    
    		}
    	}
    	public static void main(String[] args) {
    		Foo foo = new Foo();
    		foo.move(Directions.EAST);
    		foo.move(Directions.WEST);
    		foo.move(Directions.NORTH);
            
    		Directions[] list = Directions.values();
    		for (Directions directions : list) {
    			System.out.println(directions);
                //toString() 이 자동으로 호출됨
                
    		String name = "NORTH";
    		Directions dir = Directions.valueOf(name);
    		// 형변환 시킨것
    		System.out.println(dir);            
            }
    	}
    	
    }
    ```

    //역컴파일

    ![그림3](C:\Users\kosta\Desktop\까마귀\img\그림3.PNG)

    - method가 추가됨(values(), valueOf())

- ## Annotation(metadata)

  - 오늘은 개념과 사용방법 위주로 설명

  - Spring이라는 Framework쓰면서 활성화 됨

  - @Override 주석이라고 생각하세요 ~ 관련

  - 사전적 의미 : 주석, 설명

  - @ : Announce 의 약자 (뭘 알린다? 정해진 주석을), 컴파일러나 인터프리터를 위한 주석, 앞으로는 주석이라고 하기 보다는 metadata(데이터에 대한 데이터)라고 해야됨

    - @ 는 클래스선언부, 인스턴스 선언부, 메소드 선언부, 생성자 ... 다 쓸 수 있음!

  - // : 나를 위한 주석 , 프로그램에 영향 X

  - @Deprecated : 곧 폐기처분될 거니까 쓰지 마세요

    ![그림4](C:\Users\kosta\Desktop\까마귀\img\그림4.PNG)

  - @Override : 재정의

![그림5](C:\Users\kosta\Desktop\까마귀\img\그림5.PNG)

- **Formatter Class**

  - 데이터 주면서 예쁘게 format해서~
  - 클래스 자체가 추가된 것 (이름이 **Formatter**)
  - util 패키지에 있음

  ``` java
  import java.util.Formatter;
  
  public class FormatterExample {
  
  	public static void main(String[] args) {
  		int number = 1234567;
  		Formatter formatter = new Formatter();
  		// Formatter format(String format,Object... args)
  		// format : "%[출력인자순서$][출력옵션(-(좌측으로 정렬), +, (,,..)][출력자리수][.소수점이하자리수]출력데이터유형"
  		// %랑 츨력데이터유형은 생략 X
  		// args : 포맷팅 하고자 하는 가변인자
  		String formatedString = null;
  		formatedString = formatter.format("%d", number).toString();
  		System.out.println(formatedString);
  
  		formatter = new Formatter();
  		// 우측정렬 후 정수로 출력
  		System.out.println(formatter.format("%1$d", number));
          //1$는 number를 참조하라는 뜻
  
  		formatter = new Formatter();
  		// 20자리확보하고, 3자리단위 콤마 찍고, 부호달고, 좌측정렬 후 정수로 포맷
  		System.out.println(formatter.format("%,+-20d", number));
  
  		double height = 23454.34343434356;
  		formatter = new Formatter();
  		// 20자리확보하고, 3자리단위 콤마 찍고, 부호달고, 좌측정렬 후 소수점 이하 2자리 실수로 포맷
  		System.out.println(formatter.format("%,+-20.2f", height));
  
          
  		formatter = new Formatter();
  		// 20자리확보하고, 3자리단위 콤마 찍고, 부호달고, 정수로 포맷
  		System.out.println(formatter.format("%,+20d", number));
          
  		String name = "김기정";
  		formatter = new Formatter();
  		// 10자리확보하고 우측정렬 후 문자열 포맷
  		System.out.println(formatter.format("%10s", name));
  
  		formatter = new Formatter();
  		System.out.println(formatter.format("%o", 150)); //8진수 포맷
  		System.out.println(formatter.format("%x", 458)); //16진수 포맷
  
      }
  
  }
  /*출력
  1234567
  1234567
  +1,234,567          
  +23,454.34    
            +1,234,567
         김기정
  226
  2261ca      
   */
  ```

  - 불편하니까 2가지의 방법을 사용하자!

    - printf 를 이용(도스콘솔 전용)
    - String.format 으로(이 방법을 많이 씀)

    ``` java
    // 도스콘솔 전용
    System.out.printf("%,+-10d\n", 198745);
    System.out.printf("%1$,-10d와 %2$,10d\n", 1000, 2000);
    
    // String 클래스의 클래스메소드 활용
    String fs = String.format("%,20.2f\n", 198745.678);
    System.out.println(fs);
    ```

``` java
System.out.println(String.format("%tY", Calendar.getInstance())); //4자리년도
System.out.println(String.format("%ty", Calendar.getInstance())); //2자리년도
System.out.println(String.format("%tm", Calendar.getInstance())); //숫자월 
System.out.println(String.format("%tB", Calendar.getInstance())); //문자열월
System.out.println(String.format("%td", Calendar.getInstance())); //일
System.out.println(String.format("%tA", Calendar.getInstance())); //요일

System.out.println(String.format("%tH", Calendar.getInstance())); //24시간
System.out.println(String.format("%1$tp %tI", Calendar.getInstance())); //오전/오후 12시간System.out.println(String.format("%tM", Calendar.getInstance())); //분
System.out.println(String.format("%tS", Calendar.getInstance())); //초

System.out.println(String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %1$tA", Calendar.getInstance()));

// 날짜/시간 합성문자 사용
System.out.println(String.format("%1$tF %1$tT", Calendar.getInstance()));

/*출력
2018
18
08
8월
27
월요일
14
오후 02
47
2018-08-27 14:40:47 월요일
2018-08-27 14:40:47
*/
```

- 연월일 : tF / 시분초 : tT

  - String.format("%1$tF %1$tT", Calendar.getInstance())

    => 2018-08-27 14:40:47 출력

## Calendar 클래스

- 날짜 및 시간과 관련된 정보를 제공하는 **추상클래스**

  ``` java
  import java.util.Calendar;
  import java.util.GregorianCalendar;
  
  public class CalendarExample {
  	public static void main(String[] args) {
  //		Calendar today = new Calendar();
  //		Calendar today = new GregorianCalendar();
  //		today = new GregorianCalendar();
  		
  		Calendar today = Calendar.getInstance();
  		//getInstance() : factory method / 메모리절약
  		today = Calendar.getInstance();
  		today = Calendar.getInstance();
  		today = Calendar.getInstance();
  		today.set(Calendar.YEAR, 1987);
  		
  		
  		System.out.println(today);
  		
  		int year = today.get(Calendar.YEAR);
  		int month = today.get(Calendar.MONTH) + 1; //java는 0 부터 시작해서
  		int date = today.get(Calendar.DATE);
  		int day = today.get(Calendar.DAY_OF_WEEK);
  		
  		System.out.println(year);
  		System.out.println(month);
  		System.out.println(date);
  		
  		
  		System.out.println(year+"년 "+month+"월 "+date+"일");
  		
  		switch (day) {
  		case Calendar.SUNDAY: System.out.println("일요일");	break;
  		case Calendar.MONDAY: System.out.println("월요일");	break;
  		case Calendar.TUESDAY: System.out.println("화요일");	break;
  		case Calendar.WEDNESDAY: System.out.println("수요일");	break;
  		case Calendar.THURSDAY: System.out.println("목요일");	break;
  		case Calendar.FRIDAY: System.out.println("금요일");	break;
  		case Calendar.SATURDAY: System.out.println("토요일");	break;
  
  		default:
  			break;
  		}
  		
  		
  	}
  
  }
  
  
  /*출력
  java.util.GregorianCalendar[time=1535347895084,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=22,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2018,MONTH=7,WEEK_OF_YEAR=35,WEEK_OF_MONTH=5,DAY_OF_MONTH=27,DAY_OF_YEAR=239,DAY_OF_WEEK=2,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=2,HOUR_OF_DAY=14,MINUTE=31,SECOND=35,MILLISECOND=84,ZONE_OFFSET=32400000,DST_OFFSET=0]
  2018
  8
  27
  2018년 8월 27일
  */
  ```



- Integer.parseInt(year) : String 형인 year를 int 형태로 



## 예외처리

- 예외란? 프로그램 실행 중에 발생할 수 있는 예기치 않은 사소한 에러

- 치명적인 에러와 달리 프로그램이 종료되어야 할 필요까지는 없는 작은 에러

- JVM(Java Virtual Machine)의 경우 프로그램 실행 중에 사소한 예외가 발생하면 예외 메시지를 콘솔에 출력한 후 프로그램을 강제 종료하는 기본 메커니즘을 가진다.

- 예외가 발생하면 그 시점에서 해당하는 new 객체로..

  ``` java
  public class Foo {
  	
  	public void someMethod() {
  		String message = null;
  		System.out.println(message.length()); 
  		// Exception 발생 new NullpointException 생성됨 쟤도 클래스라서 화면에 출력되는 것
  		
  	}
  	
  	public static void main(String[] args) {
  		System.out.println("JVM에 의해 프로그램 시작됨");
  		Foo foo = new Foo();
  		foo.someMethod();
  		System.out.println("프로그램 종료됨");
  		
  		
  	}
  	
  }
  ```

  

![그림6](C:\Users\kosta\Desktop\까마귀\img\그림6.png)

![그림7](C:\Users\kosta\Desktop\까마귀\img\그림7.PNG)

- 오류 메시지는 아래에서 위로 읽기!

- 발생시킨 예외 인스턴스를 개발자가 명시적으로 처리(Handling)하지 않을 경우 JVM은 예외 관련 메시지(Call stack message)를 화면에 출력한 후 프로그램을 강제 종료한다. 

- 예외 처리 방법

  - **직접처리(try - catch - finally)**

    - 직접적으로 발생한 시점에서 처리

    - 코드속에 구문화 되어있음

      ``` java
      try{
           // 예외가 발생할 가능성이 있는 실행 코드들
           // 주로 입출력, 네트워크처리, 데이터베이스 연동 등
      }catch(예외 클래스  매개변수){
           // 예외 처리 코드
      } …
      catch(Exception  ex){
           // 예외 처리 및 예외 메시지 출력
           // 상속구조상 최상위 클래스
           // Up Casting
           // switch case의 default 처럼
      }finally{
           // 예외가 발생 여부와 관계없이 항상 실행되는 코드
           // 주로 입출력 리소스 해제, 데이터 베이스 연결 종료 등
      }
      ```

      ``` java
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
      			System.out.println(message.length()); 
      			// Exception 발생 new NullpointException 생성됨 쟤도 클래스라서 화면에 출력되는 것
      			
      			System.out.println(10/0);
      			// new ArithmeticException
      			
      			int[] array = {1,2,3};
      			System.out.println(array[3]);
      			//ArrayIndexOutOfBoundsException
      		
      		}catch(NullPointerException e) {
      //			System.out.println("인스턴스 생성 안됐다.");
      			System.out.println(e.getMessage());
      			e.printStackTrace(); // call stack 에 있는 것 출력
      		}
      		
      	}
      
      	public static void main(String[] args) {
      		System.out.println("JVM에 의해 프로그램 시작됨");
      		Foo foo = new Foo();
      		foo.someMethod2();
      		System.out.println("프로그램 종료됨");
      
      	}
      
      }
      ```

      - **catch 안에 return을 써도 finally는 실행됨!!!!!!!!!!!!(시험)**
      - System.exit(0); 이때는 실행 X virtual machine을 강제종료시키기 때문에

  - **간접처리(throws)**

    - 발생된 예외를 메소드내에서 직접 처리하는 것이 아니라 호출한 메서드에게 발생한 예외 인스턴스를 떠넘겨 간접적으로 처리하는 방법

      ``` java
      public void method() throws 예외 클래스1 [,예외 클래스2,…] {
      	// 예외가 발생할 가능성이 있는 코드
      }
      ```

    - 호출한 쪽으로 넘어감

    - 왜 필요? 상황에 따라 달라짐

      ``` java
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
      
      /*출력
      JVM에 의해 프로그램 시작됨
      메인에서 모든 예외처리 완료
      프로그램 종료됨
      */
      ```

  - 오버라이딩 할 때 부모클래스 메소드에 예외처리가 되어있으면 자식클래스 메소드에 예외서브클래스를 예외처리해도 된다.
