public class SavingsAccount extends BankAccount {

	private static final double RATE = 2.5;
	private static int savingsNumber = 0;
	private String accountNumber;

	public SavingsAccount(String name, double amount) {
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}

	public void postInterest() {
		setBalance(getBalance() + (getBalance() * (RATE / 100)));
	}
	
	public SavingsAccount(BankAccount oldAccount, double amount) {
		super(oldAccount, amount);
		savingsNumber++;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}

	@Override
	public String getAccountNumber() {
		return accountNumber;
	}
}