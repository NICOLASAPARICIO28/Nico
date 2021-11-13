public class CheckingAccount extends BankAccount {
   protected static final double FEE = 0.15;

   public CheckingAccount(String name, double initialAmount) {
       super(name, initialAmount);
       setAccountNumber(getAccountNumber() + "-10");
   }

   @Override
   public boolean withdraw(double amount) {

       if (getBalance() < amount) {
           return false;
       } 
       else {
           setBalance(getBalance() - amount - FEE);
           return true;
       }
   }
}