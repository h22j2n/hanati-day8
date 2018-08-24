import java.util.Scanner;

/**
 * 배열을 이용한 은행계좌 관리
 * 
 * @author 조희진
 *
 */
public class AccountManager {
	
	private Account[] accounts;
	private int count = 0;
	
	
	AccountManager(int num){
		accounts = new Account[num];
	}
	
	/**
	 * 
	 * @param account	추가할 계좌
	 */
	public void add(Account account) {
		accounts[count] = account;
		count++;
	}
	
	//실제 들어있는 것만 반환
	/**
	 * @return	계좌 목록
	 */
	public Account[] list() {
		Account[] tmp = new Account[count];
		for (int i = 0; i < count; i++) {
			
			tmp[i]=accounts[i];
			
		}
		return tmp;
	}
	
	
	/**
	 * @param accountNum	계좌번호
	 * @return	검색결과
	 */
	public Account get(String accountNum) {
		Account tmp = null;
		for (int i = 0; i < count; i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				tmp = accounts[i];
				break;				
			}
			
			if(i==count-1 && !(accountNum.equals(accounts[i].getAccountNum()))){
				tmp = null;
				
			}		
			
		}
		return tmp;
	}
	
	//이름으로 검색
	/**
	 * @param accountOwner	소유주
	 * @return	검색결과
	 */
	public Account[] search(String accountOwner) {
		int index = 0;
		for (int i = 0; i < count; i++) {
			if(accountOwner.equals(accounts[i].getAccountOwner())) {
				index ++;		
			}
		}
		Account[] tmp = new Account[index];
		index = 0;
		for (int i = 0; i < count; i++) {
			if(accountOwner.equals(accounts[i].getAccountOwner())) {
				tmp[index] = accounts[i];
				index++;
			}
		}

		return tmp;
	}
	
	/**
	 * @param accountNum	삭제할 계좌번호
	 * @return	결과 성공/실패
	 */
	public boolean remove(String accountNum) {
		
		for (int i = 0; i < count; i++) {
			if(accountNum.equals(accounts[i].getAccountNum())) {
				for (int j = i; j < count-1; j++) {
					accounts[j]=accounts[j+1];		
				}
				accounts[count-1]=null;
				count--;
				return true;
				
			}
			
		}
		return false;
	}

}

