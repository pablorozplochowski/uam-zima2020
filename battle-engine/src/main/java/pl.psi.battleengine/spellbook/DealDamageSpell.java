package pl.psi.battleengine.spellbook;

import pl.psi.battleengine.creatures.CreatureStack;

public class DealDamageSpell extends Spell {
    int damage;
    public DealDamageSpell(String aName, int aDamage){
        super(aName);
        damage = aDamage;
    }

    @Override
    public void buff(CreatureStack aTarget){
        aTarget.setCurrentHp(aTarget.getCurrentHp() - damage);
    }
}
