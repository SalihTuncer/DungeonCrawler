package Handler;

import Character.Player;
import Combat.Attack;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DungeonHandler extends Handler {

    //combat mechanic as an attribute
    private Attack attack;

    public DungeonHandler() {
        attack = new Attack();
    }

    @Override
    public void initializeOptions() {
        getOptions().put("fight", 1);
        getOptions().put("1", 1);
        getOptions().put("auto-combat", 2);
        getOptions().put("autocombat", 2);
        getOptions().put("auto", 2);
        getOptions().put("2", 2);
        getOptions().put("escape", 3);
        getOptions().put("3", 3);
    }

    @Override
    public void handleInput(String input, Player player) {

        int result = matches(input);

        if (result == 0) {
            noMatchRoutine(input, player);
            return;
        }
        //here are the different handles of the numbers
        switch (result) {
            case 1:
                clear();
                //the player decides to fight in the dungeon
                this.attack.fight(player);
                this.attack.consequences(player);
                //handleInput(new Scanner(System.in).nextLine().toLowerCase(), player);
                player.findLocationByName("dungeon").getText().decision(player);
                break;
            case 2:
                clear();
                this.attack.autoCombat(player);
                this.attack.consequences(player);
                player.findLocationByName("dungeon").getText().decision(player);
                break;
            case 3:
                //the player decides to move to the hometown
                this.walk.move(player, "hometown");
                break;
        }
    }

}
