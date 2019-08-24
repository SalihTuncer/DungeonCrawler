package Combat;

import Application.GamingRoutine;
import Character.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;
import java.util.regex.Pattern;

@Getter
@Setter
public abstract class Combat {

    Combat() {

    }

    public abstract void fight(Player player);

    public void consequences(Player player) {
        //should the player be still alive
        if (player.isAlive()) {
            //should the enemy died
            if (!player.getEnemy().isAlive()) {
                //player gets xp equal to the level of the enemy
                player.setXp(player.getXp() + player.getEnemy().getLvl());
                //the enemy drops his loot
                player.getEnemy().drop(player);
                //should the player has enough experience to level up
                if (player.isReadyToLevelUp()) {
                    //the player gets new stats
                    player.generateStats(player.getLvl() + 1);
                    System.out.println("You have successfully killed the enemy!");
                    System.out.println("Congratulations! You have levelled up! Your new stats:");
                    player.printStats(player);
                }//should the player did not level up
                else {
                    System.out.println("You have successfully killed the enemy!");
                    //print player stats normally
                    player.printStats(player);
                }
                //new enemy needs to be generated
                player.generateEnemy();
            } else {
                //print player stats normally
                player.printStats(player);
                player.printStats(player.getEnemy());
            }

        } else {
            //should the player died
            System.out.println("You have failed to kill the enemy. Instead he killed you!");
            System.out.print("Do you wanna start a new game?: ");
            //user is asked to start a new game or leave
            leaveOrNot(new Scanner(System.in).nextLine().toLowerCase());
        }
    }

    /**
     * the user decides after his character died whether he wants to start a new game or quit
     * should the answer not be a valid option, the function will be called again and it will ask the player again
     * for a new valid input
     *
     * @param input this is the answer of the player
     */
    private void leaveOrNot(String input) {
        if (Pattern.matches("yes|no", input)) {
            //should the player decides to start a new game
            if (input.equals("yes"))
                //routine will be started again
                new GamingRoutine().start();
            else {
                //output text and exit of the game
                System.out.println("You lose.");
                System.exit(0);
            }
        } else {
            System.out.print("Pls choose a valid option: ");
            leaveOrNot(new Scanner(System.in).nextLine().toLowerCase());
        }
    }
}
