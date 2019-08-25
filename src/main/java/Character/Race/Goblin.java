package Character.Race;

public class Goblin extends Race {

    public Goblin(String name) {
        setName(name);
        generateName();
    }

    @Override
    public void generateStats(int lvl) {
        newStats(lvl, 7, 2, 2, 1, 3);
    }

    @Override
    public void initializeLoot() {
        getLoot().add(getLvl(), "rainbowstone");
        getLoot().add(getLvl(), "token");
    }

    @Override
    public void initializeLootAmount() {
        getLootAmount().add(getLvl());
        getLootAmount().add(3 * getLvl());
    }

}
