package pl.psi.battleengine.spellbook;

import lombok.Getter;
import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.creatures.StatisticBuffs;

public class SpellBuff extends Spell {
    @Getter
    protected StatisticBuffs buffs;

    public SpellBuff(String aName, StatisticBuffs aStats){
        super(aName);
        this.buffs = aStats;
    }

    @Override
    public void cast(CreatureStack aTarget){
        aTarget.getSpells().add(this);
    }
}
