package pl.psi.battleengine.spellbook;

import pl.psi.battleengine.creatures.CreatureStack;

public class DealDamageAndIncreaseMaxHpSpell extends Spell {
    int damage;
    public DealDamageAndIncreaseMaxHpSpell(String aName, int aDamage, int aMaxHp){
        super(aName);
        damage = aDamage;
//        buffs.setMaxHp(aMaxHp);
    }

    public void buff(CreatureStack aTarget){
//        aTarget.getSpells().add(this);
        aTarget.setCurrentHp(aTarget.getCurrentHp() - damage);
    }

    @Override
    public void cast(CreatureStack aTarget) {

    }
}
