package pl.ociepa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CreatureTest {

    public static final int NOT_IMPORTANT = 5;

    @Test
    void creatureShouldLost10HpWenAttackerHas20AttackAndDefenderHas10Armor(){
        Creature attacker = new Creature("Attacker", 20,NOT_IMPORTANT ,100, NOT_IMPORTANT);
        Creature defender = new Creature("Defender", NOT_IMPORTANT,10 ,100, NOT_IMPORTANT);

        attacker.attack(defender);

        assertEquals(defender.getCurrentHp(10));

    }
}