package pl.psi.battleengine.spellbook;

import pl.psi.battleengine.creatures.CreatureStack;

public interface Mechanics{
    void action(CreatureStack aCaster, CreatureStack aTarget, int value);
}
