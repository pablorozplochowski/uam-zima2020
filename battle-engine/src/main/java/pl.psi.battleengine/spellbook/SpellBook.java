package pl.psi.battleengine.spellbook;

import com.google.common.collect.Range;
import pl.psi.battleengine.creatures.StatisticBuffs;

import java.util.List;

public class SpellBook {
    public Spell attackSpell;
    public Spell defenceAndMoveRangeSpell;
    public Spell dealDmgSpell;
    public SpellBook(){
        StatisticBuffs attackBuff = new StatisticBuffs();
        attackBuff.setAttack(Range.closed(100,100));
        attackSpell = new SpellBuff("Attack spell", attackBuff);

        StatisticBuffs defenceAndMoveRangeBuff = new StatisticBuffs();
        defenceAndMoveRangeBuff.setDefence(100);
        defenceAndMoveRangeBuff.setMoveRange(100);
        defenceAndMoveRangeSpell = new SpellBuff("Defence and Move Range spell", defenceAndMoveRangeBuff);

        dealDmgSpell = new DealDamageSpell("Deal Damage Spell", 100);
    }
}
