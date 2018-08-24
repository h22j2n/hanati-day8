
public class Mission {

	public static void main(String[] args) {
		Account account1 = new Account("1111-2222-3333", "조희진", 1111, 10000);
		Account account2 = new Account("1111-2222-3333", "조희진", 1111, 10000);
		System.out.println(account1 == account2);
		System.out.println(account1.equals(account2));
		System.out.println(account1.equals("Java"));		
		
		String str1 = "java";
		String str2 = "java";
		System.out.println(str1.equals(str2));

	}

}
