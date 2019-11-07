package pl.psi.battleengine;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void shouldReturnCorrectCreature(){
        Board board = new Board();
        Creature creature = Creature.builder().aName("CORRECT").build();
        board.put(new Point(0,0), Creature.builder().aName("NOT_CORRECT"));
        board.put(new Point(0,1), creature);

        assertEquals(creature, board.getByPoint(new Point(0,1)));
    }

    @Test
    void shouldReturnCorrectObstacle(){

    }
}