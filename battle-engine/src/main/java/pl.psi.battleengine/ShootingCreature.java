package pl.psi.battleengine;

class ShootingCreature extends Creature{
    ShootingCreature(String aName, int aMaxHp, int aAttack, int aDefence) {
        super(aName, aMaxHp, aAttack, aDefence);
    }

    @Override
    void attack(Creature aDefender) {
        dealDamage(aDefender);
    }
}
