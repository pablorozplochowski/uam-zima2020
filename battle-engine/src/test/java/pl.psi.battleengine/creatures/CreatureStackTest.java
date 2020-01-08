package pl.psi.battleengine.creatures;

import com.google.common.collect.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreatureStackTest {

    private CreatureStack centaur;
    private CreatureStack imp;
    private  CreatureStack stronkImp;
    private  CreatureStack tank;
    private DealDamageStrategyIf strategy;


    @BeforeEach
    void init(){
        strategy = new DefaultDamageStrategy();
        centaur = CreatureStack.builder()
                .aName("centaur")
                .aMaxHp(10)
                .aAttack(Range.closed(5,10))
                .aDefence(3)
                .aStrategy(strategy)
                .aHeal(Range.closed(3,4))
                .build();
        imp = new CreatureStack("imp", 5,Range.closed(2,10),2, 0, Range.closed(0,0),strategy);
        stronkImp = new CreatureStack("simp", 15,Range.closed(0,0),2, 0, Range.closed(0,0), strategy);
        tank = CreatureStack.builder()
                .aName("tank")
                .aMaxHp(10)
                .aAttack(Range.closed(1,1))
                .aDefence(20)
                .aStrategy(strategy)
                .build();
    }

    @Test
    void attackedImpShouldLostMinimumThreeHp(){
        //given

        //when
        centaur.attack(imp);
        //then
        //assertEquals(2, imp.getCurrentHp());
        assertTrue(imp.getCurrentHp() <=2);
    }

    @Test
    void attackedCentaurShouldLost(){
        imp.attack(centaur);

        //assertEquals(9, centaur.getCurrentHp());
        assertTrue(centaur.getCurrentHp() <= 9 && centaur.getCurrentHp() >= 3);
    }

    @Test
    void attackedCentaurShouldCounterAttack(){
        imp.attack(centaur);

        //assertEquals(2, imp.getCurrentHp());
        assertTrue(imp.getCurrentHp() <=2);
    }

    @Test
    void defenderShouldCounterAttackOnlyOnce(){
        imp.attack(tank);
        imp.attack(tank);

        assertEquals(4, imp.getCurrentHp());
    }

    @Test
    void shooterCouldNotBeCaunterAttacked(){
        ShootingCreatureStack shooter = new ShootingCreatureStack("centaur",10,Range.closed(5,10),3, 0, Range.closed(0,0), strategy);
        shooter.attack(imp);

        assertEquals(shooter.getMaxHp(), shooter.getCurrentHp());
    }

    @Test
    void randomStrategyTest(){

    }

    @Test
    void ShouldAttackWithDefaultStrategy(){
        centaur.attack(stronkImp);
        centaur.attack(tank);

        assertTrue( stronkImp.getCurrentHp() >= 7 && stronkImp.getCurrentHp() <= 12);
        assertEquals(9, tank.getCurrentHp());
    }

    @Test
    void ShouldAttackWithFireStrategy(){
        FireDamageStrategy fireStrat = new FireDamageStrategy();
        CreatureStack fireImp = CreatureStack.builder().aAttack(Range.closed(5,10)).aStrategy(fireStrat).build();
        fireImp.attack(stronkImp);
        fireImp.attack(tank);

        assertTrue( stronkImp.getCurrentHp() >= 5 && stronkImp.getCurrentHp() <= 10);
        assertTrue( tank.getCurrentHp() >= 0 && tank.getCurrentHp() <= 5);
    }

    @Test
    void ShouldAttackWithLifeStealStrategy(){
        LifeStealDamageStrategy lsStrat = new LifeStealDamageStrategy();
        CreatureStack undead = CreatureStack.builder().aMaxHp(20).aAttack(Range.closed(5,10)).aStrategy(lsStrat).build();
        centaur.attack(undead);
        undead.attack(stronkImp);

        assertTrue( stronkImp.getCurrentHp() >= 5 && stronkImp.getCurrentHp() <= 10);
        assertTrue( undead.getCurrentHp() >= 15 && tank.getCurrentHp() <= 20);
    }

    @Test
    void ShouldHealCorrectly(){
        centaur.attack(stronkImp);
        centaur.heal(stronkImp);

        assertTrue(stronkImp.getCurrentHp() >=8 && stronkImp.getCurrentHp() <=14);
    }
}