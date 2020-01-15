package pl.psi.battleengine.spellbook;

public class DefenceAndMoveRangeBuffSpell extends Spell {
    public DefenceAndMoveRangeBuffSpell(String aName, int aDefence, int aMoveRange){
        super(aName);
        buffs.setMoveRange(aMoveRange);
        buffs.setDefence(aDefence);
    }
}
