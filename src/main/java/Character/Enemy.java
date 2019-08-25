package Character;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
@Setter
public abstract class Enemy extends Character {
    //pool of names the enemy can have
    private HashMap<Integer, String> names;
    //loot of the enemy
    private ArrayList<String> loot = new ArrayList<>();
    //amount of the loot the enemy will drop at his death
    private ArrayList<Integer> lootAmount = new ArrayList<>();

    protected Enemy() {
        initializeNames();
        this.loot.add("");
        initializeLoot();
        initializeLootAmount();
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
     * initialize the loot of the specific races
     */
    protected abstract void initializeLoot();

    /**
     * initialize the amount of the specific drops
     */
    protected abstract void initializeLootAmount();

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
    public void drop(Player player) {
        for (int i = 1; i < getLoot().size(); i++) {
            if (getLoot().get(i).equals("token"))
                player.addToken(getLootAmount().get(i - 1));
            else
                player.addMaterial(getLoot().get(i), getLootAmount().get(i - 1));
        }
        dropText(getLoot(), getLootAmount());
    }

    private void dropText(ArrayList<String> items, ArrayList<Integer> amount) {
        System.out.println("================================");
        System.out.println("drops:");
        for (int i = 1; i < items.size(); i++) {
            System.out.println(amount.get(i - 1) + "x " + items.get(i));
        }
        System.out.println("================================");
    }


}
