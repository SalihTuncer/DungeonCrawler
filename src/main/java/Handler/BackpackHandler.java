package Handler;

import Character.Player;
import Flask.Flask;
import Flask.HealthFlask;
import Flask.KillFlask;
import Flask.RerollFlask;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;

@Getter
@Setter
public class BackpackHandler extends Handler {

    //includes all flasks
    private HashSet<Flask> flasks;

    public BackpackHandler() {
        //flasks get initialized
        initializeFlasks();
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
        getOptions().put("flask amounts", 4);
        getOptions().put("flaskamounts", 4);
        getOptions().put("amounts", 4);
        getOptions().put("4", 4);
        getOptions().put("return", 5);
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
                //the player decides to use the healthFlask
                flaskRoutine(findFlaskByName("healthflask"), player);
                break;
            case 2:
                //the player decides to use the killFlask
                flaskRoutine(findFlaskByName("killflask"), player);
                break;
            case 3:
                //the player decides to use the rerollFlask
                flaskRoutine(findFlaskByName("rerollflask"), player);
                break;
            case 4:
                clear();
                //the player decides to print the amounts of the flasks
                printFlaskAmounts();
                break;
            case 5:
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

    /**
     * add all available flasks into the HashSet
     */
    private void initializeFlasks() {
        this.flasks = new HashSet<>();
        flasks.add(new HealthFlask("healthflask"));
        flasks.add(new KillFlask("killflask"));
        flasks.add(new RerollFlask("rerollflask"));
    }

    private Flask findFlaskByName(String name) {
        //we are searching for the location with the name of the input
        for (Flask flask : flasks) {
            if (flask.getName().equals(name)) {
                return flask;
            }
        }
        return flasks.iterator().next();
    }

    private void printFlaskAmounts() {
        System.out.println("================================");
        for (Flask flask : flasks) {
            System.out.println(flask.getName() + ": " + flask.getAmount());
        }
        System.out.println("================================");
    }

}
