package pl.psi.battleengine.creatures;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private List<CreatureStack> creatureStacks;

    public Hero() {
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
