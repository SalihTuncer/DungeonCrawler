package Handler;

import Character.Player;
import Combat.Attack;
import Exception.LocationNotFoundException;
import Movement.Movement;
import Movement.Walk;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@Setter
public abstract class Handler {
    //used to travel between locations by foot (less overhead)
    Movement walk = new Walk();
    //all valid available options are stored
    private Map<String, Integer> options = new HashMap<>();
    //handles user input
    private Scanner scanner = new Scanner(System.in);
    //combat mechanic as an attribute
    private Attack attack = new Attack();

    Handler() {
        initializeOptions();
    }

    /**
     * initializes the options which are give in the current location
     */
    public abstract void initializeOptions();

    /**
     * handles the user input in the current location because different options are given
     *
     * @param input  user input in the current location
     * @param player player object
     */
    public abstract void handleInput(String input, Player player);

    /**
     * checks if the input matches with the given options in the current location
     *
     * @param input user input in the current location
     * @return the id of the option if the input matches with one. Otherwise it returns zero as an integer.
     */
    int matches(String input) {
        final AtomicReference<Integer> reference = new AtomicReference<>();
        reference.set(0);

        getOptions().forEach((in, id) -> {
            if (in.equals(input))
                reference.set(id);
        });

        return reference.get();
    }

    /**
     * if the input does not match with any given options, the user is asked to renew his input
     *
     * @param input  user input
     * @param player actual player
     */
    void noMatchRoutine(String input, Player player) {
        try {
            throw new LocationNotFoundException(input);
        } catch (LocationNotFoundException e) {
            //if the location is wrong, the exception is called and the user needs to renew the input
            //e.printStackTrace();
            System.out.print("Choose a valid option pls:");
            //recursion: ask again for new valid input
            handleInput(getScanner().nextLine().toLowerCase(), player);
        }
    }

    /**
     * clears the terminal completely
     * it is used when the user give has a valid action
     */
    void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
