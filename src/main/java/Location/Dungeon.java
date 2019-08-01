package Location;

import Character.Player;
import Text.DungeonText;

public class Dungeon extends Location {

    public Dungeon(String name, Player player) {
        super(name);
        //only when entering the dungeon, an enemy will be generated
        player.generateEnemy(player.getLvl());
        //text of the current location will be printed
        this.text = new DungeonText(player);
    }

    public Dungeon(String name) {
        super(name);
    }
}
