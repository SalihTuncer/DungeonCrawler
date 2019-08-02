package Character;

public class Enemy extends Character {

    Enemy(int lvl) {
        super(lvl);
    }

    @Override
    public void newStats(int lvl) {
        //the enemy has more bad values than the player because the player needs to play against multiple enemy in time
        setHp(lvl * 10);
        setAtk(lvl * 2);
        setArmor(lvl);
        setMResistance(lvl);
        setDex(lvl);
        setLvl(lvl);
        setXp(0);
    }
}
