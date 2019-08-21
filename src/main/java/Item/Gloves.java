package Item;

import Character.Character;
import Character.Player;
import Rarity.Rarity;

public class Gloves extends Item {

    public Gloves(String name, Rarity rarity, Player player) {
        super(name, rarity, player);
    }

    @Override
    protected void selfDestroy(Character character) {
        character.setGloves(null);
    }
}
