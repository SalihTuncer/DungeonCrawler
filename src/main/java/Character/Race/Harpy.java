package Character.Race;

import Character.Player;

public class Harpy extends Race {

    public Harpy(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void generateStats(int lvl) {
        newStats(lvl, 6, 4, 1, 1, 3);
    }

    @Override
    public void drop(Player player) {
        player.addMaterial("flystone");
        player.addToken(getLvl());
    }
}
