package pl.psi.battleengine.creatures;

import java.util.concurrent.ThreadLocalRandom;

class HealDamageStrategy implements DealDamageStrategyIf {
    @Override
    public int dealDamage(CreatureStack aAttacker, CreatureStack aDefender) {
        int damage = ThreadLocalRandom.current().nextInt(aAttacker.getHeal().lowerEndpoint(), aAttacker.getHeal().upperEndpoint() + 1);
        return damage;
    }
}
