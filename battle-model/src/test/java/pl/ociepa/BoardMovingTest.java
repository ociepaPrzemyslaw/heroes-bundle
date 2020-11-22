package pl.ociepa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardMovingTest {

    private Board board;
    private Creature creature;

    @BeforeEach
    void init(){
        board = new Board();
        creature = new Creature();
        //creature1 = new Creature("DefName", 1 , 1,10,1);
        board.add(new Point(0,0), creature);
    }

    @Test
    void creatureShouldMoveCorrectly(){
        board.move(new Point(0,0), new Point(0,1));

        Creature creatureFromBoard = board.get(0, 1);

        assertEquals(creature,creatureFromBoard);
        assertNull(board.get(0,0));
    }

    @Test
    void shouldThrowExceptionWhenCreatureTryingToMoveToNotEmptyField(){
        board.add(new Point(0,1), new Creature());

        assertThrows(IllegalArgumentException.class, () -> board.move(new Point(0,0), new Point(0,1)));

        Creature creatureFromBoard = board.get(0, 0);
        assertEquals(creature,creatureFromBoard);
    }

    @Test
    void canMoveWhenCreatureHasEnoughtMovePoint(){

        Creature creature = new Creature("DefName", 1 , 1,10,1);
        board.add(new Point(5,5), creature);

        assertTrue(board.canMove(creature, 6,5));
        assertTrue(board.canMove(creature, 4,5));
        assertTrue(board.canMove(creature, 5,4));
        assertTrue(board.canMove(creature, 5,6));
    }

    @Test
    void cannotMoveWhenCreatureHasNotEnoughtMovePoint(){

        Creature creature = new Creature("DefName", 1 , 1,10,1);
        board.add(new Point(5,5),creature);

        assertFalse(board.canMove(creature, 6,6));
    }

    @Test
    void cannotMoveWhenTileIsTaken(){
        Creature creature = new Creature("DefName", 1 , 1,10,10);
        board.add(new Point(5,5 ), creature);

        assertFalse(board.canMove(creature,0,0));
    }

}