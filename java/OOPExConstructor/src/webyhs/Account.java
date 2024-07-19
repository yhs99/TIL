package webyhs;

public class Account {
	private int balance;

	public Account() {
		System.out.println("계좌가 생성되었습니다.");
	}
	
	public Account(int money) {
		this();
		this.balance = money;
	}
	public int getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		if(isValid(balance - money) && isValid(money)) {
			this.balance+=money;
			System.out.println(money + "원 입금후 잔액 : " + this.balance);
		}else {
			System.out.println("유효하지 않은 금액입니다.");
		}
		
	}
	
	public void withdraw(int money) {
		if(isValid(balance - money) && isValid(money)) {
			this.balance -= money;
			System.out.println(money + "원 출금후 잔액 : " + this.balance);
		}else {
			System.out.println("유효하지 않은 금액입니다.");
		}
	}
	
	private boolean isValid(int money) {
		return money > 0;
	}
}
