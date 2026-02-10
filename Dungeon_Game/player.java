import java.util.Random;

public class player {

    //funtions setup
    Random random = new Random();

    //player setup
    String name;
    int health;
    int gold;
    int health_potion;
    boolean dead = false;

    public player(String name, int health, int gold, int health_potion) {

        this.name = name;
        this.health = health;
        this.gold = gold;
        this.health_potion = health_potion;

    }

    //Single attack
    public void single_attack(enemy target) {

        int hit_roll = random.nextInt(100) + 1;

        //missed attack
        if (hit_roll <= 5){
            System.out.println("You missed your attack.");

        }

        //critical hit
        else if (hit_roll >= 6 && hit_roll <= 15) {
            System.out.println("Critical! You deal 9 damage.");
            target.health -= 9;

        }

        //normal attack
        else{
            System.out.println("You deal 6 damage.");
            target.health -= 6;

        }

        //death check & acquire loot
        //regular orc
        if (target.health <= 0 && target.name.equals("Orc") && target.dead == false){

            System.out.println("The " + target.name + " died.");
            int gold_amount = random.nextInt(100) + 1;
            gold += gold_amount;
            target.dead = true;
            System.out.println("You picked up " + gold_amount + " gold.");

        //orc queen
        } else if (target.health <= 0 && target.name.equals("Orc Queen") && target.dead == false) {
            System.out.println("The " + target.name + " died.");
            int gold_amount = random.nextInt(200) + 1;
            gold += gold_amount;
            target.dead = true;
            System.out.println("You picked up " + gold_amount + " gold.");

        }
    }

    //multi_attack
    public void multi_attack(enemy target, enemy[] enemies){
        int hit_roll = random.nextInt(100) + 1;

        //missed attack
        if (hit_roll <= 5){
            System.out.println("You missed your attack.");

        }

        //critical hit
        else if (hit_roll >= 6 && hit_roll <= 15) {

            System.out.println("Critical!");
            int enemies_alive = 0;

            //count alive enemies
            for(int i = 0; i < enemies.length; i++){
                if (enemies[i].dead == false){
                    enemies_alive++;
                }
            }

            //damage calc
            int split_damage = 9 / enemies_alive;

            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i].health > 0) {
                    enemies[i].health -= split_damage;
                    System.out.println("You deal " + split_damage + " damage to " + enemies[i].name + " " + (i + 1));
                }
            }
        }

        //normal attack
        else{

            //count enemies alive
            int enemies_alive = 0;

            for(int i = 0; i < enemies.length; i++){
                if (enemies[i].dead == false){
                    enemies_alive++;
                }
            }

            //damage calc
            int split_damage = 6 / enemies_alive;

            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i].health > 0) {
                    enemies[i].health -= split_damage;
                    System.out.println("You deal " + split_damage + " damage to " + enemies[i].name + " " + (i + 1));
                }
            }
        }

        //multi death check & acquire gold
        for(int i = 0; i < enemies.length; i++) {

            //regular orc
            if (enemies[i].health <= 0 && enemies[i].name.equals("Orc") && enemies[i].dead == false) {

                System.out.println(enemies[i].name + " " + (i + 1) + " died.");
                int gold_amount = random.nextInt(100) + 1;
                gold += gold_amount;
                enemies[i].dead = true;
                System.out.println("You picked up " + gold_amount + " gold.");

            }
            //orc queen
            else if (enemies[i].health <= 0 && enemies[i].name.equals("Orc Queen") && enemies[i].dead == false) {

                System.out.println("The Orc Queen died.");
                int gold_amount = random.nextInt(200) + 1;
                gold += gold_amount;
                enemies[i].dead = true;
                System.out.println("You picked up " + gold_amount + " gold.");

            }
        }
    }

    //drink health potion
    public void drink_health_potion(player player){

        health += 15;
        health_potion--;
        System.out.println("You drink your health potion.");
        System.out.println("+ 15 health.");
    }
}