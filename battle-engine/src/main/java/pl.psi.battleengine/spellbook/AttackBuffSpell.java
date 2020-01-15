package pl.psi.battleengine.spellbook;

import com.google.common.collect.Range;

public class AttackBuffSpell extends Spell {

    public AttackBuffSpell(String aName, int aLowerAttack, int aUpperAttack){
        super(aName);
        buffs.setAttack(Range.closed(aLowerAttack, aUpperAttack));
    }


}
