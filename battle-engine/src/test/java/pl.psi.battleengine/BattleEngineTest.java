package pl.psi.battleengine;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BattleEngineTest {

    @Test
    void getByPointZeroOneShouldReturnCreature(){
        Hero heroWithCreature = new Hero();
        heroWithCreature.addCreature(Creature.builder().aName("Creature").build());
        BattleEngine engine = new BattleEngine(heroWithCreature, new Hero());

        GuiTileIf result = engine.getByPoint(new Point(0, 1));

        assertEquals("Creature", result.getIcon());
    }

}