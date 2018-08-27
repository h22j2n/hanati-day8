import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarExample {
	
	public static int getWorks(String year, String month, String date) {
		Calendar cal;
		cal = Calendar.getInstance();
		int val1 = cal.get(Calendar.DAY_OF_YEAR);
		System.out.println(val1);
		int val2 = 0;
		for (int i = Integer.parseInt(year)+1; i < cal.get(Calendar.YEAR); i++) {
			if(i%4 ==0) {
				val2 += 366;
			}
			else {
				val2+=365;
			}
		}
		System.out.println(val2);
		
		//int val2 = (cal.get(Calendar.YEAR) - Integer.parseInt(year)-1)*365;
		
		
		cal.set(Calendar.YEAR,Integer.parseInt(year));
		cal.set(Calendar.MONTH,Integer.parseInt(month)-1);
		cal.set(Calendar.DATE,Integer.parseInt(date));
		
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		
		int val3 = 366 - cal.get(Calendar.DAY_OF_YEAR);
		System.out.println(val3);
		return val1+val2+val3;
	}
	
	public static void main(String[] args) {
//		Calendar today = new Calendar();
//		Calendar today = new GregorianCalendar();
//		today = new GregorianCalendar();
		
		Calendar today = Calendar.getInstance();
		//getInstance() : factory method
		today = Calendar.getInstance();
		today = Calendar.getInstance();
		today = Calendar.getInstance();
//		today.set(Calendar.YEAR, 1987);
		
		
		System.out.println(today);
		
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1; //java는 0 부터 시작해서
		int date = today.get(Calendar.DATE);
		int day = today.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(date);
		
		
		System.out.println(year+"년 "+month+"월 "+date+"일");
		System.out.println(today.get(Calendar.DAY_OF_YEAR));
		
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
		
		//근무일수 구하기
		int value = getWorks("1987","3","1");
		System.out.println(value);
		
	}

}
