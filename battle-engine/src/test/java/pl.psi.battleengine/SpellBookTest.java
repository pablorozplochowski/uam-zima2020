package pl.psi.battleengine;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.creatures.StatisticBuffs;
import pl.psi.battleengine.spellbook.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpellBookTest {

    private CreatureStack centaur;
    private CreatureStack imp;

    @BeforeEach
    void init(){
        centaur = CreatureStack.builder()
                .aName("centaur")
                .aMaxHp(10)
                .aAttack(Range.closed(5,10))
                .aDefence(3)
                .build();
        imp = new CreatureStack("imp", 5,Range.closed(2,10),2, 0);
    }

    @Test
    void ImpShouldHaveAttackIncreased(){
        // before buff
        assertEquals(2, imp.getAttack().lowerEndpoint());
        assertEquals(10, imp.getAttack().upperEndpoint());

        StatisticBuffs buff = new StatisticBuffs();
        buff.setAttack(Range.closed(2,5));
        Spell spell = new SpellBuff("test_attack", buff);
        spell.cast(imp);
        assertEquals(4, imp.getAttack().lowerEndpoint());
        assertEquals(15, imp.getAttack().upperEndpoint());
    }

    @Test
    void ImpShouldHaveCurrentHpDecreased(){
        // before buff
        assertEquals(5, imp.getCurrentHp());

        Spell spell = new DealDamageSpell("test_damage", 4);
        spell.cast(imp);
        // after buff
        assertEquals(1, imp.getCurrentHp());
    }

}