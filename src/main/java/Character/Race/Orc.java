package Character.Race;

import Character.Player;

public class Orc extends Race {

    public Orc(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void generateStats(int lvl) {
        newStats(lvl, 8, 2, 2, 1, 2);
    }

    @Override
    public void drop(Player player) {
        player.addMaterial("angerstone");
        player.addToken(getLvl());
        dropText(new String[]{"angerstone", "token"}, new int[]{getLvl(), getLvl()});
    }
}
