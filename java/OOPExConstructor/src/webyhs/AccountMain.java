package webyhs;

public class AccountMain {

	public static void main(String[] args) {
		Account acc = new Account(10000);
		acc.deposit(10000);
		acc.withdraw(-11000);
		System.out.println("현재 잔액 : " + acc.getBalance());
		acc.withdraw(9900);
		System.out.println("현재 잔액 : " + acc.getBalance());
	}

}
