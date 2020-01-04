package pl.psi.battleengine.spellbook;

import pl.psi.battleengine.creatures.CreatureStack;

public interface Mechanics{
    int buff(CreatureStack aCaster, CreatureStack aTarget, int value);
}
