package pl.ociepa;


import com.google.common.collect.Range;

class CreatureStatistic {

    final private String name;
    final private int attack;
    final private int armor;
    final private int maxHp;
    final private int moveRange;
    final private Range<Integer> damage;


    CreatureStatistic(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange, Range<Integer> aDamage) {
        name = aName;
        attack = aAttack;
        armor = aArmor;
        maxHp = aMaxHp;
        moveRange = aMoveRange;
        damage = aDamage;
    }

    String getName() {
        return name;
    }

    int getAttack() {
        return attack;
    }

    int getArmor() {
        return armor;
    }

    int getMaxHp() {
        return maxHp;
    }

    int getMoveRange() {
        return moveRange;
    }

    Range<Integer> getDamage() {
        return damage;
    }
}
