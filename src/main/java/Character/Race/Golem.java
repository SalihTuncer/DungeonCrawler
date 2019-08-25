package Character.Race;

import Character.Player;

public class Golem extends Race {

    public Golem(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void generateStats(int lvl) {
        newStats(lvl, 9, 2, 2, 1, 1);
    }

    @Override
    public void drop(Player player) {
        player.addMaterial("earthstone");
        player.addToken(getLvl());
        dropText(new String[]{"earthstone", "token"}, new int[]{getLvl(), getLvl()});
    }
}
