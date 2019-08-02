package Handler;

import Character.Player;

public class DungeonHandler extends Handler {

    public DungeonHandler(String input, Player player) {
        super(input, player);
    }

    @Override
    public void initializeOptions() {
        getOptions().put("fight", 1);
        getOptions().put("1", 1);
        getOptions().put("escape", 2);
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
                clear();
                //the player decides to fight in the dungeon
                getCombat().fight(player);
                getCombat().consequences(player);
                //handleInput(new Scanner(System.in).nextLine().toLowerCase(), player);
                player.findLocationByName("dungeon").getText().decision(player);
                break;
            case 2:
                //the player decides to move to the hometown
                this.walk.move(player, "hometown");
                break;
        }
    }

}
