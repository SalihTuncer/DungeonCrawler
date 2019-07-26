import Location.*;
import Text.StartText;
import Character.Player;

class GamingRoutine {

    void start(){
        //a player is generated
        Player p1 = new Player(1);

        //at the beginning of the game, the player is introduced to the game
        p1.setLocation(new Location("Start"));

        //output of the intro
        new StartText(p1);

        //the player is set to the hometown
        p1.setLocation(new Hometown("Hometown"));

        //the game routine is now running all the time

    }
}
