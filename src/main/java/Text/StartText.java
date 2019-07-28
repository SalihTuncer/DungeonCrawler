package Text;

import Character.Player;

public class StartText extends Text {

    public StartText(Player player) {
        super(player);
    }

    @Override
    protected void printText(Player player){
        System.out.println("Welcome to the world of Dungeon Crawler!");
        //now the player is asked for the name of the player
        System.out.print("What is your name?: ");
        //the name which is asked for is given as an attribute for the player
        player.setName(getInput().nextLine());
        System.out.println(player.getName()+", I will take you to the hometown.");
    }

}
