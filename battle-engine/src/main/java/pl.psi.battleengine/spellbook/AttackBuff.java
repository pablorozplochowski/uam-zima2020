package pl.psi.battleengine.spellbook;

import com.google.common.collect.Range;
import pl.psi.battleengine.creatures.CreatureStack;

public class AttackBuff implements Mechanics {
    @Override
    public int buff(CreatureStack aCaster, CreatureStack aTarget, int value) {/*
        int base_lower_attack = aCaster.getAttack().lowerEndpoint();
        int base_upper_attack = aCaster.getAttack().upperEndpoint();
        int attack_low = base_lower_attack;
        int attack_up = base_upper_attack;

        for(AttackBuffIf buff : attackSpells){

            attack_low += buff.getBuff(base_lower_attack);
            attack_up += buff.getBuff(base_upper_attack);

        }

        return Range.closed(attack_low, attack_up).lowerEndpoint();*/
        return 2;
    }
}
