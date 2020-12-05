package pl.ociepa;

import java.util.Random;

public class NewDamageCalculator extends DamageCalculator{

    private final Random random;

    NewDamageCalculator() {
        this(new Random());
    }

    NewDamageCalculator(Random aRandom) {
        random = aRandom;
    }

    @Override
    int calculateDamage(Creature aAttacker, Creature aDefender) {

        int randomValue = random.nextInt(aAttacker.getDamage().upperEndpoint() - aAttacker.getDamage().lowerEndpoint() + 1) ;

        double ret;
        if(aAttacker.getAttack() >= aDefender.getArmor()){
            int attackPoint = aAttacker.getAttack() - aDefender.getArmor();
            if(attackPoint > 60){
                attackPoint = 60;
            }
            ret = randomValue * (1 + (attackPoint)*0.05);
        }else {
            int defencePoints = aDefender.getArmor() - aAttacker.getAttack();
            if(defencePoints > 12){
                defencePoints = 12;
            }
            ret = randomValue * (1 - defencePoints*0.025);
        }

        if(ret < 0) {
            ret = 0;
        }

        return (int)ret;
    }
}
