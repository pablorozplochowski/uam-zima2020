package pl.psi.battleengine.spellbook;

import lombok.Getter;
import pl.psi.battleengine.creatures.CreatureStack;

public abstract class Spell {

    @Getter
    private final String name;

    public Spell(String name) {
        this.name = name;
    }

    public abstract void cast(CreatureStack aTarget);
}
