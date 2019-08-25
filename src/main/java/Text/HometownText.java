package Text;

import Character.Player;
import Handler.HometownHandler;

public class HometownText extends Text {

    public HometownText() {
        this.handler = new HometownHandler();
    }

    @Override
    public void printText(Player player) {
        clear();
        playerInterface(player);
        System.out.println("Welcome to the hometown.");
        decision(player);
    }

    @Override
    public void decision(Player player) {
        System.out.println("You have the following options:");
        System.out.println("1.Enter the dungeon\n2.Visit the blacksmith\n3.Settings");
        System.out.print("Which option do you choose?: ");
        //now the handler is processing the input of the player
        this.handler.handleInput(getInput().nextLine().toLowerCase(), player);
        System.out.println();
    }

}
