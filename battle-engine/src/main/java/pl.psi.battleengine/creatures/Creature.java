package pl.psi.battleengine.creatures;

import lombok.Builder;
import pl.psi.battleengine.move.GuiTileIf;

public class Creature implements GuiTileIf {

    private final int maxHp;
    private int currentHp;
    private final int defence;
    private final int attack;
    private final String name;
    private boolean counterAttackedInThisTurn;
    private final int moveRange;

    @Builder
    Creature(String aName, int aMaxHp, int aAttack, int aDefence, int aMoveRange) {
        maxHp = aMaxHp;
        currentHp = maxHp;
        defence = aDefence;
        attack = aAttack;
        name = aName;
        moveRange = aMoveRange;
    }

    void attack(Creature aDefender) {
        dealDamage(aDefender);
        aDefender.counterAttack(this);
    }

    private void counterAttack(Creature aDefender){
        if(!counterAttackedInThisTurn){
            dealDamage(aDefender);
            counterAttackedInThisTurn = true;
        }
    }

    protected void dealDamage(Creature aDefender) {
        int damage;
        if (aDefender.defence >= attack){
            damage = 1;
        }
        else{
            damage = attack-aDefender.defence;
        }
        aDefender.currentHp -= damage;
    }

    int getCurrentHp() {
        return currentHp;
    }

    int getMaxHp() {
        return maxHp;
    }

    @Override
    public String getIcon() {
        return name;
    }

    String getName() {
        return name;
    }

    int getMoveRange() {
        return moveRange;
    }

    double getAttackRange() {
        return 1.0;
    }
}
