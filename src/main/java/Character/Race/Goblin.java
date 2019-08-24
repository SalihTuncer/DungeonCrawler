package Character.Race;

import Character.Player;

public class Goblin extends Race {

    public Goblin(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void generateStats(int lvl) {
        newStats(lvl, 7, 2, 2, 1, 3);
    }

    @Override
    public void drop(Player player) {
        player.addToken(3 * getLvl());
    }
}
