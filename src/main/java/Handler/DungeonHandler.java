package Handler;

import Character.Player;

public class DungeonHandler extends Handler {

    public DungeonHandler() {

    }

    @Override
    public void initializeOptions() {
        getOptions().put("fight", 1);
        getOptions().put("1", 1);
        getOptions().put("auto-combat", 2);
        getOptions().put("autocombat", 2);
        getOptions().put("auto", 2);
        getOptions().put("2", 2);
        getOptions().put("open backpack", 3);
        getOptions().put("backpack", 3);
        getOptions().put("open", 3);
        getOptions().put("3", 3);
        getOptions().put("escape", 4);
        getOptions().put("escape to the hometown", 4);
        getOptions().put("4", 4);
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
                getAttack().fight(player);
                getAttack().consequences(player);
                //handleInput(new Scanner(System.in).nextLine().toLowerCase(), player);
                player.findLocationByName("dungeon").getText().decision(player);
                break;
            case 2:
                clear();
                getAttack().autoCombat(player);
                getAttack().consequences(player);
                player.findLocationByName("dungeon").getText().decision(player);
                break;
            case 3:
                clear();
                getWalk().move(player, "backpack");
                player.findLocationByName("dungeon").getText().decision(player);
                break;
            case 4:
                //the player decides to move to the hometown
                getWalk().move(player, "hometown");
                break;
        }
    }

}
