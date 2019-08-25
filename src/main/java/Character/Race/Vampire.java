package Character.Race;

import Character.Player;

public class Vampire extends Race {

    public Vampire(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void generateStats(int lvl) {
        newStats(lvl, 8, 2, 1, 1, 3);
    }

    @Override
    public void drop(Player player) {
        player.addMaterial("bloodstone");
        player.addToken(getLvl());
        dropText(new String[]{"bloodstone", "token"}, new int[]{getLvl(), getLvl()});
    }
}
