package Character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends Character {
    //enemy is an attribute so we can ask everywhere for the information
    private Enemy enemy;

    public Player(int lvl) {
        super(lvl);
    }

    public void generateEnemy(int lvl) {
        enemy = new Enemy(lvl);
    }
}
