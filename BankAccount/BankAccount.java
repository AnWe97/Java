public class BankAccount {

    String customerName;
    String iban;
    double balance;


    public BankAccount(String customerName, String iban, double balance) {
        this.customerName = customerName;
        this.iban = iban;
        this.balance = balance;
    }

    public String getCustomerName() {return this.customerName;}

    public String getIban() {return this.iban;}

    public double getBalance() {return this.balance;}

    public void depositAmount(double amount) {this.balance += amount;}

    public void withdrawAmount(double amount) {

        if (this.balance >= amount) {
            this.balance -= amount;
        }else{
            System.out.println("Insufficient funds.");
        }
    }
}