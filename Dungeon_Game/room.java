import java.util.Scanner;
import java.util.Random;

public class room {

    //functions setup
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    boolean first_enter = true;
    boolean room_empty = false;

    //room setup
    String name;

    //enemy setup
    enemy[] enemies;

    //room setup
    public room(String name) {

        this.name = name;

        //enemy setup
        //sleeping chambers
        if(this.name != "Throne Room") {
            int enemy_numbers = random.nextInt(4);
            enemies = new enemy[enemy_numbers];

            for (int i = 0; i < enemy_numbers; i++) {
                enemies[i] = new enemy("Orc", 10);
            }
        }
        //throne room
        else{
            enemies = new enemy[3];
            enemies[0] = new enemy("Orc", 10);
            enemies[1] = new enemy("Orc", 10);
            enemies[2] = new enemy("Orc Queen", 25);
        }
    }

    //enter room
    public void enter(player player) {

        //enter for first time
        if(first_enter){
            System.out.println(player.name + " enters " + name);

            //extra message for orc queen
            if(this.name.equals("Throne Room")){
                System.out.println("You stand before the mighty Orc Queen, she calls 2 Orcs to her side.");
            }
            first_enter = false;
        }

        //enemy spawn
        //0 enemies
        if(enemies.length == 0){
            System.out.println("The room is empty.");
            room_empty = true;

        }
        //1 enemy
        else if (enemies.length == 1 && enemies[0].health > 0) {
            System.out.println("An " + enemies[0].name + " is standing in your way.");

        }
        //2 or 3 enemies
        else{
            int enemies_alive = 0;

            //check if dead
            for(int i = 0; i < enemies.length; i++){
                if(enemies[i].health > 0){
                    enemies_alive++;
                }
            }

            //display alive orcs

            //0 orcs
            if(enemies_alive == 0){
                System.out.println("The room is empty.");
                room_empty = true;

            //multiple orcs
            } else if (enemies_alive > 1) {
                System.out.println(enemies_alive + " " + enemies[0].name + "s are standing in your way.");

            //one orc
            }else{
                System.out.println("An " + enemies[0].name + " is standing in your way.");

            }
        }

        //show health points and death state
        for(int i = 0; i < enemies.length; i++){

            if(enemies[i].health <= 0){
                System.out.println(enemies[i].name + " " + (i + 1) + " is dead.");
            }
            else {
                System.out.println(enemies[i].name + " " + (i + 1) + " has " + enemies[i].health + " health points.");
            }
        }
        System.out.println("The player has " + player.health + " health points.");

        //proceed to next chamber
        if (room_empty && this.name != "Throne Room"){
            System.out.println("The chamber is empty, you can proceed to the next one.");

            //ask for next chamber || throne room
            if(this.name.equals("Sleeping chamber 4")){
                System.out.println("Do you want to enter the Throne room and risk it all?");
            }else{
                System.out.println("Do you want to enter the next chamber and risk it all?");
            }

            System.out.println("You currently have " + player.gold + " gold.");
            System.out.println("(1)Proceed to next room.");
            System.out.println("(2)Exit dungeon.");
            String action = scanner.nextLine();

            if(action.equals("1")){
                return;
            } else if (action.equals("2")) {
                end_screen.show(player);
            }

        }

        if(room_empty && this.name.equals("Throne Room")){
            System.out.println("You've slain the Orc Queen.");
            System.out.println("You proceed to the treasure.");
            System.out.println("You pick up 1000 gold.");
            player.gold += 1000;
            end_screen.show(player);
        }

        //actions
        System.out.println("What are you doing?");
        System.out.println("(1)Single attack");
        System.out.println("(2)Multi attack");
        if(player.health_potion == 1){
            System.out.println("(3)Drink health potion (+15 health)");
        }

        String action = scanner.nextLine();

        //call action

        //single attack
        if(action.equals("1")) {

            //choose target
            System.out.println("Which enemy would you like to attack?");
            int index = scanner.nextInt();
            scanner.nextLine();

            index -= 1;

            //valid choice
            if(index < 0 || index >= enemies.length) {
                System.out.println("Invalid choice");
            }
            //chosen enemy dead
            else if (enemies[index].dead) {
                System.out.println("The enemy is already dead.");

            //valid choice
            }else{

                //player turn start
                player.single_attack(enemies[index]);

                //enemy turn start
                for (int i = 0; i < enemies.length; i++) {

                    if (enemies[i].dead == false) {
                        enemies[i].enemy_attack(player, i);
                    }
                }
            }


        //multi attack
        } else if (action.equals("2")) {

            //attack first living enemy in array
            for (int i = 0; i < enemies.length; i++) {

                if (enemies[i].dead == false) {

                    //player turn start
                    player.multi_attack(enemies[i], enemies);

                    //enemy turn start
                    for(int j = 0; j < enemies.length; j++){
                        if (enemies[j].dead == false) {
                            enemies[j].enemy_attack(player, j);
                        }
                    }
                }
            }

        //drink health potion
        } else if (action.equals("3") && player.health_potion == 1) {

            //player turn start
            player.drink_health_potion(player);

            //enemy turn start
            for(int i = 0; i < enemies.length; i++){
                if (enemies[i].dead == false) {
                    enemies[i].enemy_attack(player, i);
                }
            }

        }

        //room loop
        if (room_empty == false) {
            enter(player);
        }
    }
}