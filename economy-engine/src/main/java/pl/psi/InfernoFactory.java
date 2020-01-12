package pl.psi;

import com.google.common.collect.Range;

public class InfernoFactory extends AbstractFactionFactory {

    @Override
    public CreatureStatistic createByTier(int aTier) {
        if (aTier == 1) {
            CreatureStatistic imp = new CreatureStatistic(15,5, Range.closed(2,10),"Imp",6,Range.closed(2,5));
            return imp;
        }
        if (aTier == 2) {
            CreatureStatistic hellhound = new CreatureStatistic(15,5, Range.closed(2,10),"Hellhound",6,Range.closed(2,5));
            return hellhound;
        }
        if (aTier == 3) {
            CreatureStatistic jailer = new CreatureStatistic(15,5, Range.closed(2,10),"Jailer",6,Range.closed(2,5));
            return jailer;
        }
        if (aTier == 4) {
            CreatureStatistic gargoyle = new CreatureStatistic(15,5, Range.closed(2,10),"Gargoyle",6,Range.closed(2,5));
            return gargoyle;
        }
        if (aTier == 5) {
            CreatureStatistic flamingChariot = new CreatureStatistic(15,5, Range.closed(2,10),"Flaming Chariot",6,Range.closed(2,5));
            return flamingChariot;
        }
        if (aTier == 6) {
            CreatureStatistic demon = new CreatureStatistic(15,5, Range.closed(2,10),"Demon",6,Range.closed(2,5));
            return demon;
        }
        if (aTier == 7) {
            CreatureStatistic corruptedDragon = new CreatureStatistic(15,5, Range.closed(2,10),"Corrupted Dragon",6,Range.closed(2,5));
            return corruptedDragon;
        }
        else throw new IllegalArgumentException("There is no such tier. Select number from 1 to 7");
    }
}
