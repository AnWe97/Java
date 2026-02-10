public class dungeon_game {

    public static void main(String[] args) {

        //player setup
        player player = new player("Maze", 50, 0, 1);

        // room setup
        //sleeping chamber 1
        room chamber1 = new room("Sleeping chamber 1");
        chamber1.enter(player);

        //sleeping chamber 2
        if(chamber1.room_empty){
            room chamber2 = new room("Sleeping chamber 2");
            chamber2.enter(player);

            //sleeping chamber 3
            if(chamber2.room_empty){
                room chamber3 = new room("Sleeping chamber 3");
                chamber3.enter(player);

                //sleeping chamber 4
                if(chamber3.room_empty){
                    room chamber4 = new room("Sleeping chamber 4");
                    chamber4.enter(player);

                    //throne room
                    if(chamber4.room_empty){
                        room throneRoom = new room("Throne Room");
                        throneRoom.enter(player);
                    }
                }
            }
        }
    }
}