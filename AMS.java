/**
 * 은행 계좌 관리 애플리케이션
 * 
 * @author 조희진
 *
 */
public class AMS {

	public static void main(String[] args) {
		AccountManager manager = new AccountManager(100);

		Account account = new Account("1111-2222-3333", "조희진", 1111, 10000);
		manager.add(account);
		manager.add(new Account("2222-2222-3333", "양의지", 1111, 200000));
		manager.add(new Account("3333-2222-3333", "박건우", 1111, 300000));
		manager.add(new Account("4444-2222-3333", "오재원", 1111, 400000));
		manager.add(new Account("5555-2222-3333", "박보검", 1111, 1000000));
		manager.add(new Account("6666-2222-3333", "박보검", 1111, 2000000));

		// Up Casting
		manager.add(new MinusAccount("9999-1111-2222", "김대출", 1111, 1000, 1000000));
		manager.add(new MinusAccount("9999-2222-2222", "조대출", 1111, 1000, 1000000));

		manager.add(new Account("4444-2222-3333", "박찬호", 1111, 2000000));

		Account[] list = manager.list();

		for (Account account2 : list) {
			if (account2 instanceof MinusAccount) {
				System.out.println("마이너스계좌\t" + account2.toString());
			}
			else {
				System.out.println("입출금계좌\t" + account2.toString());

			}

		}
		

		System.out.println();

		if (manager.get("1122-2222-3333") == null) {
			System.out.println("해당하는 계좌가 없습니다.");
		} else
			System.out.println(manager.get("1122-2222-3333").toString());

		System.out.println();

		Account[] search = manager.search("박보검");
		if (search == null) {
			System.out.println("해당하는 계좌가 없습니다.");
		} else {
			for (Account account2 : search) {
				System.out.println(account2.toString());
			}

		}

		System.out.println();

		boolean remove = manager.remove("1111-2222-3333");
		if (remove == false) {
			System.out.println("삭제 실패!");
		} else
			System.out.println("삭제 완료!");

		Account[] list2 = manager.list();
		for (Account account2 : list2) {
			System.out.println(account2.toString());
		}

	}

}
