package Location;

import Character.Player;
import Text.SettingsText;

public class Settings extends Location {

    public Settings(String name, Player player) {
        super(name);
        //options will be printed
        this.text = new SettingsText();
    }

    public Settings(String name) {
        super(name);
    }

}
