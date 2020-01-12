package pl.psi.battleengine.spellbook;

import com.google.common.collect.Range;
import lombok.Getter;
import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.creatures.StatisticBuffs;

import java.util.List;

public abstract class Spell {

    @Getter
    private final String name;
    @Getter
    protected StatisticBuffs buffs;

    public Spell(String name) {

        this.name = name;
        buffs = new StatisticBuffs();

    }

    public void buff(CreatureStack aTarget){

        aTarget.getSpells().add(this);

    }

}
