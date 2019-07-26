package Location;

import Text.DungeonText;
import Character.Player;
import Character.Enemy;

public class Dungeon extends Location {

    public Dungeon(String name, Player player) {
        super(name);
        new DungeonText(player, new Enemy(player.getLvl()));
    }
}
