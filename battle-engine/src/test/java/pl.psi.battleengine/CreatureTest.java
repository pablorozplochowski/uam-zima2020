package pl.psi.battleengine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    @Test
    void attackedImpShouldLostThreeHp(){
        //given
        Creature centaur = new Creature("centaur",10,5,3);
        Creature imp = new Creature("imp", 5,2,2);
        //when
        centaur.attack(imp);
        //then
        assertEquals(2, imp.getCurrentHp());
    }

    @Test
    void attackedCentaurShouldLost(){
        Creature centaur = new Creature("centaur",10,5,3);
        Creature imp = new Creature("imp", 5,2,2);

        imp.attack(centaur);

        assertEquals(9, centaur.getCurrentHp());
    }
}