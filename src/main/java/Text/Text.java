package Text;

import Character.Enemy;
import Character.Player;
import Movement.Movement;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public abstract class Text {

    //user input while in a location
    private Scanner input = new Scanner(System.in);

    private Movement movement;

    Text(Player player){
        printText(player);
        System.out.print("Which option do you choose?: ");
    }

    protected abstract void printText(Player player);

    protected abstract void printText(Player player, Enemy enemy);
}
