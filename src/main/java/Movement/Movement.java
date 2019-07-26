package Movement;

import Location.Location;
import Character.Player;

public abstract class Movement {

    Movement(Player traveler, Location destination){
        move(traveler, destination);
    }

    protected abstract void move(Player traveler, Location destination);
}
