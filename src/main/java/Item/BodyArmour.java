package Item;

import Character.Character;
import Character.Player;
import Rarity.Rarity;

public class BodyArmour extends Item {

    public BodyArmour(String name, Rarity rarity, Player player) {
        super(name, rarity, player);
    }

    @Override
    protected void selfDestroy(Character character) {
        character.setBodyArmour(null);
    }
}
