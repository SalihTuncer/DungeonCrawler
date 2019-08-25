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
        playerInterface(player);
        System.out.println("You entered the deep of the dungeon!");
        decision(player);
    }

    @Override
    public void decision(Player player) {
        System.out.println("You have the following options:");
        System.out.println("1.Fight\n2.Auto-combat\n3.Open backpack\n4.Escape to the hometown");
        System.out.print("Which option do you choose?: ");
        //now the handler is processing the input of the player
        this.handler.handleInput(getInput().nextLine().toLowerCase(), player);
    }
}
