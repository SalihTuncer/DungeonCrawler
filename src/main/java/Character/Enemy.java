package Character;

public class Enemy extends Character {

    Enemy(int lvl) {
        super(lvl);
    }

    @Override
    public void newStats(int lvl) {
        //the enemy has more bad values than the player because the player needs to play against multiple enemy in time
        setHp(getHp() + (int) (Math.random() * 4 + 6));
        setAtk(getAtk() + (int) (Math.random() * 1 + 1));
        setArmor(getArmor() + (int) (Math.random() * 1 + 1));
        setMResistance(getMResistance() + (int) (Math.random() * 1 + 1));
        setDex(getDex() + (int) (Math.random() * 1 + 1));
        setLvl(lvl);
        setXp(0);
    }
}
