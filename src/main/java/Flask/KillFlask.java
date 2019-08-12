package Flask;

import Character.Player;

public class KillFlask extends Flask {

    public KillFlask(String name) {
        super(name);
    }

    /**
     * The enemy gets instantly killed while the consequences will be processed too.
     *
     * @param player is the player-object
     * @return true if the flask can be used
     */
    @Override
    public boolean useFlask(Player player) {
        player.getEnemy().setHp(0);
        player.findLocationByName("hometown").getText().getHandler().getAttack().consequences(player);
        return true;
    }

    @Override
    public void noFlaskText() {
        System.out.println("You have no more kill flasks.\n");
    }
}
