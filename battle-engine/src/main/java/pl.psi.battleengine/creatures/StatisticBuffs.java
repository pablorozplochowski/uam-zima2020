package pl.psi.battleengine.creatures;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class StatisticBuffs {

    @Getter @Setter private int maxHp;
    @Getter @Setter private int defence;
    @Getter @Setter private Range<Integer> attack;
    @Getter @Setter private int moveRange;

    public StatisticBuffs() {
        maxHp = 0;
        defence = 0;
        attack = Range.closed(0, 0);
        moveRange = 0;
    }

    @Builder
    public StatisticBuffs(int aMaxHp, int aDefence, Range aAttack, int aMoveRange) {
        maxHp = aMaxHp;
        defence = aDefence;
        attack = aAttack;
        moveRange = aMoveRange;
    }

}

