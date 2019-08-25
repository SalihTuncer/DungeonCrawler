package Character.Race;

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
    public void initializeLoot() {
        getLoot().add(getLvl(), "firestone");
        getLoot().add(getLvl(), "token");
    }

    @Override
    public void initializeLootAmount() {
        getLootAmount().add(getLvl());
        getLootAmount().add(getLvl());
    }
}
