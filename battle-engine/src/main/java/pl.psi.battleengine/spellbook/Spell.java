package pl.psi.battleengine.spellbook;


import pl.psi.battleengine.creatures.CreatureStack;

import java.util.List;

public class Spell {
    private final String name;
    private List<Effects> effects;

    public void execute(CreatureStack creature){
        for(Effects effect : effects) effect.execute(null, creature);
    }


    public Spell(String name, List<Effects> effects) {
        this.name = name;
        this.effects = effects;
    }
}
