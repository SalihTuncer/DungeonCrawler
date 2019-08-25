package Character.Race;

public class Harpy extends Race {

    public Harpy(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void generateStats(int lvl) {
        newStats(lvl, 6, 4, 1, 1, 3);
    }

    @Override
    public void initializeLoot() {
        getLoot().add(getLvl(), "windstone");
        getLoot().add(getLvl(), "token");
    }

    @Override
    public void initializeLootAmount() {
        getLootAmount().add(getLvl());
        getLootAmount().add(getLvl());
    }
}
