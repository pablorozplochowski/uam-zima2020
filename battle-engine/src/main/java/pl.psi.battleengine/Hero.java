package pl.psi.battleengine;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private List<Creature> creatures;

    Hero() {
        creatures = new ArrayList<>();
    }

    void addCreature(Creature aCreature) {
        creatures.add(aCreature);
    }
}
