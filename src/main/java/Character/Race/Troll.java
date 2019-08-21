package Character.Race;

import Character.Player;

public class Troll extends Race {

    public Troll(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void drop(Player player) {
        player.addToken(getLvl());
    }
}
