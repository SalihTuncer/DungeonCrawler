package Text;

import Character.Player;
import Handler.SettingsHandler;

public class SettingsText extends Text {

    public SettingsText() {
        this.handler = new SettingsHandler();
    }

    @Override
    public void printText(Player player) {
        clear();
        System.out.println("You are now in the settings:");
        decision(player);
    }

    @Override
    public void decision(Player player) {
        System.out.println("You have the following options:");
        System.out.println("1.Stats of the player");
        System.out.println("2.Stats of the current enemy");
        System.out.println("3.Save game");
        System.out.println("4.Load game");
        System.out.println("5.Quit game");
        System.out.print("Which option do you choose?: ");
        this.handler.handleInput(getInput().nextLine().toLowerCase(), player);
    }
}