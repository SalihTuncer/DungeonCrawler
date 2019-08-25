package Character.Race;

import Character.Player;

public class Troll extends Race {

    public Troll(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void generateStats(int lvl) {
        newStats(lvl, 9, 2, 2, 1, 1);
    }

    @Override
    public void drop(Player player) {
        player.addToken(getLvl());
        dropText(new String[]{"firestone", "token"}, new int[]{getLvl(), getLvl()});
        player.addMaterial("firestone");
    }
}
