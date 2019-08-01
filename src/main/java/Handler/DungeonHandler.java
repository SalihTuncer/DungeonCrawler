package Handler;

import Character.Player;

import java.util.Scanner;

public class DungeonHandler extends Handler {

    public DungeonHandler(String input, Player player) {
        super(input, player);
    }

    public void initializeOptions() {
        getOptions().put("fight", 1);
        getOptions().put("1", 1);
        getOptions().put("escape", 2);
        getOptions().put("2", 2);
    }

    public void handleInput(String input, Player player) {

        int result = matches(input);

        if (result == 0) {
            noMatchRoutine(input, player);
            return;
        }
        //here are the different handles of the numbers
        switch (result) {
            case 1:
                System.out.println("fighting system not implemented yet");
                //recursion: ask again for new valid input
                handleInput(new Scanner(System.in).nextLine().toLowerCase(), player);
                break;
            case 2:
                this.walk.move(player, "hometown");
                break;
        }
    }

}
