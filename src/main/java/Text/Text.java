package Text;

import Character.Player;

import java.util.Scanner;

import Handler.ActionHandler;
import Movement.Movement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Text {

    //user input while in a location
    private Scanner input = new Scanner(System.in);

    private Movement movement;

    Text(Player player){
        printText(player);
        //TODO: do something with the input of the player
        //new ActionHandler(input.nextLine());
    }

    protected abstract void printText(Player player);
}
