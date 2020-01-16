package pl.psi.battleengine.spellbook;

import lombok.Getter;
import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.creatures.StatisticBuffs;

public class BuffSpell extends Spell{

    @Getter
    protected StatisticBuffs buffStats;

    public BuffSpell(String name, StatisticBuffs aBuffStats) {
        super(name);
        buffStats = aBuffStats;
    }

    @Override
    public void cast(CreatureStack aTarget) {
        aTarget.getSpells().add(this);
    }
}
