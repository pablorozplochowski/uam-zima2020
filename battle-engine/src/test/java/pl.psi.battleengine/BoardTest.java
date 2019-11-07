package pl.psi.battleengine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void init(){
        board = new Board();
    }

    @Test
    void shouldReturnCorrectCreature(){
        Creature creature = Creature.builder().aName("CORRECT").build();
        board.put(new Point(0,0), Creature.builder().aName("NOT_CORRECT").build());
        board.put(new Point(0,1), creature);

        assertEquals(creature, board.getByPoint(new Point(0,1)));

    }

    @Test
    void shouldReturnNullWhilePointIsEmpty(){
        assertNull(board.getByPoint(new Point(10,10)));
    }

    @Test
    void shouldReturnCorrectObstacle(){
        MapObstacle obstacle = new MapObstacle();
        board.put(new Point(0,0), obstacle);

        assertEquals(obstacle, board.getByPoint(new Point(0,0)));
    }

    @Test
    void shouldRecognizeMapTileType(){
        board.put(new Point(0,0), Creature.builder().aName("CREATURE").build());
        board.put(new Point(0,1), new MapObstacle());

        assertEquals("CREATURE",board.getByPoint(new Point(0,0)).getIcon());
        assertEquals("X",board.getByPoint(new Point(0,1)).getIcon());
    }

    @Test
    void shouldThrowExceptionIfyouTryToAddGuiTileToNotEmptyTile(){
        board.put(new Point(0,0), Creature.builder().aName("CREATURE").build());

        assertThrows(IllegalArgumentException.class, () -> {
            board.put(new Point(0,0), new MapObstacle());
        });
    }

}