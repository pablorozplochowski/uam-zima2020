package pl.psi.battleengine.creatures;

import java.util.ArrayList;
import java.util.List;
import pl.psi.Hero;

public class HeroInBattle {

    private final List<CreatureStack> creatureStacks;

    public HeroInBattle(Hero aHero){
        creatureStacks = new ArrayList<>();
        aHero.getCreatures().forEach( (creature, amount)-> {
            creatureStacks.add(new CreatureStack(creature, amount));
        });
        creatureStacks.add(CreatureStack.builder().build());
    }

    @Deprecated
    public HeroInBattle() {
        creatureStacks = new ArrayList<>();
    }

    public void addCreature(CreatureStack aCreatureStack) {
        if (creatureStacks.size() >= 5){
            throw new IllegalArgumentException("Heroes is full");
        }
        creatureStacks.add(aCreatureStack);
    }

    public List<CreatureStack> getCreatureStacks() {
        return new ArrayList<>(creatureStacks);
    }
}
