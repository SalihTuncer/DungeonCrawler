package Handler;

import Character.Enemy;
import Character.Player;
import Exception.LocationNotFoundException;
import Location.Dungeon;

import java.util.Scanner;

public class TownHandler extends Handler {

    public TownHandler(String input, Player player) {
        super(input, player);
    }

    @Override
    protected void initializeOptions() {
        //entering the dungeon
        getOptions().put("dungeon", 1);
        getOptions().put("1", 1);
        getOptions().put("enter the dungeon", 1);
        getOptions().put("settings", 2);
        getOptions().put("2", 2);

    }

    @Override
    protected void handleInput(String input, Player player) {

        int result = matches(input);
        if (result == 0)
            try {
                throw new LocationNotFoundException(input);
            } catch (LocationNotFoundException e) {
                //if the location is wrong, the exception is printed and the user needs to renew the input
                e.printStackTrace();
                System.out.print("Choose a valid option pls:");
                new TownHandler(new Scanner(System.in).nextLine().toLowerCase(), player);
                return;
            }
        //here are the different handles of the numbers
        if (result == 1) {
            player.setLocation(new Dungeon("dungeon", player));
        }
    }

    @Override
    protected void handleInput(String input, Player player, Enemy enemy) {
    }

}
