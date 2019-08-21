package Application;

import Character.Player;
import Text.StartText;

public class GamingRoutine {

    public void start() {
        //a player is generated
        Player p1 = new Player();

        //output of the intro
        new StartText().printText(p1);

        //game starts in hometown
        p1.findLocationByName("hometown").getText().printText(p1);
    }
}
