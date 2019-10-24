package pl.psi.battleengine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {

    @Test
    void attackedCreatureShouldLostTwoHp(){
        //given
        Creature centaur = new Creature("centaur",10,5,3);
        Creature imp = new Creature("imp", 5,2,2);
        //when
        centaur.attack(imp);
        //then
        assertEquals(2, imp.getCurrentHp());
    }
}