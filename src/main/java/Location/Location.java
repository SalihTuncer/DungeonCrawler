package Location;

import Text.Text;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Location {
    //actual name of the location
    private String name;
    //actual text of the location
    private Text text;

    public Location(String name) {
        this.name = name;
    }

}
