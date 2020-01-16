package pl.psi.factions;

import pl.psi.CreatureStatistic;

public abstract class AbstractFactionFactory {
    public static AbstractFactionFactory getFactory(String aFractionName) throws IllegalArgumentException {
        if (aFractionName.equals("INFERNO")) {
            AbstractFactionFactory infernoFactory = new InfernoFactory();
            return infernoFactory;
        }
        if (aFractionName.equals("NECROPOLIS")) {
            AbstractFactionFactory necropolisFactory = new NecropolisFactory();
            return necropolisFactory;
        }
        if (aFractionName.equals("CASTLE")) {
            AbstractFactionFactory castleFactory = new CastleFactory();
            return castleFactory;
        } else throw new IllegalArgumentException("There is no faction with this name");
    }

    public abstract CreatureStatistic createByTier(int aTier);
}
