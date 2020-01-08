package pl.psi.battleengine.spellbook;

import pl.psi.battleengine.creatures.CreatureStack;

public class DeffenceBuff implements Mechanics {
    @Override
    public void buff(CreatureStack aCaster, CreatureStack aTarget, int value) {
        aTarget.getBuffs().setDefence(aTarget.getBuffs().getDefence() + value);
    }
}
