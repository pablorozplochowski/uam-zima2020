package pl.psi.battleengine.creatures;

import java.util.concurrent.ThreadLocalRandom;

class LifeStealDamageStrategy implements DealDamageStrategyIf {
    @Override
    public int dealDamage(CreatureStack aAttacker, CreatureStack aDefender) {
        int damage = ThreadLocalRandom.current().nextInt(aAttacker.getAttack().lowerEndpoint(), aAttacker.getAttack().upperEndpoint() + 1);
        if (aDefender.getDefence() >= damage){
            damage = 1;
        }
        aAttacker.gainLife(damage);
        return damage;
    }
}
