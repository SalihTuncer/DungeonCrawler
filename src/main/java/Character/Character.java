package Character;

import Location.Location;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Character {

    //basic attributes of the Characters in the game
    private int hp;
    private int atk;
    private int armor;
    private int mResistance;
    private int dex;
    //additional information about the character
    private Location location;


    Character(int lvl){
        this.hp *= lvl;
        this.atk *= lvl;
        this.armor *= lvl;
        this.mResistance *= lvl;
        this.dex *= lvl;
    }

}
