package Handler;

import Character.Enemy;
import Character.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@Setter
public abstract class Handler {

    private Map<String, Integer> options = new HashMap<>();

    Handler(String input, Player player) {
        initializeOptions();
        handleInput(input, player);
    }

    /**
     * initializes the options which are give in the current location
     */
    protected abstract void initializeOptions();

    /**
     * handles the user input in the current location because different options are given
     *
     * @param input  user input in the current location
     * @param player player object
     */
    protected abstract void handleInput(String input, Player player);

    /**
     * in some situations e.g. fights you need the enemy object too
     *
     * @param input  user input in the current location
     * @param player player object
     * @param enemy  enemy object
     */
    protected abstract void handleInput(String input, Player player, Enemy enemy);

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
            System.out.println(in);
            System.out.println(id);
            if (in.equals(input))
                reference.set(id);
        });

        return reference.get();
    }
}
