package Character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Character {

    //basic attributes of the Characters in the game
    private String name;
    private int hp;
    private int atk;
    private int armor;
    private int mResistance;
    private int dex;
    private int lvl;
    private int xp;

    Character(int lvl) {
        newStats(lvl);
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public boolean isReadyToLevelUp() {
        return this.xp >= lvl * 3;
    }

    /**
     * output of the general stats for the specific object
     */
    public void printStats(Character character) {
        System.out.println("================================");
        System.out.println("Name: " + character.getName());
        System.out.println("Health: " + character.getHp());
        System.out.println("Attack: " + character.getAtk());
        System.out.println("Armor: " + character.getArmor());
        System.out.println("MgcRes: " + character.getMResistance());
        System.out.println("Dex: " + character.getDex());
        System.out.println("Lvl: " + character.getLvl());
        System.out.println("XP: " + character.getXp());
        System.out.println("================================\n");
    }

    /**
     * all the attributes are given as a String-Array
     *
     * @return the attributes
     */
    public String[] getAllAttributes() {
        return new String[]{getName(), Integer.toString(getHp()), Integer.toString(getAtk()),
                Integer.toString(getArmor()), Integer.toString(getMResistance()), Integer.toString(getDex()),
                Integer.toString(getLvl()), Integer.toString(getXp())};
    }

    /**
     * this method gives the character new stats depending on the object
     * it is used when an Character-object is initialized or when it gets a level up
     *
     * @param lvl is the lvl which influences the stats generated
     */
    public abstract void newStats(int lvl);
}
