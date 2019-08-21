package Item;

import Character.Character;
import Character.Player;
import Rarity.Rarity;

public class Boots extends Item {

    public Boots(String name, Rarity rarity, Player player) {
        super(name, rarity, player);
    }

    @Override
    protected void selfDestroy(Character character) {
        character.setBoots(null);
    }
}
