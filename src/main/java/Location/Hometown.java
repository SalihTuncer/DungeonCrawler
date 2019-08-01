package Location;

import Character.Player;
import Text.HometownText;


public class Hometown extends Location {

    public Hometown(String name, Player player) {
        super(name);
        //options will be printed
        this.text = new HometownText(player);
    }

    public Hometown(String name) {
        super(name);
    }
}
