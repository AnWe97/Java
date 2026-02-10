public class end_screen {

    public static void show(player player){

        //player dead
        if(player.dead){
            System.out.println(player.name + " died, you lost.");
            System.out.println("You made 0 points because you died.");
            System.out.println("Better luck next time.");
            System.exit(0);
        }else{
            System.out.println("Congratulations you left the dungeon alive.");
            System.out.println("You made " + player.gold + " gold.");
            System.exit(0);
        }
    }
}
