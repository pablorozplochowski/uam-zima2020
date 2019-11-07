package pl.psi.battleengine;

import lombok.AllArgsConstructor;
import lombok.Builder;

class Creature implements GuiTileIf{

    private final int maxHp;
    private int currentHp;
    private final int defence;
    private final int attack;
    private final String name;
    private boolean counterAttackedInThisTurn;

    @Builder
    Creature(String aName, int aMaxHp, int aAttack, int aDefence) {
        maxHp = aMaxHp;
        currentHp = maxHp;
        defence = aDefence;
        attack = aAttack;
        name = aName;
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
}
