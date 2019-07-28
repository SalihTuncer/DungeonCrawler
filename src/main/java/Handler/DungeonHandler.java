package Handler;

import Character.Player;
import Exception.LocationNotFoundException;
import Text.HometownText;

import java.util.Scanner;

public class DungeonHandler extends Handler {

    public DungeonHandler(String input, Player player) {
        super(input, player);
    }

    @Override
    protected void initializeOptions() {
        getOptions().put("fight", 1);
        getOptions().put("1", 1);
        getOptions().put("escape", 2);
        getOptions().put("2", 2);
    }

    @Override
    protected void handleInput(String input, Player player) {

        int result = matches(input);

        if (result == 0)
            try {
                throw new LocationNotFoundException(input);
            } catch (LocationNotFoundException e) {
                //if the location is wrong, the exception is printed and the user needs to renew the input
                e.printStackTrace();
                System.out.print("Choose a valid option pls:");
                new DungeonHandler(new Scanner(System.in).nextLine().toLowerCase(), player);
                return;
            }
        //here are the different handles of the numbers
        switch (result) {
            case 1:
                System.out.println("fighting system not implemented yet");
                new DungeonHandler(new Scanner(System.in).nextLine().toLowerCase(), player);
                break;
            case 2:
                new HometownText(player);
                break;
        }
    }

}
