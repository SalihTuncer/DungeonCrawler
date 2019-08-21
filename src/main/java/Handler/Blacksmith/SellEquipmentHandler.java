package Handler.Blacksmith;

import Character.Player;

public class SellEquipmentHandler extends BlacksmithHandler {

    public SellEquipmentHandler() {

    }

    @Override
    public void initializeOptions() {
        getOptions().put("1", 1);
        getOptions().put("sell amulet", 1);
        getOptions().put("amulet", 1);
        getOptions().put("2", 2);
        getOptions().put("sell body armour", 2);
        getOptions().put("body armour", 2);
        getOptions().put("3", 3);
        getOptions().put("sell boots", 3);
        getOptions().put("boots", 3);
        getOptions().put("4", 4);
        getOptions().put("sell gloves", 4);
        getOptions().put("gloves", 4);
        getOptions().put("5", 5);
        getOptions().put("sell helmet", 5);
        getOptions().put("helmet", 5);
        getOptions().put("6", 6);
        getOptions().put("sell rings", 6);
        getOptions().put("rings", 6);
        getOptions().put("7", 7);
        getOptions().put("sell weapon", 7);
        getOptions().put("weapon", 7);
        getOptions().put("8", 8);
        getOptions().put("return", 8);
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
                clear();
                if (!(player.getAmulet() == null))
                    player.getAmulet().sellItem(player);
                else
                    System.out.println("You wear no amulet.");
                break;
            case 2:
                clear();
                if (!(player.getBodyArmour() == null))
                    player.getBodyArmour().sellItem(player);
                else
                    System.out.println("You wear no body armour.");
                break;
            case 3:
                clear();
                if (!(player.getBoots() == null))
                    player.getBoots().sellItem(player);
                else
                    System.out.println("You wear no boots.");
                break;
            case 4:
                clear();
                if (!(player.getGloves() == null))
                    player.getGloves().sellItem(player);
                else
                    System.out.println("You wear no gloves.");
                break;
            case 5:
                clear();
                if (!(player.getHelmet() == null))
                    player.getHelmet().sellItem(player);
                else
                    System.out.println("You wear no helmet.");
                break;
            case 6:
                clear();
                if (!(player.getRings() == null))
                    player.getRings().sellItem(player);
                else
                    System.out.println("You wear no rings.");
                break;
            case 7:
                clear();
                if (!(player.getWeapon() == null))
                    player.getWeapon().sellItem(player);
                else
                    System.out.println("You wear no weapon.");
                break;
            case 8:
                clear();
                break;
        }
        //at the end the blacksmith is called again
        player.findLocationByName("blacksmith").getText().decision(player);
    }
}
