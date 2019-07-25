package Location;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {

    String location;

    public Location(String name){
        this.location = name;
    }
}
