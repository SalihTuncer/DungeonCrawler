package Character.Race;

import Character.Player;

public class Vampire extends Race {

    public Vampire(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void drop(Player player) {
        player.addMaterial("bloodstone");
        player.addToken(getLvl());
    }
}
