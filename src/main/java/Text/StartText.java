package Text;

import Character.Player;
import Exception.NotAllowedNameException;

import java.util.regex.Pattern;

public class StartText extends Text {

    public StartText() {

    }

    @Override
    public void printText(Player player) {
        clear();
        System.out.println("Welcome to the world of Dungeon Crawler!");
        //now the player is asked for the name of the player
        System.out.print("What is your name?: ");
        checkName(player);
    }

    /**
     * checks whether the name of the player is valid to the given regex
     *
     * @param player is the Player-Object
     */
    private void checkName(Player player) {
        //the name which is asked for, is given as an attribute for the player
        player.setName(getInput().nextLine());
        try {
            //lowercase, uppercase and whitespaces are accepted
            if (!Pattern.matches("[a-zA-Z\\s]*", player.getName()))
                throw new NotAllowedNameException(player.getName());
        } catch (NotAllowedNameException e) {
            System.out.println("Lowercase, uppercase, commas and whitespaces are accepted");
            System.out.print("Choose a valid name pls: ");
            checkName(player);
            return;
        }
        System.out.println("\n" + player.getName() + ", I will take you to the hometown.");
    }

    @Override
    public void decision(Player player) {
        System.out.println();
    }
}
