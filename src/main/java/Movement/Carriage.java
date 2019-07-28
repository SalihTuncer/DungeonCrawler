package Movement;

import Character.Player;
import Location.Location;

public class Carriage extends Movement {

    Carriage(Player traveler, Location destination) {
        super(traveler, destination);
    }

    protected void move(Player traveler, Location destination) {
    }
}
