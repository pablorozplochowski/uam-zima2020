package pl.psi.battleengine;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.spellbook.AttackBuffSpell;
import pl.psi.battleengine.spellbook.Spell;

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
    void ImpShouldHaveDefenceAndAttackIncreased(){
        // before buff
        assertEquals(2, imp.getAttack().lowerEndpoint());
        assertEquals(10, imp.getAttack().upperEndpoint());
        assertEquals(2, imp.getDefence());

        // after buff
        //assertEquals(4, imp.getAttack().lowerEndpoint());
        //assertEquals(12, imp.getAttack().upperEndpoint());
        //assertEquals(7, imp.getDefence());
    }
}