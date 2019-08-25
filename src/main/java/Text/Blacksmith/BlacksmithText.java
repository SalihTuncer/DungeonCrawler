package Text.Blacksmith;

import Character.Player;
import Handler.Blacksmith.BlacksmithHandler;
import Handler.Blacksmith.ForgeEquipmentHandler;
import Text.Text;

public class BlacksmithText extends Text {

    public BlacksmithText(Player player) {
        /*we need to give the BlacksmithHandler, a ForgeEquipmentHandler so we search for it and cast
         ForgeEquipmentHandler on the object*/
        setHandler(new BlacksmithHandler(player, (ForgeEquipmentHandler)
                player.findLocationByName("forgeequipment").getText().getHandler()));
    }

    @Override
    public void printText(Player player) {
        clear();
        playerInterface(player);
        System.out.println("You are now at the blacksmith!");
        decision(player);
    }

    @Override
    public void decision(Player player) {
        System.out.println("You have the following options:");
        System.out.println("1.Forge equipment\n2.Sell equipment\n3.Upgrade equipment\n4.Buy flasks");
        System.out.println("5.Return to the hometown");
        System.out.print("Which option do you choose?: ");
        //now the handler is processing the input of the player
        getHandler().handleInput(getInput().nextLine().toLowerCase(), player);
    }
}
