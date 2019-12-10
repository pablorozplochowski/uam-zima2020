package pl.psi.battleengine.creatures;

public class ShootingCreatureStack extends CreatureStack {
    ShootingCreatureStack(String aName, int aMaxHp, int aAttack, int aDefence, int aMoveRange) {
        super(aName, aMaxHp, aAttack, aDefence, aMoveRange);
    }

    @Override
    void attack(CreatureStack aDefender) {
        dealDamage(aDefender);
    }
}
