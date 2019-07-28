package Movement;

import Character.Player;
import Location.Location;

public class Walk extends Movement {

    Walk(Player traveler, Location destination) {
        super(traveler, destination);
    }

    protected void move(Player traveler, Location destination) {
    }
}
