package Character;

import Location.Dungeon;
import Location.Hometown;
import Location.Location;
import Location.Settings;
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

    public Player(int lvl) {
        super(lvl);
        //locations get initialized
        initializeLocations();
    }

    private void initializeLocations() {
        this.locations = new HashSet<Location>();
        this.locations.add(new Hometown("hometown", this));
        this.locations.add(new Dungeon("dungeon", this));
        this.locations.add(new Settings("settings", this));
    }

    public void generateEnemy(int lvl) {
        this.enemy = new Enemy(lvl);
    }

    @Override
    public void newStats(int lvl) {
        //in general the player has a little bit better stats than the enemy
        setHp(lvl * 10);
        setAtk(lvl * 4);
        setArmor(lvl * 2);
        setMResistance(lvl);
        setDex(lvl * 2);
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

}
