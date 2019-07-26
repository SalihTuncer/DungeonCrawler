package Text;

import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Text {

    //user input while in a location
    private Scanner input = new Scanner(System.in);

    Text(){
        printText();
    }

    protected abstract void printText();
}
