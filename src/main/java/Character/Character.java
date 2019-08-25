package Character;

import Item.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character implements Cloneable {

    //basic attributes of the Characters in the game
    private String name;
    //health-stat
    private int hp;
    //attack-stat
    private int atk;
    //armor-stat
    private int armor;
    //magic resistance-stat
    private int mResistance;
    //dexterity-stat
    private int dex;
    //level
    private int lvl;
    //experience
    private int xp;
    //equipment of the character;
    private Item[] equipment = new Item[7];

    Character() {
        generateStats(1);
    }

    /**
     * checks whether the character is still alive or not
     *
     * @return true if the character is alive
     */
    public boolean isAlive() {
        return this.hp > 0;
    }

    /**
     * used to clone the object to use it as a  dummy
     * this way is way more efficient than to instantiate a new dummy-object
     *
     * @return a character-object
     * @throws CloneNotSupportedException i mean it is kind of obvious
     */
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * checks whether the character has enough experience to level up
     *
     * @return true if the character is ready to level up
     */
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
     * add parameters to the stats of the character
     *
     * @param hp          health
     * @param atk         attack
     * @param armor       armor
     * @param mResistance magic resistance
     * @param dex         dexterity
     */
    public void addToAllAttributes(int hp, int atk, int armor, int mResistance, int dex) {
        this.hp += hp;
        this.atk += atk;
        this.armor += armor;
        this.mResistance += mResistance;
        this.dex += dex;
    }

    /**
     * reduce parameters from the stats of the character
     *
     * @param hp          health
     * @param atk         attack
     * @param armor       armor
     * @param mResistance magic resistance
     * @param dex         dexterity
     */
    public void reduceFromAllAttributes(int hp, int atk, int armor, int mResistance, int dex) {
        this.hp -= hp;
        this.atk -= atk;
        this.armor -= armor;
        this.mResistance -= mResistance;
        this.dex -= dex;
    }

    /**
     * this method calls new stats with specific stats
     * it is used when an Character-object is initialized or when it gets a level up
     *
     * @param lvl is the level which influences the stats generated
     */
    public abstract void generateStats(int lvl);

    /**
     * this method gives the character new stats depending on the object
     * each parameter is the stat-configuration
     *
     * @param lvl         is the level which influences the stats
     * @param hp          is the health-stat
     * @param atk         is the attack-stat
     * @param armor       is the armor-stat
     * @param mResistance is the magic resistance-stat
     * @param dex         is the dexterity-stat
     */
    public void newStats(int lvl, int hp, int atk, int armor, int mResistance, int dex) {
        //the enemy has more bad values than the player because the player needs to play against multiple enemy in time
        setHp(getHp() + hp);
        setAtk(getAtk() + (int) (Math.random() * atk + 1));
        setArmor(getArmor() + (int) (Math.random() * armor + 1));
        setMResistance(getMResistance() + (int) (Math.random() * mResistance + 1));
        setDex(getDex() + (int) (Math.random() * dex + 1));
        setLvl(lvl);
        setXp(0);
    }

    public Item getAmulet() {
        return this.equipment[0];
    }

    public void setAmulet(Amulet amulet) {
        //should the player already wears an amulet, it will automatically sold and unequipped
        if (!(this.equipment[0] == null)) {
            equipment[0].sellItem(this);
        }
        this.equipment[0] = amulet;
        if (amulet != null)
            amulet.equipItem(this);
    }

    public Item getBodyArmour() {
        return this.equipment[1];
    }

    public void setBodyArmour(BodyArmour bodyArmour) {
        //should the player already wears an amulet, it will automatically sold and unequipped
        if (!(this.equipment[1] == null)) {
            equipment[1].sellItem(this);
        }
        this.equipment[1] = bodyArmour;
        if (bodyArmour != null)
            bodyArmour.equipItem(this);
    }

    public Item getBoots() {
        return this.equipment[2];
    }

    public void setBoots(Boots boots) {
        //should the player already wears an amulet, it will automatically sold and unequipped
        if (!(this.equipment[2] == null)) {
            equipment[2].sellItem(this);
        }
        this.equipment[2] = boots;
        if (boots != null)
            boots.equipItem(this);
    }

    public Item getGloves() {
        return this.equipment[3];
    }

    public void setGloves(Gloves gloves) {
        //should the player already wears an amulet, it will automatically sold and unequipped
        if (!(this.equipment[3] == null)) {
            equipment[3].sellItem(this);
        }
        this.equipment[3] = gloves;
        if (gloves != null)
            gloves.equipItem(this);
    }

    public Item getHelmet() {
        return this.equipment[4];
    }

    public void setHelmet(Helmet helmet) {
        //should the player already wears an amulet, it will automatically sold and unequipped
        if (!(this.equipment[4] == null)) {
            equipment[4].sellItem(this);
        }
        this.equipment[4] = helmet;
        if (helmet != null)
            helmet.equipItem(this);
    }

    public Item getRings() {
        return this.equipment[5];
    }

    public void setRings(Rings rings) {
        //should the player already wears an amulet, it will automatically sold and unequipped
        if (!(this.equipment[5] == null)) {
            equipment[5].sellItem(this);
        }
        this.equipment[5] = rings;
        if (rings != null)
            rings.equipItem(this);
    }

    public Item getWeapon() {
        return this.equipment[6];
    }

    public void setWeapon(Weapon weapon) {
        //should the player already wears an amulet, it will automatically sold and unequipped
        if (!(this.equipment[6] == null)) {
            equipment[6].sellItem(this);
        }
        this.equipment[6] = weapon;
        if (weapon != null)
            weapon.equipItem(this);
    }
}
