package Singleton;
import java.util.Scanner;

public class Main {
    public static void main(String[] Args){

        Scanner scanner = new Scanner(System.in);

        Logger logger = Logger.getInstance();

        System.out.println("Gib was ein, was geloggt werden soll:");
        String message = scanner.nextLine();

        logger.log(message);

        scanner.close();
    }
}
