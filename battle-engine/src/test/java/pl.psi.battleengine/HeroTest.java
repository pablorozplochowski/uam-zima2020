package pl.psi.battleengine;

import org.junit.jupiter.api.Test;
import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.creatures.HeroInBattle;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void cannotAddMoreThan5Creatures() {
        HeroInBattle hero = new HeroInBattle();
        hero.addCreature(CreatureStack.builder().build());
        hero.addCreature(CreatureStack.builder().build());
        hero.addCreature(CreatureStack.builder().build());
        hero.addCreature(CreatureStack.builder().build());
        hero.addCreature(CreatureStack.builder().build());

        assertThrows(IllegalArgumentException.class, () -> hero.addCreature(CreatureStack.builder().build()));
    }

}