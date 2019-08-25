package Character.Race;

import Character.Player;

public class Demon extends Race {

    public Demon(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void generateStats(int lvl) {
        newStats(lvl, 7, 3, 1, 1, 3);
    }

    @Override
    public void drop(Player player) {
        player.addMaterial("shadowstone");
        player.addToken(getLvl());
        dropText(new String[]{"shadowstone", "token"}, new int[]{getLvl(), getLvl()});
    }
}
