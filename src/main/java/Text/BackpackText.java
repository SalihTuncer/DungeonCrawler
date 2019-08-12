package Text;

import Character.Player;
import Handler.BackpackHandler;

public class BackpackText extends Text {

    public BackpackText() {
        this.handler = new BackpackHandler();
    }

    @Override
    public void printText(Player player) {
        clear();
        System.out.println("Let's have a look what lays in your backpack:");
        decision(player);
    }

    @Override
    public void decision(Player player) {
        System.out.println("1.HealthFlask\n2.KillFlask\n3.RerollFlask\n4.Return");
        System.out.print("Which option do you choose?: ");
        //now the handler is processing the input of the player
        this.handler.handleInput(getInput().nextLine().toLowerCase(), player);
    }
}
