package Item;

import Character.Character;
import Character.Player;
import Rarity.Rarity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Item {
    //item information
    private String name;
    private Rarity rarity;
    private int lvl;
    private int value;
    private int cost;
    //item specific stats
    private int hp;
    private int atk;
    private int armor;
    private int mResistance;
    private int dex;

    Item(String name, Rarity rarity, Player player) {
        this.name = name;
        this.lvl = player.getLvl();
        this.rarity = rarity;
        //set specific value of the item
        setSpecificValue(rarity, player);
        //set item cost at the blacksmith
        this.cost = 2 * this.value;
        //generate item specific stats
        generateStats();
    }

    /**
     * The stats of the items will be generated completely random
     */
    private void generateStats() {
        switch (getRarity().getName()) {
            case "normal":
                setRNGStat(1);
                break;
            case "magical":
                setRNGStat(2);
                break;
            case "rare":
                setRNGStat(3);
                break;
            case "unique":
                setRNGStat(4);
                break;
        }

    }

    private void setRNGStat(int ctr) {

        switch ((int) (Math.random() * 5)) {
            case 0:
                setHp(getHp() + this.lvl);
                break;
            case 1:
                setAtk(getAtk() + this.lvl);
                break;
            case 2:
                setArmor(getArmor() + this.lvl);
                break;
            case 3:
                setMResistance(getMResistance() + this.lvl);
                break;
            case 4:
                setDex(getDex() + this.lvl);
                break;
        }
        //we generate as often random stats as the counter variable ctr
        ctr--;
        if (ctr != 0)
            setRNGStat(ctr);

    }

    private void setSpecificValue(Rarity rarity, Player player) {
        switch (rarity.getName()) {
            case "normal":
                setValue(player.getLvl());
                break;
            case "magical":
                setValue(2 * player.getLvl());
                break;
            case "rare":
                setValue(4 * player.getLvl());
                break;
            case "unique":
                setValue(8 * player.getLvl());
                break;
        }
    }

    public void sellItem(Character character) {
        //destroy the item
        destroyItem(character);
        //add tokens to player as much of the value of the item
        assert character instanceof Player;
        ((Player) character).addToken(this.value);
    }

    private void destroyItem(Character character) {
        //unequip the item
        unEquipItem(character);
        //at the end set the item = null
        selfDestroy(character);
    }

    protected abstract void selfDestroy(Character character);

    public void equipItem(Character character) {
        //here you should add the stats of the item on the stats of the player
        character.addToAllAttributes(this.hp, this.atk, this.armor, this.mResistance, this.dex);
    }

    private void unEquipItem(Character character) {
        //here the player should remove the stats which gives the item from his own stats
        character.reduceFromAllAttributes(this.hp, this.atk, this.armor, this.mResistance, this.dex);
    }
}
