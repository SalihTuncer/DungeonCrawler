package Location;

import Text.BackpackText;

public class Backpack extends Location {

    public Backpack(String name) {
        super(name);
        //text of the current location will be printed
        this.text = new BackpackText();
    }
}
