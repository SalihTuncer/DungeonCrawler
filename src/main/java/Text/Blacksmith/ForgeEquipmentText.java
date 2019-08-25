package Text.Blacksmith;

import Character.Player;
import Handler.Blacksmith.ForgeEquipmentHandler;
import Text.Text;

public class ForgeEquipmentText extends Text {

    public ForgeEquipmentText() {
        setHandler(new ForgeEquipmentHandler());
    }

    @Override
    public void printText(Player player) {
        clear();
        playerInterface(player);
        decision(player);
    }

    @Override
    public void decision(Player player) {
        System.out.println("1.Forge an amulet\n2.Forge a body armour\n3.Forge boots\n4.Forge gloves\n5.Forge a helmet");
        System.out.println("6.Forge rings\n7.Forge a weapon\n8.Add new items to the blacksmith\n9.Return");
        System.out.print("Which option do you choose?: ");
        //now the handler is processing the input of the player
        getHandler().handleInput(getInput().nextLine().toLowerCase(), player);
    }
}
