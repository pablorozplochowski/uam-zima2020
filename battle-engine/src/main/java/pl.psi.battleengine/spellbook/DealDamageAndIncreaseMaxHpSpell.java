package pl.psi.battleengine.spellbook;

import com.google.common.collect.Range;
import pl.psi.battleengine.creatures.CreatureStack;

public class DealDamageAndIncreaseMaxHpSpell extends Spell{
    int damage;
    public DealDamageAndIncreaseMaxHpSpell(String aName, int aDamage, int aMaxHp){
        super(aName);
        damage = aDamage;
        buffs.setMaxHp(aMaxHp);
    }

    @Override
    public void buff(CreatureStack aTarget){
        aTarget.getSpells().add(this);
        aTarget.setCurrentHp(aTarget.getCurrentHp() - damage);
    }
}
