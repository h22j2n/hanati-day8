
public class VarargsExample {

	public static int sum(int[] args) {
		int result = 0;
		for (int i : args) {
			result += i;
		}
		return result;
	}

	public static int summ(int... args) {
		int result = 0;
		for (int i : args) {
			result += i;
		}
		return result;
	}

	public static void main(String[] args) {

		int[] values = { 10, 20 };
		System.out.println(sum(values));
		
		System.out.println(summ(10,20));

	}
}
