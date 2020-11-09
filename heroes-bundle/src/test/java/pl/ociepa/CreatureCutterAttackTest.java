package pl.ociepa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureCutterAttackTest {

    private static final int NOT_IMPORTANT = 5;

    @Test
    void creatureShouldCounterAttack(){

        Creature attacker = new Creature("Attacker", NOT_IMPORTANT,10 ,100, NOT_IMPORTANT);
        Creature defender = new Creature("Defender", 20,NOT_IMPORTANT ,100, NOT_IMPORTANT);

        attacker.attack(defender);

        assertEquals(90, attacker.getCurrentHp());
        
    }
}