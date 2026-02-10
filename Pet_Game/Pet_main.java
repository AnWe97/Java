import java.util.Scanner;

public class Pet_main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // pet init
        Pet pet_1 = new Pet("Cinni", "dog", 0);
        Pet pet_2 = new Pet("Nero", "cat", 0);
        Pet pet_3 = new Pet("Willi", "bird", 0);

        // start management
        System.out.println("You have " + pet_1.get_name() + ", " + pet_2.get_name() + " and " + pet_3.get_name() + ".");

        // call pets
        System.out.println(pet_1.get_name() + " is a " + pet_1.get_species());
        System.out.println(pet_2.get_name() + " is a " + pet_2.get_species());
        System.out.println(pet_3.get_name() + " is a " + pet_3.get_species());

        while (true) {
            System.out.println("------------------------");

            String animal = choose_pet(scanner, pet_1, pet_2, pet_3);

            String choice = choice(scanner);

            call_methods(animal, choice, pet_1, pet_2, pet_3);

        }
    }

    public static String choose_pet(Scanner scanner, Pet pet_1, Pet pet_2, Pet pet_3) {
        System.out.println("Who do you want to tend?");
        System.out.println("(1) " + pet_1.get_name());
        System.out.println("(2) " + pet_2.get_name());
        System.out.println("(3) " + pet_3.get_name());

        String animal = scanner.nextLine();

        return animal;
    }

    public static String choice(Scanner scanner){
        System.out.println("What do you want to do?");
        System.out.println("(1) Check hunger.");
        System.out.println("(2) Feed");
        System.out.println("(3) Play.");

        String choice = scanner.nextLine();
        return choice;
    }

    public static void call_methods(String animal, String choice, Pet pet_1, Pet pet_2, Pet pet_3){
        if (animal.equals("1")) {
            pet_1.action(choice);
        } else if (animal.equals("2")) {
            pet_2.action(choice);
        } else if (animal.equals("3")) {
            pet_3.action(choice);
        } else {
            System.out.println("Invalid action");
        }
    }

}