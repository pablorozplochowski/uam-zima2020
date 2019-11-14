package pl.psi.battleengine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BattleEngineTest {

    private Hero hero2;
    private BattleEngine engine;
    private Hero hero1;

    @BeforeEach
    void init(){
        hero1 = new Hero();
        hero1.addCreature(Creature.builder().aName("C1").build());
        hero1.addCreature(Creature.builder().aName("C2").build());
        hero1.addCreature(Creature.builder().aName("C3").build());
        hero1.addCreature(Creature.builder().aName("C4").build());
        hero1.addCreature(Creature.builder().aName("C5").build());

        hero2 = new Hero();
        hero2.addCreature(Creature.builder().aName("C2_1").build());
        hero2.addCreature(Creature.builder().aName("C2_2").build());
        hero2.addCreature(Creature.builder().aName("C2_3").build());
        hero2.addCreature(Creature.builder().aName("C2_4").build());
        hero2.addCreature(Creature.builder().aName("C2_5").build());
        engine = new BattleEngine(hero1, hero2);

    }

    @Test
    void getByPointZeroOneShouldReturnCreature(){
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
    void getCurrentCreatureShouldReturnCorrectCreature(){
//        engine.getActiveCreaturePosition();
    }

}