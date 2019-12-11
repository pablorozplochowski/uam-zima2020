package pl.psi;

import lombok.Builder;

public class CreatureStatistic {

    private final int maxHp;
    private final int defence;
    private final int attack;
    private final String name;
    private final int moveRange;

    @Builder
    CreatureStatistic(int aMaxHp, int aDefence, int aAttack, String aName, int aMoveRange) {
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

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }

    public int getMoveRange() {
        return moveRange;
    }
}
