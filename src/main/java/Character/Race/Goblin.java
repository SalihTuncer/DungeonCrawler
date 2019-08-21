package Character.Race;

import Character.Player;

public class Goblin extends Race {

    public Goblin(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void drop(Player player) {
        player.addToken(3 * getLvl());
    }
}
