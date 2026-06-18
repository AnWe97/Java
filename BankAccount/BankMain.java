import java.util.Scanner;

public class BankMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean cancel = false;
        boolean cardInserted = false;
        int index = 0;

        BankAccount customer1 = new BankAccount("Max Mustermann",
                "DE70500105176388459287",
                5000);
        BankAccount customer2 = new BankAccount("Tim Mannmuster",
                "DE69500105178394149936",
                2500);
        BankAccount customer3 = new BankAccount("Thomas Muster",
                "DE56500105179342161337",
                7800);

        BankAccount[] customers =  {customer1,customer2,customer3};

        while(!cancel) {

            if (!cardInserted){

            System.out.println("Welcome to the ATM.");
            System.out.println("Pleaser enter your card.");
            System.out.println("(1) Max Mustermann");
            System.out.println("(2) Tim Mannmuster");
            System.out.println("(3) Thomas Muster");
            System.out.println("(4) Exit");

            switch (scanner.nextLine()) {
                case "1":
                    index = 0;
                    cardInserted =  true;
                    break;
                case "2":
                    index = 1;
                    cardInserted =  true;
                    break;
                case "3":
                    index = 2;
                    cardInserted =  true;
                    break;
                case "4":
                    cancel = true;
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }

            }else if (cardInserted){
                System.out.println("Welcome " + customers[index].getCustomerName());

                System.out.println("What do you want to do: ");
                System.out.println("(1) View Balance.");
                System.out.println("(2) Deposit money.");
                System.out.println("(3) Withdraw money.");
                System.out.println("(4) Exit");

                switch (scanner.nextLine()) {
                    case "1":
                        System.out.println("Current balance: " + customers[index].getBalance() + ".");
                        System.out.println("Your IBAN: " + customers[index].getIban());
                        break;
                    case "2":
                        System.out.println("How much money would you like to deposit?: ");
                        double depositMoneyAmount = scanner.nextDouble();
                        customers[index].depositAmount(depositMoneyAmount);
                        break;
                    case "3":
                        System.out.println("How much money would you like to withdraw?: ");
                        double withdrawMoneyAmount = scanner.nextDouble();
                        customers[index].withdrawAmount(withdrawMoneyAmount);
                        break;
                    case "4":
                        System.out.println("Good bye, " + customers[index].getCustomerName() + ".");
                        cardInserted = false;
                        break;
                }
            }
        }
    }
}