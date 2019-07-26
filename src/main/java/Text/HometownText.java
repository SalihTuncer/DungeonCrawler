package Text;

import Character.Player;

public class HometownText extends Text {

    public HometownText(Player player) {
        super(player);
    }

    @Override
    protected void printText(Player player){
        System.out.println("Welcome to the hometown.");
        System.out.println("You have the following options:");
        System.out.println("1.Enter the dungeon");
        System.out.println("2.");
    }
}
