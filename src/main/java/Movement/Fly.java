package Movement;

import Character.Player;
import Location.Location;

public class Fly extends Movement {

    Fly(Player traveler, Location destination) {
        super(traveler, destination);
    }

    protected void move(Player traveler, Location destination) {
    }
}
