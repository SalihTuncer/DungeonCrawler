import Character.Player;
import Location.Hometown;
import Text.StartText;

class GamingRoutine {

    void start(){
        //a player is generated
        Player p1 = new Player(1);

        //output of the intro
        new StartText(p1);

        //the player is set to the hometown
        new Hometown("Hometown", p1);

    }
}
