package pl.psi.battleengine;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.spellbook.*;

import java.util.Arrays;
import java.util.LinkedList;

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

        Spell spell = new AttackBuffSpell("test_attack", 2, 5);
        spell.buff(imp);
        assertEquals(4, imp.getAttack().lowerEndpoint());
        assertEquals(15, imp.getAttack().upperEndpoint());
    }

    @Test
    void ImpShouldHaveCurrentHpDecreased(){
        // before buff
        assertEquals(5, imp.getCurrentHp());

        Spell spell = new DealDamageSpell("test_damage", 4);
        spell.buff(imp);
        // after buff
        assertEquals(1, imp.getCurrentHp());
    }

    @Test
    void ImpShouldHaveCurrentHpDecreasedAndMaHpIncreased(){
        // before buff
        assertEquals(5, imp.getMaxHp());
        assertEquals(5, imp.getCurrentHp());

        Spell spell = new DealDamageAndIncreaseMaxHpSpell("test_damage_and_maxHp", 4, 3);
        spell.buff(imp);
        // after buff
        assertEquals(8, imp.getMaxHp());
        assertEquals(1, imp.getCurrentHp());
    }

    @Test
    void ImpShouldHaveDefenceAndMoveRangeIncreased(){
        // before buff
        assertEquals(2, imp.getDefence());
        assertEquals(0, imp.getMoveRange());

        Spell spell = new DefenceAndMoveRangeBuffSpell("test_defence_and_moveRange", 1, 7);
        spell.buff(imp);
        // after buff
        assertEquals(3, imp.getDefence());
        assertEquals(7, imp.getMoveRange());
    }
}