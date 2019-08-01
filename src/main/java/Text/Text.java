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

    Text(Player player){
        //printText(player);
    }

    public abstract void printText(Player player);
}
