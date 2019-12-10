package pl.psi.battleengine.creatures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.psi.battleengine.BattleEngine;
import pl.psi.battleengine.move.GuiTileIf;

import java.awt.*;

class BattleEngineTest {

    private Hero hero2;
    private BattleEngine engine;
    private Hero hero1;
    private CreatureStack highestSpeedCreatureStack;

    @BeforeEach
    void init() {
        hero1 = new Hero();
        hero1.addCreature(CreatureStack.builder().aName("C1").aMoveRange(1).build());
        hero1.addCreature(CreatureStack.builder().aName("C2").aMoveRange(2).build());
        hero1.addCreature(CreatureStack.builder().aName("C3").aMoveRange(3).build());
        hero1.addCreature(CreatureStack.builder().aName("C4").aMoveRange(4).build());
        hero1.addCreature(CreatureStack.builder().aName("C5").aMoveRange(5).build());

        // 14 . 1
        highestSpeedCreatureStack = CreatureStack.builder().aName("C2_5").aMoveRange(15).build();
        hero2 = new Hero();
        hero2.addCreature(CreatureStack.builder().aName("C2_1").aMoveRange(11).build());
        hero2.addCreature(CreatureStack.builder().aName("C2_2").aMoveRange(12).build());
        hero2.addCreature(CreatureStack.builder().aName("C2_3").aMoveRange(13).build());
        hero2.addCreature(CreatureStack.builder().aName("C2_4").aMoveRange(14).build());
        hero2.addCreature(highestSpeedCreatureStack);
        engine = new BattleEngine(hero1, hero2);

    }

    @Test
    void getByPointZeroOneShouldReturnCreature() {
        GuiTileIf result1 = engine.getByPoint(new Point(0, 1));
        GuiTileIf result2 = engine.getByPoint(new Point(0, 3));
        GuiTileIf result3 = engine.getByPoint(new Point(0, 5));
        GuiTileIf result4 = engine.getByPoint(new Point(0, 7));
        GuiTileIf result5 = engine.getByPoint(new Point(0, 9));

        Assertions.assertEquals("C1", result1.getIcon());
        Assertions.assertEquals("C2", result2.getIcon());
        Assertions.assertEquals("C3", result3.getIcon());
        Assertions.assertEquals("C4", result4.getIcon());
        Assertions.assertEquals("C5", result5.getIcon());

        GuiTileIf result21 = engine.getByPoint(new Point(BattleEngine.WIDTH, 1));
        GuiTileIf result22 = engine.getByPoint(new Point(BattleEngine.WIDTH, 3));
        GuiTileIf result23 = engine.getByPoint(new Point(BattleEngine.WIDTH, 5));
        GuiTileIf result24 = engine.getByPoint(new Point(BattleEngine.WIDTH, 7));
        GuiTileIf result25 = engine.getByPoint(new Point(BattleEngine.WIDTH, 9));

        Assertions.assertEquals("C2_1", result21.getIcon());
        Assertions.assertEquals("C2_2", result22.getIcon());
        Assertions.assertEquals("C2_5", result25.getIcon());
        Assertions.assertEquals("C2_3", result23.getIcon());
        Assertions.assertEquals("C2_4", result24.getIcon());
    }

    @Test
    void getCurrentCreatureShouldReturnCorrectCreature() {
        Point result = engine.getActiveCreaturePosition();

        Assertions.assertEquals(new Point(14, 9), result);
    }

    @Test
    void checkQueueLoop(){
        Assertions.assertEquals(new Point(14, 9), engine.getActiveCreaturePosition());
        engine.pass();
        Assertions.assertEquals(new Point(14, 7), engine.getActiveCreaturePosition());
        engine.pass();
        Assertions.assertEquals(new Point(14, 5), engine.getActiveCreaturePosition());
        engine.pass();
        Assertions.assertEquals(new Point(14, 3), engine.getActiveCreaturePosition());
        engine.pass();
        Assertions.assertEquals(new Point(14, 1), engine.getActiveCreaturePosition());
        engine.pass();
        Assertions.assertEquals(new Point(0, 9), engine.getActiveCreaturePosition());
        engine.pass();
        Assertions.assertEquals(new Point(0, 7), engine.getActiveCreaturePosition());
        engine.pass();
        Assertions.assertEquals(new Point(0, 5), engine.getActiveCreaturePosition());
        engine.pass();
        Assertions.assertEquals(new Point(0, 3), engine.getActiveCreaturePosition());
        engine.pass();
        Assertions.assertEquals(new Point(0, 1), engine.getActiveCreaturePosition());
        engine.pass();
        //end of turn -> all creatures passed
        Assertions.assertEquals(new Point(14, 9), engine.getActiveCreaturePosition());
    }

    @Test
    void moveShouldBeAllowWhileTileIsEmpty(){
        Assertions.assertTrue(engine.isMoveAllowed(new Point(10,10)));
    }

    @Test
    void moveShouldNotBeAllowWhileTileIsNotEmpty(){
        Assertions.assertFalse(engine.isMoveAllowed(new Point(14,1)));
    }

    @Test
    void moveShouldNotBeAllowWhileMoveRangeIsToSmall(){
        engine.pass();
        engine.pass();
        engine.pass();
        engine.pass();
        engine.pass();
        //pass for creature with 5 moveRange in position (0, 9)

        Assertions.assertTrue(engine.isMoveAllowed(new Point(5,9)));
        Assertions.assertFalse(engine.isMoveAllowed(new Point(6,9)));

        Assertions.assertTrue(engine.isMoveAllowed(new Point(0,4)));
        Assertions.assertFalse(engine.isMoveAllowed(new Point(0,3)));

        Assertions.assertTrue(engine.isMoveAllowed(new Point(2,5)));
        Assertions.assertFalse(engine.isMoveAllowed(new Point(2,4)));

        Assertions.assertTrue(engine.isMoveAllowed(new Point(0,4)));
        Assertions.assertFalse(engine.isMoveAllowed(new Point(1,4)));
    }

    @Test
    void attackIsNotPossibleWhileMeleeCreatureIsNotNextToTarget(){
        Assertions.assertFalse(engine.isAttackAllowed(new Point(0,0)));
    }

    @Test
    void attackIsNotPossibleWhileFieldIsEmpty(){
        Assertions.assertFalse(engine.isAttackAllowed(new Point(14,8)));
    }

    @Test
    void attackIsPossibleWhileRangeIsEnoughtAndTileHasCreature(){
        //cannot test without move method in engine or use mockito.
//        assertFalse(engine.isAttackAllowed(new Point(14,8)));
    }

    @Test
    void moveTest(){
        Assertions.assertEquals(highestSpeedCreatureStack, engine.getByPoint(14,1));
        engine.move(10,10);

        Assertions.assertEquals(highestSpeedCreatureStack, engine.getByPoint(10,10));
        Assertions.assertNull(engine.getByPoint(14,1));
    }
}