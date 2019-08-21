package Item;

import Character.Character;
import Character.Player;
import Rarity.Rarity;

public class Amulet extends Item {

    public Amulet(String name, Rarity rarity, Player player) {
        super(name, rarity, player);
    }

    @Override
    protected void selfDestroy(Character character) {
        character.setAmulet(null);
    }

}
