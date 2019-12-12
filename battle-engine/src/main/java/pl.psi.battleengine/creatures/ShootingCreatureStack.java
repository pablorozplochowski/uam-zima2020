package pl.psi.battleengine.creatures;

import com.google.common.collect.Range;

public class ShootingCreatureStack extends CreatureStack {
    ShootingCreatureStack(String aName, int aMaxHp, Range<Integer> aAttack, int aDefence, int aMoveRange) {
        super(aName, aMaxHp, aAttack, aDefence, aMoveRange);
    }

    @Override
    void attack(CreatureStack aDefender) {
        dealDamage(aDefender);
    }
}
