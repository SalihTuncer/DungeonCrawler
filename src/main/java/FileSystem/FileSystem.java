package FileSystem;

import Character.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public abstract class FileSystem {

    private Scanner scanner = new Scanner(System.in);

    FileSystem() {

    }

    public abstract void processFile(Player player);
}
