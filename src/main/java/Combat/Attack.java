package Combat;

import Character.Player;

import java.util.regex.Pattern;

public class Attack extends Combat {

    public Attack() {

    }

    @Override
    public void fight(Player player) {
        //should the player has bigger dex-value, the player attacks first
        if (player.getDex() > player.getEnemy().getDex()) {

            playerAttacks(player);
            //should the enemy not died already, he can counter attack
            if (player.getEnemy().isAlive())
                enemyAttacks(player);
        }//otherwise the enemy attacks first
        else {

            enemyAttacks(player);
            playerAttacks(player);
        }
    }

    /**
     * simulates the attack of the player against the enemy
     *
     * @param player is the player-object
     */
    private void playerAttacks(Player player) {
        //should the armor value of the enemy not be higher than the attack value of the player
        if (player.getAtk() - player.getEnemy().getArmor() > 1) {
            //the player attacks now normally
            player.getEnemy().setHp(player.getEnemy().getHp() - (player.getAtk() - player.getEnemy().getArmor()));
        } else {
            //should the armor value of the enemy be too high, the player deals only one damage
            player.getEnemy().setHp(player.getEnemy().getHp() - 1);
        }
    }

    /**
     * simulates the attack of the enemy against the player
     *
     * @param player is the player-object
     */
    private void enemyAttacks(Player player) {
        //should the armor value of the player not be bigger than the attack value of the enemy
        if (player.getEnemy().getAtk() - player.getArmor() > 1) {
            //the enemy attacks now normally
            player.setHp(player.getHp() - (player.getEnemy().getAtk() - player.getArmor()));
        } else {
            //should the armor value of the player be too high, the enemy deals only one damage
            player.setHp(player.getHp() - 1);
        }
    }

    /**
     * The user can choose auto-combat which simulates a fight with a cloned player object and the cloned enemy.
     * The result is printed and the player can choose whether he wanna accept that or not.
     *
     * @param player is the player-object
     */
    public void autoCombat(Player player) {
        try {
            //player object is cloned which is used for the auto-combat
            Player tmp = (Player) player.clone();

            //fight is going on until the player or the enemy dies
            while (tmp.getHp() > 0 && tmp.getEnemy().getHp() > 0) {

                fight(tmp);

                if (tmp.getHp() <= 0) {

                    System.out.println("the player would die against the enemy");

                } else if (tmp.getEnemy().getHp() <= 0) {

                    System.out.println("The enemy would die against the player.");
                    System.out.print("Do you accept that, yes or no?: ");
                    //the player can now choose whether he accepts the simulated fight or not
                    decision(player.findLocationByName("hometown").getText().getInput().nextLine().toLowerCase(),
                            player, tmp);
                }
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * the player is asked whether he wants to accept the simulated fight or not
     *
     * @param input  his decision
     * @param player the player-object
     * @param clone  the simulated clone-player-object
     */
    private void decision(String input, Player player, Player clone) {
        if (Pattern.matches("yes|no", input)) {
            if (input.equals("yes")) {
                //the result is transferred to the player
                player = clone;
                System.out.println("Auto-combat successfull.");
            }
        } else {
            System.out.print("Pls choose a valid option pls: ");
            decision(player.findLocationByName("hometown").getText().getInput().nextLine().toLowerCase(),
                    player, clone);
        }

    }
}

