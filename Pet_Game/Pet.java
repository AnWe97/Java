public class Pet {

    private String name;
    private String species;
    private int hunger_level;

    public Pet(String name, String species, int hunger_level) {
        this.name = name;
        this.species = species;
        this.hunger_level = hunger_level;
    }

    public String get_name() {
        return this.name;
    }

    public int get_hunger() {
        return this.hunger_level;
    }

    public String get_species() {
        return this.species;
    }

    public void action(String choice) {
        // check hunger direction
        if (choice.equals("1")) {
            check_hunger();
        }
        // feed direction
        else if (choice.equals("2")) {
            feed();
        }
        // play direction
        else if (choice.equals("3")) {
            play();
        }
    }

    public void check_hunger(){
        System.out.println(this.name + "`s hunger is at " + this.hunger_level);
    }

    public void feed(){
        if (this.hunger_level <= 0) {
            System.out.println(this.name + " is well fed.");
        } else {
            System.out.println("You feed " + this.name + ".");
            this.hunger_level -= 20;
            if (this.hunger_level < 0) {
                this.hunger_level = 0;
            }
        }
    }

    public void play(){
        System.out.println("You play with your " + this.species + " " + this.name + ".");
        System.out.println("It gets hungrier.");
        this.hunger_level += 10;
    }

}
