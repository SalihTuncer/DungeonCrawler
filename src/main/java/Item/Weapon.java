package Item;

import Character.Character;
import Character.Player;
import Rarity.Rarity;

public class Weapon extends Item {

    public Weapon(String name, Rarity rarity, Player player) {
        super(name, rarity, player);
    }

    @Override
    protected void selfDestroy(Character character) {
        character.setWeapon(null);
    }
}
