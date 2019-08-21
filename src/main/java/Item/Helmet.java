package Item;

import Character.Character;
import Character.Player;
import Rarity.Rarity;

public class Helmet extends Item {

    public Helmet(String name, Rarity rarity, Player player) {
        super(name, rarity, player);
    }

    @Override
    protected void selfDestroy(Character character) {
        character.setHelmet(null);
    }
}
