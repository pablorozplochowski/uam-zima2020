package pl.psi.battleengine.creatures;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class StatisticBuffs {

    @Getter @Setter public  int maxHp;
    @Getter @Setter public  int defence;
    @Getter @Setter public  Range<Integer> attack;
    @Getter @Setter public  int moveRange;

    @Builder
    StatisticBuffs() {
        maxHp = 0;
        defence = 0;
        attack = Range.closed(0, 0);
        moveRange = 0;
    }
}

