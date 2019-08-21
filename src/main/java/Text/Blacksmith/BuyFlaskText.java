package Text.Blacksmith;

import Character.Player;
import Handler.Blacksmith.BuyFlaskHandler;
import Text.Text;

public class BuyFlaskText extends Text {

    public BuyFlaskText() {
        setHandler(new BuyFlaskHandler());
    }

    @Override
    public void printText(Player player) {
        clear();
        decision(player);
    }

    @Override
    public void decision(Player player) {
        System.out.print("Which option do you choose?: ");
        //now the handler is processing the input of the player
        getHandler().handleInput(getInput().nextLine().toLowerCase(), player);
    }
}
