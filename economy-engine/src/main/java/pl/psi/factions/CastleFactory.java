package pl.psi.factions;

import com.google.common.collect.Range;
import pl.psi.CreatureStatistic;

public class CastleFactory extends AbstractFactionFactory {

    @Override
    public CreatureStatistic createByTier(int aTier) {
        if (aTier == 1) {
            CreatureStatistic soldier = new CreatureStatistic(10, 5, Range.closed(1, 3), "Soldier", 4, Range.closed(0, 0));
            return soldier;
        }
        if (aTier == 2) {
            CreatureStatistic archer = new CreatureStatistic(10, 5, Range.closed(2, 3), "Archer", 5, Range.closed(0, 0));
            return archer;
        }
        if (aTier == 3) {
            CreatureStatistic priest = new CreatureStatistic(20, 4, Range.closed(3, 6), "Priest", 6, Range.closed(4, 6));
            return priest;
        }
        if (aTier == 4) {
            CreatureStatistic knight = new CreatureStatistic(35, 12, Range.closed(6, 9), "Knight", 5, Range.closed(0, 0));
            return knight;
        }
        if (aTier == 5) {
            CreatureStatistic cavalier = new CreatureStatistic(50, 12, Range.closed(10, 12), "Cavalier", 7, Range.closed(0, 0));
            return cavalier;
        }
        if (aTier == 6) {
            CreatureStatistic gryffin = new CreatureStatistic(100, 15, Range.closed(20, 25), "Gryffin", 8, Range.closed(0, 0));
            return gryffin;
        }
        if (aTier == 7) {
            CreatureStatistic dragon = new CreatureStatistic(200, 20, Range.closed(50, 50), "Dragon", 12, Range.closed(0, 0));
            return dragon;
        } else throw new IllegalArgumentException("There is no such tier. Select number from 1 to 7");
    }
}
