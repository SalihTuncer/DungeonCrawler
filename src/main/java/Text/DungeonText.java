package Text;

import Character.Enemy;
import Character.Player;
import Handler.DungeonHandler;

public class DungeonText extends Text {

    public DungeonText(Player player, Enemy enemy) {
        super(player);
        printText(player, enemy);
        new DungeonHandler(getInput().nextLine().toLowerCase(), player, enemy);
    }

    @Override
    protected void printText(Player player) {
    }

    @Override
    protected void printText(Player player, Enemy enemy) {
        System.out.println("You entered the deep of the dungeon!");
        System.out.println("You have the following options:");
        System.out.println("1.Fight");
        System.out.println("2.Escape to the hometown.");
    }
}
