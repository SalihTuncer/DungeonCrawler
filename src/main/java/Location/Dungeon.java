package Location;

import Character.Player;
import Text.DungeonText;

public class Dungeon extends Location {

    public Dungeon(String name, Player player) {
        super(name);
        //only when entering the dungeon, an enemy will be generated
        player.generateEnemy(player.getLvl());
        //options will be printed
        new DungeonText(player);
    }
}
