package Character.Race;

public class Undead extends Race {

    public Undead(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void generateStats(int lvl) {
        newStats(lvl, 8, 2, 2, 2, 1);
    }

    @Override
    public void initializeLoot() {
        getLoot().add(getLvl(), "gravestone");
        getLoot().add(getLvl(), "token");
    }

    @Override
    public void initializeLootAmount() {
        getLootAmount().add(getLvl());
        getLootAmount().add(getLvl());
    }
}
