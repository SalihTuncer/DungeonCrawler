package Character;

import java.util.HashMap;

public class Enemy extends Character {

    private HashMap<Integer, String> names;
    private HashMap<Integer, String> races;

    Enemy(int lvl) {
        super(lvl);
        initializeNames();
        initializeRaces();
        generateName();
    }

    @Override
    public void newStats(int lvl) {
        //the enemy has more bad values than the player because the player needs to play against multiple enemy in time
        setHp(getHp() + (int) (Math.random() * 4 + 6));
        setAtk(getAtk() + (int) (Math.random() * 1 + 1));
        setArmor(getArmor() + (int) (Math.random() * 1 + 1));
        setMResistance(getMResistance() + (int) (Math.random() * 1 + 1));
        setDex(getDex() + (int) (Math.random() * 1 + 1));
        setLvl(lvl);
        setXp(0);
    }

    private void initializeNames() {
        names = new HashMap<>();
        names.put(0, "lieutenant");
        names.put(1, "knight");
        names.put(2, "commander");
        names.put(3, "soldier");
        names.put(4, "mutant");
        names.put(5, "witch");
        names.put(6, "colossus");
        names.put(7, "queen");
        names.put(8, "king");
        names.put(9, "priest");
        names.put(10, "slave");
        names.put(11, "general");
        names.put(12, "lackey");
        names.put(13, "captain");
    }

    private void initializeRaces() {
        races = new HashMap<>();
        races.put(0, "Orc");
        races.put(1, "Golem");
        races.put(2, "Vampire");
        races.put(3, "Goblin");
        races.put(4, "Undead");
        races.put(5, "Troll");
    }

    private void generateName() {
        setName(races.get((int) (Math.random() * races.size())) + "-" + names.get((int) (Math.random() * names.size())));
    }
}
