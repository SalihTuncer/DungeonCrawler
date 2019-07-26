package Location;

import Text.Text;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    //actual name of the location
    String name;
    //actual text of the location
    Text text;

    public Location(String name){
        this.name = name;
    }

}
