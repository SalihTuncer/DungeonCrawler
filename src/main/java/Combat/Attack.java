package Combat;

import Character.Player;

public class Attack extends Combat {

    @Override
    public void fight(Player player) {
        //should the player has bigger dex-value, the player attacks first
        if (player.getDex() > player.getEnemy().getDex()) {

            playerAttacks(player);
            enemyAttacks(player);
        }//otherwise the enemy attacks first
        else {

            enemyAttacks(player);
            playerAttacks(player);
        }
    }

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
}

