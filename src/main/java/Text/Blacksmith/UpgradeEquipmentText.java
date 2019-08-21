package Text.Blacksmith;

import Character.Player;
import Handler.Blacksmith.UpgradeEquipmentHandler;
import Text.Text;

public class UpgradeEquipmentText extends Text {

    public UpgradeEquipmentText() {
        setHandler(new UpgradeEquipmentHandler());
    }

    @Override
    public void printText(Player player) {
        clear();
        decision(player);
    }

    @Override
    public void decision(Player player) {
        System.out.println("1.Upgrade amulet\n2.Upgrade body armour\n3.Upgrade boots\n4.Upgrade gloves\n5.Upgrade helmet");
        System.out.println("6.Upgrade rings\n7.Upgrade weapon\n8.Return");
        System.out.print("Which option do you choose?: ");
        //now the handler is processing the input of the player
        getHandler().handleInput(getInput().nextLine().toLowerCase(), player);
    }
}
