package Text;

import Character.Player;
import Handler.Handler;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public abstract class Text {

    //user input while in a location
    private Scanner input = new Scanner(System.in);
    //every text has its own handler
    Handler handler;

    public Text() {

    }

    public abstract void printText(Player player);

    public abstract void decision(Player player);

    /**
     * clears the terminal completely
     * it is used when the user give has a valid action
     */
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
