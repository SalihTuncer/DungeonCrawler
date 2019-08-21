package Handler.Blacksmith;

import Character.Player;

public class UpgradeEquipmentHandler extends BlacksmithHandler {

    public UpgradeEquipmentHandler() {

    }

    @Override
    public void initializeOptions() {
        getOptions().put("1", 1);
        getOptions().put("upgrade amulet", 1);
        getOptions().put("amulet", 1);
        getOptions().put("2", 2);
        getOptions().put("upgrade body armour", 2);
        getOptions().put("body armour", 2);
        getOptions().put("3", 3);
        getOptions().put("upgrade boots", 3);
        getOptions().put("boots", 3);
        getOptions().put("4", 4);
        getOptions().put("upgrade gloves", 4);
        getOptions().put("gloves", 4);
        getOptions().put("5", 5);
        getOptions().put("upgrade helmet", 5);
        getOptions().put("helmet", 5);
        getOptions().put("6", 6);
        getOptions().put("upgrade rings", 6);
        getOptions().put("rings", 6);
        getOptions().put("7", 7);
        getOptions().put("upgrade weapon", 7);
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
        //TODO: equipments should be upgradable
        //here are the different handles of the numbers
        switch (result) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
        }
        //at the end the blacksmith is called again
        player.findLocationByName("blacksmith").getText().decision(player);
    }
}
