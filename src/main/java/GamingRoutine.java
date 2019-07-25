import Location.Location;
import Text.Text;
import Character.Player;

class GamingRoutine {

    void start(){
        Player p1 = new Player(1);

        Location start = new Location("Start");

        //at the beginning of the game, the player is in the hometown
        p1.setLocation(start);

        Text text= new Text(p1.getLocation());

    }
}
