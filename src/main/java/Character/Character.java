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

    Character(int lvl){
        this.hp *= lvl;
        this.atk *= lvl;
        this.armor *= lvl;
        this.mResistance *= lvl;
        this.dex *= lvl;
        this.lvl = lvl;
    }

}
