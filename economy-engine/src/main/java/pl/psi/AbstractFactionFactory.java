package pl.psi;

abstract class AbstractFactionFactory {
    public static AbstractFactionFactory getFactory(String aFractionName) throws IllegalArgumentException {
        if (aFractionName.equals("INFERNO")) {
            AbstractFactionFactory infernoFactory = new InfernoFactory();
            return infernoFactory;
        }
        else throw new IllegalArgumentException("There is no faction with this name");
    }

    public abstract CreatureStatistic createByTier(int aTier);
}
