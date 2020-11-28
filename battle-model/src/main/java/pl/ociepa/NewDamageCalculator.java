package pl.ociepa;

import javax.print.attribute.standard.PresentationDirection;

public class NewDamageCalculator extends DamageCalculator{

    @Override
    int calculateDamage(Creature aAttacker, Creature aDefender) {
        double ret;

        if(aAttacker.getAttack() >= aDefender.getArmor()){
            int attackPoint = aAttacker.getAttack() - aDefender.getArmor();
            if(attackPoint > 60){
                attackPoint = 60;
            }
            ret = aAttacker.getDamage().lowerEndpoint() * (1+(attackPoint)*0.05);
        }else {
            int defencePoints = aDefender.getArmor() - aAttacker.getArmor();
            if(defencePoints > 12){
                defencePoints = 12;
            }
            ret = aAttacker.getDamage().lowerEndpoint() * (1 - defencePoints * 0.025);
        }

        return (int)ret;
    }
}
