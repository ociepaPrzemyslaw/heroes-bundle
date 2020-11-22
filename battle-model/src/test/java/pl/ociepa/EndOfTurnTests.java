package pl.ociepa;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EndOfTurnTests {

    @Test
    void shouldResetCounterAttackFlagsAfterEndOfTurn(){

        Creature attacker = new Creature();
        Creature defender = new Creature();
        GameEngine gameEngine = new GameEngine(List.of(attacker), List.of(defender));

        assertEquals(true, defender.canCounterAttack());
        attacker.attack(defender);

        assertEquals(false, defender.canCounterAttack());

        gameEngine.pass();
        gameEngine.pass();

        assertEquals(true, defender.canCounterAttack());

    }
}
