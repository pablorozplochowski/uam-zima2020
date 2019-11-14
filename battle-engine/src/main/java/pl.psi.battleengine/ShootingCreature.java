package pl.psi.battleengine;

class ShootingCreature extends Creature{
    ShootingCreature(String aName, int aMaxHp, int aAttack, int aDefence, int aMoveRange) {
        super(aName, aMaxHp, aAttack, aDefence, aMoveRange);
    }

    @Override
    void attack(Creature aDefender) {
        dealDamage(aDefender);
    }
}
