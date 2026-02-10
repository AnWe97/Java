import java.util.Random;

public class enemy {

    //functions setup
    Random random = new Random();

    //enemy setup
    String name;
    int health;
    boolean dead = false;

    public enemy(String name, int health) {

        this.name = name;
        this.health = health;

    }

    //enemy attack
    public void enemy_attack (player player, int index){

        //variable
        int enemy_damage = 0;

        //damage roll

        //regular orc
        if(this.name == "Orc") {
            enemy_damage = random.nextInt(3) + 2;

        //orc queen
        } else if (this.name == "Orc Queen") {
            enemy_damage = 5;

        }

        //hit roll
        int hit_roll = random.nextInt(100) + 1;

        //missed attack
        if(hit_roll <= 20){
            System.out.println(this.name + " " + (index + 1) + " missed.");
        }

        //attack hits
        else{
            System.out.println(this.name + " " + (index + 1) + " deals " + enemy_damage + " damage.");
            player.health -= enemy_damage;

            //player dead check
            if(player.health <= 0){
                player.dead = true;
                end_screen.show(player);
            }
        }
    }
}