package Character;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public abstract class Enemy extends Character {

    private HashMap<Integer, String> names;

    protected Enemy() {
        initializeNames();
    }

    /**
     * TODO: Every race should have his own specific stats. Actual newStats would be protected abstract than
     * Stats are randomly chosen between an interval.
     *
     * @param lvl is the lvl which influences the stats generated
     */
    @Override
    public void newStats(int lvl) {
        //the enemy has more bad values than the player because the player needs to play against multiple enemy in time
        setHp(getHp() + (int) (Math.random() * 3 + 6));
        setAtk(getAtk() + (int) (Math.random() * 2 + 1));
        setArmor(getArmor() + (int) (Math.random() * 2 + 1));
        setMResistance(getMResistance() + (int) (Math.random() * 2 + 1));
        setDex(getDex() + (int) (Math.random() * 2 + 1));
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

    /**
     * Names begin with the name of the race and afterwards continues with a title. These title is selected randomly
     * of a pool of names.
     */
    protected void generateName() {
        setName(getName() + "-" + getNames().get((int) (Math.random() * getNames().size())));
    }

    /**
     * Every enemy drops his own specific loot(e.g. token, items, materials etc.)
     *
     * @param player is the player-object
     */
    public abstract void drop(Player player);
}
