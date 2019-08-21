package Location.Blacksmith;

import Location.Location;
import Text.Blacksmith.ForgeEquipmentText;

public class ForgeEquipment extends Location {

    public ForgeEquipment(String name) {
        super(name);
        //text of the current location will be printed
        setText(new ForgeEquipmentText());
    }
}
