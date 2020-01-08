package pl.psi.battleengine.spellbook;

import pl.psi.battleengine.creatures.CreatureStack;

public class Effects {
    private int value;
    private int duration;
    private Mechanics mechanic;

    public Effects(int aValue, int aDuration, Mechanics aMechanic){
        value = aValue;
        duration = aDuration;
        mechanic = aMechanic;
    }

    public void execute(CreatureStack aCreature, CreatureStack aTarget){
        duration--;
        if(duration >= 0) mechanic.buff(aCreature,aTarget,value);
    }
}
