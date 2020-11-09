package pl.ociepa;

public class Creature {

    private final CreatureStatistic stats;
    private int currentHp;

    Creature(){
        stats = new CreatureStatistic("DefName", 1,1,10,100);
    }

    Creature(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange) {
        stats = new CreatureStatistic(aName, aAttack, aArmor, aMaxHp, aMoveRange);
        currentHp = stats.getMaxHp();
    }

    void attack(Creature aDefender) {

        if(isAlive()){
            int damageToDeal = this.stats.getAttack() - aDefender.stats.getArmor();
            if (damageToDeal < 0) {
                damageToDeal = 0;
            }
            aDefender.currentHp = aDefender.currentHp - damageToDeal;
        }


    }

    private boolean isAlive() {
        return currentHp > 0;
    }

    int getCurrentHp() {
        return currentHp;
    }
}
