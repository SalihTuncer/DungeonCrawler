package Location.Blacksmith;

import Location.Location;
import Text.Blacksmith.BuyFlaskText;

public class BuyFlask extends Location {

    public BuyFlask(String name) {
        super(name);
        //text of the current location will be printed
        setText(new BuyFlaskText());
    }
}
