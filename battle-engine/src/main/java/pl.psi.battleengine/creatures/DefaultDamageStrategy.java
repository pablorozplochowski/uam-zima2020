package pl.psi.battleengine.creatures;

import java.util.concurrent.ThreadLocalRandom;

class DefaultDamageStrategy implements DealDamageStrategyIf {
    @Override
    public int dealDamage(CreatureStack aAttacker, CreatureStack aDefender) {
        int damage = ThreadLocalRandom.current().nextInt(aAttacker.getAttack().lowerEndpoint(), aAttacker.getAttack().upperEndpoint() + 1);
        if (aDefender.getDefence() >= damage){
            damage = 1;
        }
        else{
            damage -= aDefender.getDefence();
        }
        return damage;
    }
}
