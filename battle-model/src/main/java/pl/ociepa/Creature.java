package pl.ociepa;

import com.google.common.collect.Range;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Creature implements PropertyChangeListener {

    private final CreatureStatistic stats;
    private int currentHp;
    private boolean counterAttackedInThisTurn;
    private DamageCalculator calculate;

    public Creature(){
        this("DefName", 1,1,10,10,100);
    }

    Creature(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange) {
        this(aName, aAttack, aArmor, aMaxHp, aMoveRange, aAttack);
    }

    Creature(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange, int aDamage) {
        this(aName, aAttack, aArmor, aMaxHp, aMoveRange, Range.closed(aDamage, aDamage), new NewDamageCalculator());
    }

    Creature(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange, Range<Integer> aDamage, DamageCalculator aCalculate) {
        stats = new CreatureStatistic(aName, aAttack, aArmor, aMaxHp, aMoveRange, aDamage);
        currentHp = stats.getMaxHp();
        calculate = aCalculate;
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

    Range<Integer> getDamage() {
        return stats.getDamage();
    }
}
