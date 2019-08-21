package Character.Race;

import Character.Player;

public class Golem extends Race {

    public Golem(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void drop(Player player) {
        player.addToken(getLvl());
    }
}
