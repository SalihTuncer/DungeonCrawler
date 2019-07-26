package Location;

import Text.HometownText;
import Character.Player;

public class Hometown extends Location {
    public Hometown(String name, Player player) {
        super(name);
        new HometownText(player);
    }
}
