package pl.ociepa;

class CreatureStatistic {

    final private String name;
    final private int attack;
    final private int armor;
    final private int maxHp;
    final private int moveRange;
    final private int damage;


    CreatureStatistic(String aName, int aAttack, int aArmor, int aMaxHp, int aMoveRange, int aDamage) {
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

    int getDamage() {
        return damage;
    }
}
