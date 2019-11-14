package pl.psi.battleengine;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BattleEngineTest {

    @Test
    void getByPointZeroOneShouldReturnCreature(){
        Hero heroWithCreature = new Hero();
        heroWithCreature.addCreature(Creature.builder().aName("C1").build());
        heroWithCreature.addCreature(Creature.builder().aName("C2").build());
        heroWithCreature.addCreature(Creature.builder().aName("C3").build());
        heroWithCreature.addCreature(Creature.builder().aName("C4").build());
        heroWithCreature.addCreature(Creature.builder().aName("C5").build());
        BattleEngine engine = new BattleEngine(heroWithCreature, new Hero());

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
    }

}