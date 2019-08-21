package Character.Race;

import Character.Player;

public class Orc extends Race {

    public Orc(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void drop(Player player) {
        player.addToken(getLvl());
    }
}
