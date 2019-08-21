package Handler.Blacksmith;

import Character.Player;
import Handler.Handler;
import Item.*;
import Rarity.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlacksmithHandler extends Handler {

    private ForgeEquipmentHandler forge;

    public BlacksmithHandler(Player player, ForgeEquipmentHandler forge) {
        //items at the blacksmith have to be generated
        generateItems(player);
        //append the ForgeEquipmentHandler as an attribute
        this.forge = forge;
        //synchronize items with the ForgeEquipmentHandler
        this.forge.setItems(getItems());
    }

    BlacksmithHandler() {

    }

    @Override
    public void initializeOptions() {
        getOptions().put("forge equipment", 1);
        getOptions().put("forge", 1);
        getOptions().put("1", 1);
        getOptions().put("sell equipment", 2);
        getOptions().put("sell", 2);
        getOptions().put("2", 2);
        getOptions().put("upgrade equipment", 3);
        getOptions().put("upgrade", 3);
        getOptions().put("3", 3);
        getOptions().put("buy flasks", 4);
        getOptions().put("buy", 4);
        getOptions().put("flasks", 4);
        getOptions().put("4", 4);
        getOptions().put("return to the hometown", 5);
        getOptions().put("return", 5);
        getOptions().put("hometown", 5);
        getOptions().put("5", 5);
    }

    @Override
    public void handleInput(String input, Player player) {

        int result = matches(input);

        if (result == 0) {
            noMatchRoutine(input, player);
            return;
        }
        //here are the different handles of the numbers
        switch (result) {
            case 1:
                //the player decides to buy equipment
                getWalk().move(player, "forgeequipment");
                break;
            case 2:
                //the player decides to sell equipment
                getWalk().move(player, "sellequipment");
                break;
            case 3:
                //the player decides to upgrade equipment
                getWalk().move(player, "upgradeequipment");
                break;
            case 4:
                getWalk().move(player, "buyflask");
                break;
            case 5:
                //the player decides to move to the hometown
                getWalk().move(player, "hometown");
                break;
        }
    }

    /**
     * generate new getItems() in the blacksmith
     *
     * @param player is the player-object
     */
    void generateItems(Player player) {
        //first clear all occurrences in the ArrayList
        getItems().clear();
        //we always use the same rarities so we can put it in an array to reuse it in the for-loop
        Rarity[] rarities = {new Normal("normal"), new Magical("magical"), new Rare("rare"),
                new Unique("unique")};
        //every item is offered in all rarities
        for (Rarity rarity : rarities) {
            //add new amulets
            getItems().add(new Amulet("amulet", rarity, player));
            //add new body armours
            getItems().add(new BodyArmour("bodyarmour", rarity, player));
            //add new boots
            getItems().add(new Boots("boots", rarity, player));
            //add new gloves
            getItems().add(new Gloves("gloves", rarity, player));
            //add new helmets
            getItems().add(new Helmet("helmet", rarity, player));
            //add new rings
            getItems().add(new Rings("rings", rarity, player));
            //add new weapons
            getItems().add(new Weapon("weapon", rarity, player));
        }
    }

}
