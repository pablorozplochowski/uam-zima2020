package pl.psi.battleengine.spellbook;

import com.google.common.collect.Range;
import lombok.Getter;
import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.creatures.StatisticBuffs;

import java.util.List;

public abstract class Spell {

    @Getter
    private final String name;


    public Spell(String name) {
        this.name = name;
    }

    public abstract void cast(CreatureStack aTarget);

}
