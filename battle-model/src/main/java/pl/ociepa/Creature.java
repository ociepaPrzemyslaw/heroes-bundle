package pl.ociepa;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Creature implements PropertyChangeListener {

    private final CreatureStatistic stats;
    private int currentHp;

    private boolean counterAttackedInThisTurn;

    public Creature(){
        this("DefName", 1,1,10,10,5);
    }

    Creature(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange, int aDamage) {
        stats = new CreatureStatistic(aName, aAttack, aArmor, aMaxHp, aMoveRange, aDamage);
        currentHp = stats.getMaxHp();
    }

    Creature(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange) {
        stats = new CreatureStatistic(aName, aAttack, aArmor, aMaxHp, aMoveRange, aAttack);
        currentHp = stats.getMaxHp();
    }

    void attack(Creature aDefender) {

        if(isAlive()){
            int damageToDeal = calculateDamage(aDefender);
            aDefender.currentHp = aDefender.currentHp - damageToDeal;

            if(!aDefender.counterAttackedInThisTurn){
                int damageTodealInCounterAttack = aDefender.calculateDamage(this);
                currentHp = currentHp - damageTodealInCounterAttack;
                aDefender.counterAttackedInThisTurn = true;
            }

        }
    }

    private int calculateDamage(Creature aDefender) {
        int damageToDeal = this.stats.getAttack() - aDefender.stats.getArmor();
        if (damageToDeal < 0) {
            damageToDeal = 0;
        }
        return damageToDeal;
    }

    private boolean isAlive() {
        return currentHp > 0;
    }

    int getCurrentHp() {
        return currentHp;
    }

    public String getName(){
        return stats.getName();
    }

    void resetCounterFlag() {
        counterAttackedInThisTurn = false;
    }

    boolean canCounterAttack() {
        return !counterAttackedInThisTurn;
    }

    void update() {
        counterAttackedInThisTurn = false;
    }

    int getMoveRange() {
        return stats.getMoveRange();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        counterAttackedInThisTurn = false;
    }
}
