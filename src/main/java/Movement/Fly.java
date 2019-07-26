package Movement;

import Location.Location;
import Character.Player;

public class Fly extends Movement {

    Fly(Player traveler, Location destination) {
        super(traveler, destination);
    }

    protected void move(Player traveler, Location destination) {
        traveler.setLocation(destination);
    }
}
