package pl.psi.battleengine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    private Creature centaur;
    private Creature imp;

    @BeforeEach
    void init(){
        centaur = new Creature("centaur",10,5,3);
        imp = new Creature("imp", 5,2,2);
    }

    @Test
    void attackedImpShouldLostThreeHp(){
        //given

        //when
        centaur.attack(imp);
        //then
        assertEquals(2, imp.getCurrentHp());
    }

    @Test
    void attackedCentaurShouldLost(){
        imp.attack(centaur);

        assertEquals(9, centaur.getCurrentHp());
    }

    @Test
    void attackedCentaurShouldCounterAttack(){
        imp.attack(centaur);

        assertEquals(2, imp.getCurrentHp());
    }
}