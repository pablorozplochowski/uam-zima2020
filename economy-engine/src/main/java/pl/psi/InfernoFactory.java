package pl.psi;

import com.google.common.collect.Range;

public class InfernoFactory extends AbstractFactionFactory {

    @Override
    public CreatureStatistic createByTier(int aTier) {
        if (aTier == 1) {
            CreatureStatistic imp = new CreatureStatistic(4,3, Range.closed(1,2),"Imp",5,Range.closed(0,0));
            return imp;
        }
        if (aTier == 2) {
            CreatureStatistic jailer = new CreatureStatistic(13,4, Range.closed(2,4),"Jailer",4,Range.closed(0,0));
            return jailer;
        }
        if (aTier == 3) {
            CreatureStatistic hellhound = new CreatureStatistic(25,6, Range.closed(2,7),"Hellhound",7,Range.closed(0,0));
            return hellhound;
        }
        if (aTier == 4) {
            CreatureStatistic gargoyle = new CreatureStatistic(35,10, Range.closed(7,9),"Gargoyle",5,Range.closed(0,0));
            return gargoyle;
        }
        if (aTier == 5) {
            CreatureStatistic flamingChariot = new CreatureStatistic(45,13, Range.closed(13,17),"Flaming Chariot",7,Range.closed(0,0));
            return flamingChariot;
        }
        if (aTier == 6) {
            CreatureStatistic demon = new CreatureStatistic(90,12, Range.closed(16,24),"Demon",9,Range.closed(0,0));
            return demon;
        }
        if (aTier == 7) {
            CreatureStatistic corruptedDragon = new CreatureStatistic(160,21, Range.closed(30,40),"Corrupted Dragon",10,Range.closed(0,0));
            return corruptedDragon;
        }
        else throw new IllegalArgumentException("There is no such tier. Select number from 1 to 7");
    }
}
