package Character.Race;

import Character.Player;

public class Demon extends Race {

    public Demon(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void drop(Player player) {
        player.addMaterial("firestone");
        player.addToken(getLvl());
    }
}
