package Location;

import Text.HometownText;


public class Hometown extends Location {

    public Hometown(String name) {
        super(name);
        //options will be printed
        setText(new HometownText());
    }

}
