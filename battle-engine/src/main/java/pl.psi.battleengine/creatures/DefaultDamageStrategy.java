package pl.psi.battleengine.creatures;

class DefaultDamageStrategy implements DealDamageStrategyIf {
    @Override
    public int dealDamage(CreatureStack aAttacker, CreatureStack aDefender) {
        int damage;
        if (aDefender.getDefence() >= aAttacker.getAttack().lowerEndpoint()){
            damage = 1;
        }
        else{
            damage = aAttacker.getAttack().lowerEndpoint()-aDefender.getDefence();
        }
        return damage;
    }
}
