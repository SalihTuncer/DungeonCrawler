package Handler;

import Character.Player;

public class HometownHandler extends Handler {

    public HometownHandler() {

    }

    @Override
    public void initializeOptions() {
        //entering the dungeon
        getOptions().put("dungeon", 1);
        getOptions().put("1", 1);
        getOptions().put("enter the dungeon", 1);
        //visiting the blacksmith
        getOptions().put("visit the blacksmith", 2);
        getOptions().put("visit", 2);
        getOptions().put("blacksmith", 2);
        getOptions().put("2", 2);
        //calling the settings
        getOptions().put("settings", 3);
        getOptions().put("3", 3);

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
                //the player walks to the dungeon
                getWalk().move(player, "dungeon");
                break;
            case 2:
                //the player walks to the blacksmith
                getWalk().move(player, "blacksmith");
                break;
            case 3:
                //the player calls the settings
                getWalk().move(player, "settings");
                //and hometown decision needs to be called
                player.findLocationByName("hometown").getText().decision(player);
                break;
        }
    }

}
