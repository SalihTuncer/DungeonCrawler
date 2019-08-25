package Handler.Blacksmith;

import Character.Player;
import Item.*;

import java.util.regex.Pattern;

public class ForgeEquipmentHandler extends BlacksmithHandler {

    public ForgeEquipmentHandler() {

    }

    @Override
    public void initializeOptions() {
        getOptions().put("1", 1);
        getOptions().put("forge an amulet", 1);
        getOptions().put("amulet", 1);
        getOptions().put("2", 2);
        getOptions().put("forge a body armour", 2);
        getOptions().put("body armour", 2);
        getOptions().put("3", 3);
        getOptions().put("forge boots", 3);
        getOptions().put("boots", 3);
        getOptions().put("4", 4);
        getOptions().put("forge gloves", 4);
        getOptions().put("gloves", 4);
        getOptions().put("5", 5);
        getOptions().put("forge a helmet", 5);
        getOptions().put("helmet", 5);
        getOptions().put("6", 6);
        getOptions().put("forge rings", 6);
        getOptions().put("rings", 6);
        getOptions().put("7", 7);
        getOptions().put("forge a weapon", 7);
        getOptions().put("weapon", 7);
        getOptions().put("8", 8);
        getOptions().put("add new items to the blacksmith", 8);
        getOptions().put("add new items", 8);
        getOptions().put("new items", 8);
        getOptions().put("9", 9);
        getOptions().put("return", 9);
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
                forgeEquipment(player, "amulet");
                break;
            case 2:
                forgeEquipment(player, "bodyarmour");
                break;
            case 3:
                forgeEquipment(player, "boots");
                break;
            case 4:
                forgeEquipment(player, "gloves");
                break;
            case 5:
                forgeEquipment(player, "helmet");
                break;
            case 6:
                forgeEquipment(player, "rings");
            case 7:
                forgeEquipment(player, "weapon");
                break;
            case 8:
                clear();
                if (!enoughTokens(player, player.getLvl())) {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ignored) {
                    }
                    getWalk().move(player, "forgeequipment");
                    break;
                }
                //generate new items at the blacksmith
                generateItems(player);
                //at the end synchronize items with the BlacksmithHandler
                getForge().setItems(getItems());
                System.out.println("New items were successfully added to the blacksmith.\n");
                //at the end the blacksmith is called again
                getWalk().move(player, "forgeequipment");
                break;
            case 9:
                clear();
                //at the end the blacksmith is called again
                player.findLocationByName("blacksmith").getText().decision(player);
                break;
        }
    }

    /**
     * lists all specific items in the blacksmith the player has chosen with different rarities
     *
     * @param player is the player-object
     * @param item   is the specific item-type
     */
    private void forgeEquipment(Player player, String item) {
        clear();
        Item[] options = new Item[4];
        //shows the option number of the weapon
        int opt = 0;
        for (int i = 0; i < getItems().size(); i++) {
            if (getItems().get(i).getName().equals(item)) {
                //save the options so we can ask the player which one he wants
                options[opt] = getItems().get(i);
                //print rarity and name of the item
                System.out.print((opt + 1) + "." + getItems().get(i).getRarity().getName() + " "
                        + getItems().get(i).getName() + ":");
                //just show the stats each item gives
                if (getItems().get(i).getHp() > 0)
                    System.out.print(" HP +" + getItems().get(i).getHp());
                if (getItems().get(i).getAtk() > 0)
                    System.out.print(" ATK +" + getItems().get(i).getAtk());
                if (getItems().get(i).getArmor() > 0)
                    System.out.print(" ARMOR +" + getItems().get(i).getArmor());
                if (getItems().get(i).getMResistance() > 0)
                    System.out.print(" MRESIST +" + getItems().get(i).getMResistance());
                if (getItems().get(i).getDex() > 0)
                    System.out.print(" DEX +" + getItems().get(i).getDex());
                //the cost has to be printed at the end
                System.out.print(" COST: " + getItems().get(i).getCost() + "\n");
                opt++;
            }
        }
        System.out.print("Which item do you wanna forge?: ");
        //search for the item the player wants to forge
        whichItem(player, getInput().nextLine().toLowerCase(), options);
        //at the end the blacksmith is called again
        player.findLocationByName("blacksmith").getText().decision(player);
    }

    /**
     * processes the item-decision of the player
     *
     * @param player   is the player-object
     * @param decision is the decision of the player
     * @param options  are the options where the player has to choose
     */
    private void whichItem(Player player, String decision, Item[] options) {
        //should the player enter a invalid option, he will be asked again
        if (!Pattern.matches("1|2|3|4|normal|magical|rare|unique", decision)) {
            System.out.print("Pls give a valid option: ");
            whichItem(player, getInput().nextLine().toLowerCase(), options);
            return;
        }

        if (decision.equals("1") | decision.equals("normal")) {

            if (enoughTokens(player, options[0].getCost()))
                equipItem(player, options[0]);

        } else if (decision.equals("2") | decision.equals("magical")) {

            if (enoughTokens(player, options[1].getCost()))
                equipItem(player, options[1]);

        } else if (decision.equals("3") | decision.equals("rare")) {

            if (enoughTokens(player, options[2].getCost()))
                equipItem(player, options[2]);

        } else if (decision.equals("4") | decision.equals("unique")) {

            if (enoughTokens(player, options[3].getCost()))
                equipItem(player, options[3]);
        }
    }

    /**
     * equip the specific item to the specific item-slot of the player
     *
     * @param player is the player-object
     * @param option is the item which is equipped
     */
    private void equipItem(Player player, Item option) {
        switch (option.getName()) {
            case "amulet":
                player.setAmulet((Amulet) option);
                break;
            case "bodyarmour":
                player.setBodyArmour((BodyArmour) option);
                break;
            case "boots":
                player.setBoots((Boots) option);
                break;
            case "gloves":
                player.setGloves((Gloves) option);
                break;
            case "helmet":
                player.setHelmet((Helmet) option);
                break;
            case "rings":
                player.setRings((Rings) option);
                break;
            case "weapon":
                player.setWeapon((Weapon) option);
                break;
        }
    }

}
