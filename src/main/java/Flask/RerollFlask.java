package Flask;

import Character.Player;

public class RerollFlask extends Flask {

    public RerollFlask(String name) {
        super(name);
    }

    /**
     * The stats of the player will be nullified and the simulation of as much level ups as the level was before,
     * will be processed.
     *
     * @param player is the player-object
     * @return true if the flask can be used
     */
    @Override
    public boolean useFlask(Player player) {
        //set all stats of the player except for xp and level to zero
        resetPlayerStats(player);
        //level of the player while used the flask
        int j = player.getLvl();
        for (int i = j; i >= 1; i--) {
            if (i == j)
                player.setLvl(1);
            player.generateStats(i);
        }
        player.setLvl(j);
        System.out.println("These are your new stats:");
        player.printStats(player);
        return true;
    }

    /**
     * Nullifies the player stats
     *
     * @param player is the player-object
     */
    private void resetPlayerStats(Player player) {
        player.setHp(0);
        player.setAtk(0);
        player.setArmor(0);
        player.setMResistance(0);
        player.setDex(0);
    }

    @Override
    public void noFlaskText() {
        System.out.println("You have no more reroll flasks.\n");
    }
}
