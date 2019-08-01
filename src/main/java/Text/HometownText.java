package Text;

import Character.Player;
import Handler.TownHandler;

public class HometownText extends Text {

    public HometownText(Player player) {
        super(player);
    }

    public void printText(Player player) {
        System.out.println("\nWelcome to the hometown.");
        System.out.println("You have the following options:");
        System.out.println("1.Enter the dungeon");
        //System.out.println("2.Settings");
        System.out.print("Which option do you choose?: ");
        //now the handler is processing the input of the player
        this.handler = new TownHandler(getInput().nextLine().toLowerCase(), player);
    }

}
