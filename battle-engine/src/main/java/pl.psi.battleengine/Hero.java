package pl.psi.battleengine;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private List<Creature> creatures;

    public Hero() {
        creatures = new ArrayList<>();
    }

    public void addCreature(Creature aCreature) {
        if (creatures.size() >= 5){
            throw new IllegalArgumentException("Heroes is full");
        }
        creatures.add(aCreature);
    }

    List<Creature> getCreatures() {
        return new ArrayList<>(creatures);
    }
}
