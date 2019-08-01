package Text;

import Character.Player;
import Handler.DungeonHandler;

public class DungeonText extends Text {

    public DungeonText(Player player) {
        super(player);
    }

    public void printText(Player player) {
        System.out.println("\nYou entered the deep of the dungeon!");
        System.out.println("You have the following options:");
        System.out.println("1.Fight");
        System.out.println("2.Escape to the hometown.");
        System.out.print("Which option do you choose?: ");
        //now the handler is processing the input of the player
        this.handler = new DungeonHandler(getInput().nextLine().toLowerCase(), player);
    }
}
