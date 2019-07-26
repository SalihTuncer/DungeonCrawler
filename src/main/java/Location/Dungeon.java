package Location;

import Text.DungeonText;

public class Dungeon extends Location {
    public Dungeon(String name) {
        super(name);
        new DungeonText();
    }
}
