package Character;

import Character.Race.*;
import Location.*;
import Location.Blacksmith.*;
import Material.BloodStone;
import Material.FireStone;
import Material.FlyStone;
import Material.Material;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Player extends Character {
    //enemy is an attribute so we can ask everywhere for the information
    private Enemy enemy;
    //includes all locations which is important to access locations everywhere for traveling
    private ArrayList<Location> locations;
    //includes all races
    private ArrayList<Race> races;
    //is the currency
    private int tokens;
    //includes all materials
    private ArrayList<Material> materials;

    public Player() {
        super();
        //the player starts with no tokens
        this.tokens = 0;
        //races get initialized
        initializeRaces();
        //materials get initialized
        initializeMaterials();
        //locations get initialized
        initializeLocations();
    }

    /**
     * add all available locations to the HashSet
     */
    private void initializeLocations() {
        this.locations = new ArrayList<Location>();
        this.locations.add(new Hometown("hometown"));
        this.locations.add(new Dungeon("dungeon", this));
        this.locations.add(new Settings("settings"));
        this.locations.add(new Backpack("backpack"));
        this.locations.add(new ForgeEquipment("forgeequipment"));
        this.locations.add(new SellEquipment("sellequipment"));
        this.locations.add(new UpgradeEquipment("upgradeequipment"));
        this.locations.add(new BuyFlask("buyflask"));
        this.locations.add(new Blacksmith("blacksmith", this));
    }

    /**
     * add all available races into the HashSet
     */
    private void initializeRaces() {
        races = new ArrayList<>();
        races.add(new Orc("orc"));
        races.add(new Golem("golem"));
        races.add(new Vampire("vampire"));
        races.add(new Goblin("goblin"));
        races.add(new Undead("undead"));
        races.add(new Troll("troll"));
        races.add(new Demon("demon"));
    }

    private void initializeMaterials() {
        materials = new ArrayList<>();
        materials.add(new FireStone("firestone"));
        materials.add(new BloodStone("bloodstone"));
        materials.add(new FlyStone("flystone"));
    }

    @Override
    public void generateStats(int lvl) {
        newStats(lvl, 10, 4, 2, 2, 2);
    }

    /**
     * generate an enemy and level him up until he reaches the player level
     */
    public void generateEnemy() {
        //is the index of the race we wanna have
        int search = (int) (Math.random() * races.size());
        int counter = 0;
        //we iterate through the races until we find the race we search
        for (Race race : races) {
            if (search == counter) {
                this.enemy = race;
            }
            counter++;
        }
        //we start at level 2 because we instantiate it already with level 1 and level him up multiple times
        for (int i = 2; i <= getLvl(); i++) {
            this.enemy.generateStats(i);
        }
    }

    public Location findLocationByName(String name) {
        //final AtomicReference<Location> location = new AtomicReference<>();
        //iterate through locations until we find the one with the name of the input
        for (Location location : locations) {
            if (location.getName().equals(name))
                return location;
        }
        return locations.iterator().next();
    }

    public Material findMaterialByName(String name) {
        //iterate through materials until we find the one with the name of the input
        for (Material material : materials) {
            if (material.getName().equals(name))
                return material;
        }
        return materials.iterator().next();
    }

    public void addMaterial(String name) {
        //we iterate through the materials until we find the one with the name of the input
        for (Material material : materials) {
            if (material.getName().equals(name)) {
                //now we add the amount depending on the level of the current enemy
                material.addAmount(this.enemy.getLvl());
                return;
            }
        }
    }

    public void addToken(int value) {
        this.tokens += value;
    }

    public void useToken(int cost) {
        this.tokens -= cost;
    }
}
