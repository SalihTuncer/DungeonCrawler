package Text;

import Character.Player;
import Handler.DungeonHandler;

public class DungeonText extends Text {

    public DungeonText() {
        this.handler = new DungeonHandler();
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
        System.out.println("2.Auto-combat");
        System.out.println("3.Escape to the hometown.");
        System.out.print("Which option do you choose?: ");
        //now the handler is processing the input of the player
        this.handler.handleInput(getInput().nextLine().toLowerCase(), player);
    }
}
