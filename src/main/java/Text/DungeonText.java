package Text;

import Character.Player;
import Handler.DungeonHandler;

public class DungeonText extends Text {

    public DungeonText(Player player) {
        super(player);
    }

    @Override
    public void printText(Player player) {
        clear();
        System.out.println("You entered the deep of the dungeon!");
        decision(player);
    }

    public void decision(Player player) {
        System.out.println("You have the following options:");
        System.out.println("1.Fight");
        System.out.println("2.Escape to the hometown.");
        System.out.print("Which option do you choose?: ");
        //now the handler is processing the input of the player
        this.handler = new DungeonHandler(getInput().nextLine().toLowerCase(), player);
    }
}
