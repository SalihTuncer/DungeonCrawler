package Location.Blacksmith;

import Location.Location;
import Text.Blacksmith.SellEquipmentText;

public class SellEquipment extends Location {

    public SellEquipment(String name) {
        super(name);
        //text of the current location will be printed
        setText(new SellEquipmentText());
    }
}
