package pl.psi.battleengine;


class Creature {

    private final int maxHp;
    private int currentHp;
    private final int defence;
    private final int attack;
    private final String name;

    Creature(String aName, int aMaxHp, int aAttack, int aDefence) {
        maxHp = aMaxHp;
        currentHp = maxHp;
        defence = aDefence;
        attack = aAttack;
        name = aName;
    }

    void attack(Creature aDefender) {
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
}
