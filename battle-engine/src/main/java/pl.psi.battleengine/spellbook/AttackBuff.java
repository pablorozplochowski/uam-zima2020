package pl.psi.battleengine.spellbook;

import com.google.common.collect.Range;
import pl.psi.battleengine.creatures.CreatureStack;

public class AttackBuff implements Mechanics {
    @Override
    public int buff(CreatureStack aCaster, CreatureStack aTarget, int value) {
        return 2;
    }
}
