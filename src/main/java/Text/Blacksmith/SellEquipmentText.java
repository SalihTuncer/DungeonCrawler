package Text.Blacksmith;

import Character.Player;
import Handler.Blacksmith.SellEquipmentHandler;
import Text.Text;

public class SellEquipmentText extends Text {

    public SellEquipmentText() {
        setHandler(new SellEquipmentHandler());
    }

    @Override
    public void printText(Player player) {
        clear();
        decision(player);
    }

    @Override
    public void decision(Player player) {
        System.out.println("1.Sell amulet\n2.Sell body armour\n3.Sell boots\n4.Sell gloves");
        System.out.println("5.Sell helmet\n6.Sell rings\n7.Sell a weapon\n8.Return");
        System.out.print("Which option do you choose?: ");
        //now the handler is processing the input of the player
        getHandler().handleInput(getInput().nextLine().toLowerCase(), player);
    }
}
