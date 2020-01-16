package pl.psi.battleengine.creatures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public LinkedList<CreatureStack> removeDeadCreatures(){

        LinkedList<CreatureStack> toBeRemoved = new LinkedList<CreatureStack>();

        for(CreatureStack creature : creatureStacks){

            if(creature.getCurrentHp() <= 0){

                toBeRemoved.add(creature);

            }

        }

        creatureStacks.removeAll(toBeRemoved);

        return toBeRemoved;

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
