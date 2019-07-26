package Text;

import Character.Player;
import Character.Enemy;

public class DungeonText extends Text {

    public DungeonText(Player player, Enemy enemy) {
        super(player);
    }

    @Override
    protected void printText(Player player){
        System.out.println("You entered the deep of the dungeon!");
    }
}
