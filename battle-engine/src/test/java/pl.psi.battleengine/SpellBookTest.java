package pl.psi.battleengine;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.spellbook.AttackBuff;
import pl.psi.battleengine.spellbook.DeffenceBuff;
import pl.psi.battleengine.spellbook.Effects;
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

        Spell spell = new Spell("test_attack", new LinkedList<Effects>(Arrays.asList(new Effects(2,99, new AttackBuff()))));
        spell.execute(imp);
        // after buff
        assertEquals(4, imp.getAttack().lowerEndpoint());
        assertEquals(12, imp.getAttack().upperEndpoint());
    }

    @Test
    void ImpShouldHaveDefenceAndAttackIncreased(){
        // before buff
        assertEquals(2, imp.getAttack().lowerEndpoint());
        assertEquals(10, imp.getAttack().upperEndpoint());
        assertEquals(2, imp.getDefence());

        Spell spell = new Spell("test_attack_and_Defence", new LinkedList<Effects>(Arrays.asList(new Effects(5,99, new DeffenceBuff()),
                new Effects(2,99, new AttackBuff()))));
        spell.execute(imp);
        // after buff
        assertEquals(4, imp.getAttack().lowerEndpoint());
        assertEquals(12, imp.getAttack().upperEndpoint());
        assertEquals(7, imp.getDefence());
    }
}