package Flask;

import Character.Player;

public class HealthFlask extends Flask {

    public HealthFlask(String name) {
        super(name);
    }

    /**
     * The health of the player will be completely refreshed.
     *
     * @param player is the player-object
     * @return true if the flask can be used
     */
    @Override
    public boolean useFlask(Player player) {
        if (!(player.getHp() == player.getLvl() * 10)) {
            player.setHp(player.getLvl() * 10);
            System.out.println("Your hp is fully restored:");
            player.printStats(player);
            return true;
        } else
            System.out.println("You are already full of hp.\nNo health flask is needed.");
        return false;
    }

    @Override
    public void noFlaskText() {
        System.out.println("You have no more health flasks.\n");
    }

}
