package Handler;

import Character.Player;
import Flask.Flask;

public class BackpackHandler extends Handler {

    public BackpackHandler() {

    }

    @Override
    public void initializeOptions() {
        getOptions().put("healthflask", 1);
        getOptions().put("health", 1);
        getOptions().put("1", 1);
        getOptions().put("killflask", 2);
        getOptions().put("kill", 2);
        getOptions().put("2", 2);
        getOptions().put("rerollflask", 3);
        getOptions().put("reroll", 3);
        getOptions().put("3", 3);
        getOptions().put("return", 4);
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
                //the player decides to use the healthFlask
                flaskRoutine(player.findFlaskByName("healthflask"), player);
                break;
            case 2:
                //the player decides to use the killFlask
                flaskRoutine(player.findFlaskByName("killflask"), player);
                break;
            case 3:
                //the player decides to use the rerollFlask
                flaskRoutine(player.findFlaskByName("rerollflask"), player);
                break;
            case 4:
                clear();
                break;
        }
    }

    /**
     * The flaskRoutine checks whether you can use the flask or not and the ongoing consequences of it.
     *
     * @param flask  is the flask which the player wants to use
     * @param player is the player-object
     */
    private void flaskRoutine(Flask flask, Player player) {
        clear();
        //should the player have the given flask
        if (flask.getAmount() > 0) {
            //he will use it
            if (flask.useFlask(player)) {
                //amount of the flask will be reduced by one
                flask.removeFlask();
                //it will be printed how many flasks of the given kind is left
                flask.flaskAmountText(flask);
                //should the player can not use the flask
            } else
                flask.flaskAmountText(flask);
            //should the player have no more flasks left
        } else
            flask.noFlaskText();
        //player is asked for his decision
        player.findLocationByName("backpack").getText().decision(player);
    }
}
