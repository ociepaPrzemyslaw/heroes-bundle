package pl.ociepa;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Creature implements PropertyChangeListener {

    private final CreatureStatistic stats;
    private int currentHp;
    private boolean counterAttackedInThisTurn;
    private DamageCalculator calculate;

    public Creature(){
        this("DefName", 1,1,10,10,5);
    }

    Creature(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange) {
        this(aName, aAttack, aArmor, aMaxHp, aMoveRange, aAttack);
    }

    Creature(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange, int aDamage) {
        stats = new CreatureStatistic(aName, aAttack, aArmor, aMaxHp, aMoveRange, aDamage);
        currentHp = stats.getMaxHp();
        calculate = new DamageCalculator();
    }

    void attack(Creature aDefender) {

        if(isAlive()){
            int damageToDeal = calculate.calculateDamage(this, aDefender);
            aDefender.currentHp = aDefender.currentHp - damageToDeal;

            if(!aDefender.counterAttackedInThisTurn){
                int damageTodealInCounterAttack = calculate.calculateDamage(aDefender, this);
                currentHp = currentHp - damageTodealInCounterAttack;
                aDefender.counterAttackedInThisTurn = true;
            }

        }
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

    int getAttack() {
        return stats.getAttack();
    }

    int getArmor() {
        return stats.getArmor();
    }
}
