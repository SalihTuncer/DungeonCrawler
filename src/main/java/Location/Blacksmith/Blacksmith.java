package Location.Blacksmith;

import Character.Player;
import Location.Location;
import Text.Blacksmith.BlacksmithText;

public class Blacksmith extends Location {

    public Blacksmith(String name, Player player) {
        super(name);
        //text of the current location will be printed
        setText(new BlacksmithText(player));
    }
}
