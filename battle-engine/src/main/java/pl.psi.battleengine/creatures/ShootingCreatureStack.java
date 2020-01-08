package pl.psi.battleengine.creatures;

import com.google.common.collect.Range;

public class ShootingCreatureStack extends CreatureStack {
    ShootingCreatureStack(String aName, int aMaxHp, Range<Integer> aAttack, int aDefence, int aMoveRange, Range<Integer> aHeal, DealDamageStrategyIf aStrategy) {
        super(aName, aMaxHp, aAttack, aDefence, aMoveRange, aHeal, aStrategy);
    }

    @Override
    public void attack(CreatureStack aDefender) {
        dealDamage(aDefender);
    }
}
