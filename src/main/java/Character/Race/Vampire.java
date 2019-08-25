package Character.Race;

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
    public void initializeLoot() {
        getLoot().add(getLvl(), "bloodstone");
        getLoot().add(getLvl(), "token");
    }

    @Override
    public void initializeLootAmount() {
        getLootAmount().add(getLvl());
        getLootAmount().add(getLvl());
    }
}
