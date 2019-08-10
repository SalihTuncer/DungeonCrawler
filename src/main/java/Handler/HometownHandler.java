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
        //calling the settings
        getOptions().put("settings", 2);
        getOptions().put("2", 2);

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
                this.walk.move(player, "dungeon");
                break;
            case 2:
                //the player calls the settings
                this.walk.move(player, "settings");
                //and hometown decision needs to be called
                player.findLocationByName("hometown").getText().decision(player);
                break;
        }
    }

}
