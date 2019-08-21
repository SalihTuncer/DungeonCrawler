package Location;

import Text.SettingsText;

public class Settings extends Location {

    public Settings(String name) {
        super(name);
        //options will be printed
        setText(new SettingsText());
    }

}
