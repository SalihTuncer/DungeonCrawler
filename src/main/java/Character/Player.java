package Character;

import Flask.Flask;
import Flask.HealthFlask;
import Flask.KillFlask;
import Flask.RerollFlask;
import Location.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@Setter
public class Player extends Character {
    //enemy is an attribute so we can ask everywhere for the information
    private Enemy enemy;
    //includes all locations which is important to access locations everywhere for traveling
    private HashSet<Location> locations;
    //includes all flasks
    private HashSet<Flask> flasks;

    public Player(int lvl) {
        super(lvl);
        //locations get initialized
        initializeLocations();
        //flasks get initialized
        initializeFlasks();
    }

    /**
     * add all available locations to the HashSet
     */
    private void initializeLocations() {
        this.locations = new HashSet<Location>();
        this.locations.add(new Hometown("hometown"));
        this.locations.add(new Dungeon("dungeon", this));
        this.locations.add(new Settings("settings"));
        this.locations.add(new Backpack("backpack"));
    }

    /**
     * add all available flasks into the HashSet
     */
    private void initializeFlasks() {
        this.flasks = new HashSet<>();
        flasks.add(new HealthFlask("healthflask"));
        flasks.add(new KillFlask("killflask"));
        flasks.add(new RerollFlask("rerollflask"));
    }

    /**
     * generate an enemy and level him up until he reaches the player level
     */
    public void generateEnemy() {
        this.enemy = new Enemy(1);
        //we start at level 2 because we instantiate it already with level 1.
        for (int i = 2; i <= getLvl(); i++) {
            this.enemy.newStats(i);
        }
    }

    @Override
    public void newStats(int lvl) {
        //in general the player has a little bit better stats than the enemy
        setHp(getHp() + 10);
        setAtk(getAtk() + (int) (Math.random() * 3 + 2));
        setArmor(getArmor() + (int) (Math.random() * 2 + 1));
        setMResistance(getMResistance() + (int) (Math.random() * 2 + 1));
        setDex(getDex() + (int) (Math.random() * 2 + 1));
        setLvl(lvl);
        setXp(0);
    }

    public Location findLocationByName(String name) {

        final AtomicReference<Location> location = new AtomicReference<>();
        //if something goes wrong, the result location will be the hometown
        location.set(new Hometown("hometown"));

        //we are searching for the location with the name of the input
        this.locations.forEach((i) -> {
            if (i.getName().equals(name))
                location.set(i);
        });

        return location.get();
    }

    public Flask findFlaskByName(String name) {
        final AtomicReference<Flask> flask = new AtomicReference<>();
        //if something goes wrong, the result location will be the hometown
        flask.set(new HealthFlask("healthflask"));

        //we are searching for the location with the name of the input
        this.flasks.forEach((i) -> {
            if (i.getName().equals(name))
                flask.set(i);
        });

        return flask.get();
    }

}
