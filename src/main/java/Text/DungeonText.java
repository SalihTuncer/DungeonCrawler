package Text;

import Character.Player;
import Handler.DungeonHandler;

public class DungeonText extends Text {

    public DungeonText(Player player) {
        super(player);
        new DungeonHandler(getInput().nextLine().toLowerCase(), player);
    }

    @Override
    protected void printText(Player player) {
        System.out.println("\nYou entered the deep of the dungeon!");
        System.out.println("You have the following options:");
        System.out.println("1.Fight");
        System.out.println("2.Escape to the hometown.");
        System.out.print("Which option do you choose?: ");
    }
}
