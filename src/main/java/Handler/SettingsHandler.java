package Handler;

import Character.Player;
import FileSystem.FileSystem;
import FileSystem.Load;
import FileSystem.Save;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettingsHandler extends Handler {

    private FileSystem save;
    private FileSystem load;

    public SettingsHandler() {
        this.save = new Save();
        this.load = new Load();
    }

    @Override
    public void initializeOptions() {
        //stats of the player
        getOptions().put("stats of the player", 1);
        getOptions().put("player stats", 1);
        getOptions().put("playerstats", 1);
        getOptions().put("1", 1);
        //stats of the enemy
        getOptions().put("stats of the enemy", 2);
        getOptions().put("enemy stats", 2);
        getOptions().put("enemystats", 2);
        getOptions().put("2", 2);
        //save game
        getOptions().put("save", 3);
        getOptions().put("save game", 3);
        getOptions().put("save the game", 3);
        getOptions().put("3", 3);
        //load game
        getOptions().put("load", 4);
        getOptions().put("load game", 4);
        getOptions().put("load the game", 4);
        getOptions().put("4", 4);
        //quit game
        getOptions().put("quit", 5);
        getOptions().put("quit game", 5);
        getOptions().put("exit", 5);
        getOptions().put("exit game", 5);
        getOptions().put("quit the game", 5);
        getOptions().put("exit the game", 5);
        getOptions().put("5", 5);
        //return to previous location
        getOptions().put("return", 6);
        getOptions().put("6", 6);
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
                player.printStats(player);
                break;
            case 2:
                player.printStats(player.getEnemy());
                break;
            case 3:
                System.out.print("How do wanna call your saved game?:");
                this.save.processFile(player);
                System.out.println("Game was successfully saved.\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                this.load.processFile(player);
                break;
            case 5:
                System.exit(0);
            case 6:
                clear();
                break;
        }
    }
}
