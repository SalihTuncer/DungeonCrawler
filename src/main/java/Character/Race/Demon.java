package Character.Race;

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
    public void initializeLoot() {
        getLoot().add(getLvl(), "shadowstone");
        getLoot().add(getLvl(), "token");
    }

    @Override
    public void initializeLootAmount() {
        getLootAmount().add(getLvl());
        getLootAmount().add(getLvl());
    }

}
