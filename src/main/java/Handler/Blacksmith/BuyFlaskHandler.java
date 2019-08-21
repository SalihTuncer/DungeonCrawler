package Handler.Blacksmith;

import Character.Player;

public class BuyFlaskHandler extends BlacksmithHandler {

    public BuyFlaskHandler() {

    }

    @Override
    public void initializeOptions() {

    }

    @Override
    public void handleInput(String input, Player player) {

        int result = matches(input);

        if (result == 0) {
            noMatchRoutine(input, player);
            return;
        }
        //TODO: flasks should be buyable
        //here are the different handles of the numbers
        switch (result) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
        }
        //at the end the blacksmith is called again
        player.findLocationByName("blacksmith").getText().decision(player);
    }
}
