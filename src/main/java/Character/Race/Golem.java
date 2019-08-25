package Character.Race;

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
    public void initializeLoot() {
        getLoot().add(getLvl(), "earthstone");
        getLoot().add(getLvl(), "token");
    }

    @Override
    public void initializeLootAmount() {
        getLootAmount().add(getLvl());
        getLootAmount().add(getLvl());
    }
}
