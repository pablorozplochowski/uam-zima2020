package pl.psi;

import java.util.HashMap;
import java.util.Map;

public class Hero {

    //creature + amount
    private Map<CreatureStatistic, Integer> creatures;

    public Hero() {
        creatures = new HashMap<>();
    }

    public void addCreature(CreatureStatistic aCreature, int aAmount) {

    }

    public Map<CreatureStatistic, Integer> getCreatures() {
        return creatures;
    }
}
