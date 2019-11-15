package pl.psi.battleengine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void cannotAddMoreThan5Creatures() {
        Hero hero = new Hero();
        hero.addCreature(Creature.builder().build());
        hero.addCreature(Creature.builder().build());
        hero.addCreature(Creature.builder().build());
        hero.addCreature(Creature.builder().build());
        hero.addCreature(Creature.builder().build());

        assertThrows(IllegalArgumentException.class, () -> hero.addCreature(Creature.builder().build()));
    }

}