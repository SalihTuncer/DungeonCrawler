package Location.Blacksmith;

import Location.Location;
import Text.Blacksmith.UpgradeEquipmentText;

public class UpgradeEquipment extends Location {

    public UpgradeEquipment(String name) {
        super(name);
        //text of the current location will be printed
        setText(new UpgradeEquipmentText());
    }
}
