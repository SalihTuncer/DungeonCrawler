package Character.Race;

import Character.Player;

public class Harpy extends Race {

    public Harpy(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void drop(Player player) {
        player.addMaterial("flystone");
        player.addToken(getLvl());
    }
}
