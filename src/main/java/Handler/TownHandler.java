package Handler;

import Character.Player;

public class TownHandler extends Handler {

    public TownHandler(String input, Player player) {
        super(input, player);
    }

    public void initializeOptions() {
        //entering the dungeon
        getOptions().put("dungeon", 1);
        getOptions().put("1", 1);
        getOptions().put("enter the dungeon", 1);
        getOptions().put("settings", 2);
        getOptions().put("2", 2);

    }

    public void handleInput(String input, Player player) {

        int result = matches(input);
        if (result == 0) {
            noMatchRoutine(input, player);
            return;
        }
        //here are the different handles of the numbers
        switch (result) {
            case 1:
                this.walk.move(player, "dungeon");
                break;
        }
    }

}
