package pl.psi.battleengine;

import org.junit.jupiter.api.Test;
import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.creatures.Hero;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void cannotAddMoreThan5Creatures() {
        Hero hero = new Hero();
        hero.addCreature(CreatureStack.builder().build());
        hero.addCreature(CreatureStack.builder().build());
        hero.addCreature(CreatureStack.builder().build());
        hero.addCreature(CreatureStack.builder().build());
        hero.addCreature(CreatureStack.builder().build());

        assertThrows(IllegalArgumentException.class, () -> hero.addCreature(CreatureStack.builder().build()));
    }

}