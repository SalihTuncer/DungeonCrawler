package Movement;

import Character.Player;

public class Walk extends Movement {

    public Walk() {
        super();
    }

    public void move(Player traveler, String destination) {
        traveler.findLocationByName(destination).getText().printText(traveler);
    }
}
