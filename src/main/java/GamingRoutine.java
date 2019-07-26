import Location.*;
import Text.StartText;
import Character.Player;

class GamingRoutine {

    void start(){
        //a player is generated
        Player p1 = new Player(1);

        //output of the intro
        new StartText(p1);

        //the player is set to the hometown
        p1.setLocation(new Hometown("Hometown", p1));

    }
}
