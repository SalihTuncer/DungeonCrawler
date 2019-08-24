package Character.Race;

import Character.Player;

public class Undead extends Race {

    public Undead(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void generateStats(int lvl) {
        newStats(lvl, 8, 2, 2, 2, 1);
    }

    @Override
    public void drop(Player player) {
        player.addToken(getLvl());
    }
}
