package Item;

import Character.Character;
import Character.Player;
import Rarity.Rarity;

public class Rings extends Item {

    public Rings(String name, Rarity rarity, Player player) {
        super(name, rarity, player);
    }

    @Override
    protected void selfDestroy(Character character) {
        character.setRings(null);
    }
}
