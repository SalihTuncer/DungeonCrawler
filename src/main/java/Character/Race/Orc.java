package Character.Race;

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
    public void initializeLoot() {
        getLoot().add(getLvl(), "angerstone");
        getLoot().add(getLvl(), "token");
    }

    @Override
    public void initializeLootAmount() {
        getLootAmount().add(getLvl());
        getLootAmount().add(getLvl());
    }
}
