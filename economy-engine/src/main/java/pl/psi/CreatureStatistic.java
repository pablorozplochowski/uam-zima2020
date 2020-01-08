package pl.psi;

import com.google.common.collect.Range;
import lombok.Builder;

public class CreatureStatistic {

    private final int maxHp;
    private final int defence;
    private final Range<Integer> attack;
    private final String name;
    private final int moveRange;

    @Builder
    CreatureStatistic(int aMaxHp, int aDefence, Range<Integer> aAttack, String aName, int aMoveRange) {
        maxHp = aMaxHp;
        defence = aDefence;
        attack = aAttack;
        name = aName;
        moveRange = aMoveRange;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getDefence() {
        return defence;
    }

    public Range<Integer> getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }

    public int getMoveRange() {
        return moveRange;
    }

    public void testPush(){
        int i = 0;
        i++;
    }
}
