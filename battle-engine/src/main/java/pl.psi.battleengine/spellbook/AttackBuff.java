package pl.psi.battleengine.spellbook;

import com.google.common.collect.Range;
import pl.psi.battleengine.creatures.CreatureStack;

public class AttackBuff implements Mechanics {
    @Override
    public void buff(CreatureStack aCaster, CreatureStack aTarget, int value) {
        aTarget.getBuffs().setAttack(Range.closed(aTarget.getBuffs().getAttack().lowerEndpoint() + value, aTarget.getBuffs().getAttack().upperEndpoint() + value));
    }
}
