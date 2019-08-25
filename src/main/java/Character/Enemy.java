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

    protected void dropText(String[] items, int[] amount) {
        System.out.println("================================");
        System.out.println("drops:");
        for (int i = 0; i < items.length; i++) {
            System.out.println(amount[i] + "x " + items[i]);
        }
        System.out.println("================================");
    }
}
