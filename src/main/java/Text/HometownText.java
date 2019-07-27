package Text;

import Character.Enemy;
import Character.Player;
import Handler.TownHandler;

public class HometownText extends Text {

    public HometownText(Player player) {
        super(player);
        //the user is asked what to do in the hometown
        new TownHandler(getInput().nextLine().toLowerCase(), player);
    }

    @Override
    protected void printText(Player player){
        System.out.println("Welcome to the hometown.");
        System.out.println("You have the following options:");
        System.out.println("1.Enter the dungeon");
        //System.out.println("2.Settings");
    }

    @Override
    protected void printText(Player player, Enemy enemy) {

    }
}
