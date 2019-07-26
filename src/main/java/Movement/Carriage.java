package Movement;

import Location.Location;
import Character.Player;

public class Carriage extends Movement {

    Carriage(Player traveler, Location destination) {
        super(traveler, destination);
    }

    protected void move(Player traveler, Location destination) {
        traveler.setLocation(destination);
    }
}
