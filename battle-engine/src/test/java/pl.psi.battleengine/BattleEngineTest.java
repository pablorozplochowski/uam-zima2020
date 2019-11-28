package pl.psi.battleengine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BattleEngineTest {

    private Hero hero2;
    private BattleEngine engine;
    private Hero hero1;
    private Creature highestSpeedCreature;

    @BeforeEach
    void init() {
        hero1 = new Hero();
        hero1.addCreature(Creature.builder().aName("C1").aMoveRange(1).build());
        hero1.addCreature(Creature.builder().aName("C2").aMoveRange(2).build());
        hero1.addCreature(Creature.builder().aName("C3").aMoveRange(3).build());
        hero1.addCreature(Creature.builder().aName("C4").aMoveRange(4).build());
        hero1.addCreature(Creature.builder().aName("C5").aMoveRange(5).build());

        // 14 . 1
        highestSpeedCreature = Creature.builder().aName("C2_5").aMoveRange(15).build();
        hero2 = new Hero();
        hero2.addCreature(highestSpeedCreature);
        hero2.addCreature(Creature.builder().aName("C2_1").aMoveRange(11).build());
        hero2.addCreature(Creature.builder().aName("C2_2").aMoveRange(12).build());
        hero2.addCreature(Creature.builder().aName("C2_3").aMoveRange(13).build());
        hero2.addCreature(Creature.builder().aName("C2_4").aMoveRange(14).build());
        engine = new BattleEngine(hero1, hero2);

    }

    @Test
    void getByPointZeroOneShouldReturnCreature() {
        GuiTileIf result1 = engine.getByPoint(new Point(0, 1));
        GuiTileIf result2 = engine.getByPoint(new Point(0, 3));
        GuiTileIf result3 = engine.getByPoint(new Point(0, 5));
        GuiTileIf result4 = engine.getByPoint(new Point(0, 7));
        GuiTileIf result5 = engine.getByPoint(new Point(0, 9));

        assertEquals("C1", result1.getIcon());
        assertEquals("C2", result2.getIcon());
        assertEquals("C3", result3.getIcon());
        assertEquals("C4", result4.getIcon());
        assertEquals("C5", result5.getIcon());

        GuiTileIf result21 = engine.getByPoint(new Point(Board.WIDTH, 1));
        GuiTileIf result22 = engine.getByPoint(new Point(Board.WIDTH, 3));
        GuiTileIf result23 = engine.getByPoint(new Point(Board.WIDTH, 5));
        GuiTileIf result24 = engine.getByPoint(new Point(Board.WIDTH, 7));
        GuiTileIf result25 = engine.getByPoint(new Point(Board.WIDTH, 9));

        assertEquals("C2_1", result21.getIcon());
        assertEquals("C2_2", result22.getIcon());
        assertEquals("C2_3", result23.getIcon());
        assertEquals("C2_4", result24.getIcon());
        assertEquals("C2_5", result25.getIcon());
    }

    @Test
    void getCurrentCreatureShouldReturnCorrectCreature() {
        Point result = engine.getActiveCreaturePosition();

        assertEquals(new Point(14, 9), result);
    }

    @Test
    void checkQueueLoop(){
        assertEquals(new Point(14, 9), engine.getActiveCreaturePosition());
        engine.pass();
        assertEquals(new Point(14, 7), engine.getActiveCreaturePosition());
        engine.pass();
        assertEquals(new Point(14, 5), engine.getActiveCreaturePosition());
        engine.pass();
        assertEquals(new Point(14, 3), engine.getActiveCreaturePosition());
        engine.pass();
        assertEquals(new Point(14, 1), engine.getActiveCreaturePosition());
        engine.pass();
        assertEquals(new Point(0, 9), engine.getActiveCreaturePosition());
        engine.pass();
        assertEquals(new Point(0, 7), engine.getActiveCreaturePosition());
        engine.pass();
        assertEquals(new Point(0, 5), engine.getActiveCreaturePosition());
        engine.pass();
        assertEquals(new Point(0, 3), engine.getActiveCreaturePosition());
        engine.pass();
        assertEquals(new Point(0, 1), engine.getActiveCreaturePosition());
        engine.pass();
        //end of turn -> all creatures passed
        assertEquals(new Point(14, 9), engine.getActiveCreaturePosition());
    }

    @Test
    void moveShouldBeAllowWhileTileIsEmpty(){
        assertTrue(engine.isMoveAllowed(new Point(10,10)));
    }

    @Test
    void moveShouldNotBeAllowWhileTileIsNotEmpty(){
        assertFalse(engine.isMoveAllowed(new Point(14,1)));
    }

    @Test
    void moveShouldNotBeAllowWhileMoveRangeIsToSmall(){
        engine.pass();
        engine.pass();
        engine.pass();
        engine.pass();
        engine.pass();
        //pass for creature with 5 moveRange in position (0, 9)

        assertTrue(engine.isMoveAllowed(new Point(5,9)));
        assertFalse(engine.isMoveAllowed(new Point(6,9)));

        assertTrue(engine.isMoveAllowed(new Point(0,4)));
        assertFalse(engine.isMoveAllowed(new Point(0,3)));

        assertTrue(engine.isMoveAllowed(new Point(2,5)));
        assertFalse(engine.isMoveAllowed(new Point(2,4)));

        assertTrue(engine.isMoveAllowed(new Point(0,4)));
        assertFalse(engine.isMoveAllowed(new Point(1,4)));
    }

    @Test
    void attackIsNotPossibleWhileMeleeCreatureIsNotNextToTarget(){
        assertFalse(engine.isAttackAllowed(new Point(0,0)));
    }

    @Test
    void attackIsNotPossibleWhileFieldIsEmpty(){
        assertFalse(engine.isAttackAllowed(new Point(14,8)));
    }

    @Test
    void attackIsPossibleWhileRangeIsEnoughtAndTileHasCreature(){
        //cannot test without move method in engine or use mockito.
//        assertFalse(engine.isAttackAllowed(new Point(14,8)));
    }

    @Test
    void moveTest(){
        assertEquals(highestSpeedCreature, engine.getByPoint(14,1));
        engine.move(10,10);

        assertEquals(highestSpeedCreature, engine.getByPoint(10,10));
        assertNull(engine.getByPoint(14,1));
    }
}