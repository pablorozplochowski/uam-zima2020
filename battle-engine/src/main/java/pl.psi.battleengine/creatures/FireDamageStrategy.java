package pl.psi.battleengine.creatures;

import java.util.concurrent.ThreadLocalRandom;

class FireDamageStrategy implements DealDamageStrategyIf {
    @Override
    public int dealDamage(CreatureStack aAttacker, CreatureStack aDefender) {
        return ThreadLocalRandom.current().nextInt(aAttacker.getAttack().lowerEndpoint(), aAttacker.getAttack().upperEndpoint() + 1);
    }
}
