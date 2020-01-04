package pl.psi.battleengine.creatures;

import com.google.common.collect.Range;
import lombok.Builder;

public class StatisticBuffs {

    public  int maxHp;
    public  int defence;
    public  Range<Integer> attack;
    public  int moveRange;

    @Builder
    StatisticBuffs() {
        maxHp = 0;
        defence = 0;
        attack = Range.closed(0,0);
        moveRange = 0;
    }
}

