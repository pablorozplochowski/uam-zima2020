package pl.psi.factions;

import com.google.common.collect.Range;
import pl.psi.CreatureStatistic;

public class NecropolisFactory extends AbstractFactionFactory {

    @Override
    public CreatureStatistic createByTier(int aTier) {
        if (aTier == 1) {
            CreatureStatistic skeleton = new CreatureStatistic(6, 4, Range.closed(1, 3), "Skeleton", 4, Range.closed(0, 0));
            return skeleton;
        }
        if (aTier == 2) {
            CreatureStatistic zombie = new CreatureStatistic(15, 5, Range.closed(2, 3), "Zombie", 3, Range.closed(0, 0));
            return zombie;
        }
        if (aTier == 3) {
            CreatureStatistic vampyr = new CreatureStatistic(20, 5, Range.closed(3, 5), "Vampyr", 7, Range.closed(0, 0));
            return vampyr;
        }
        if (aTier == 4) {
            CreatureStatistic necromancer = new CreatureStatistic(30, 9, Range.closed(5, 8), "Necromancer", 5, Range.closed(0, 0));
            return necromancer;
        }
        if (aTier == 5) {
            CreatureStatistic meatWagon = new CreatureStatistic(40, 10, Range.closed(11, 15), "Meat Wagon", 7, Range.closed(0, 0));
            return meatWagon;
        }
        if (aTier == 6) {
            CreatureStatistic lich = new CreatureStatistic(120, 16, Range.closed(15, 30), "Lich", 7, Range.closed(0, 0));
            return lich;
        }
        if (aTier == 7) {
            CreatureStatistic undeadDragon = new CreatureStatistic(150, 15, Range.closed(25, 50), "Undead Dragon", 9, Range.closed(0, 0));
            return undeadDragon;
        } else throw new IllegalArgumentException("There is no such tier. Select number from 1 to 7");
    }
}
