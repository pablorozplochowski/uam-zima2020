package pl.psi.battleengine.creatures;

import com.google.common.collect.Range;
import lombok.Builder;
import pl.psi.CreatureStatistic;
import pl.psi.battleengine.move.GuiTileIf;

public class CreatureStack implements GuiTileIf {


    private boolean counterAttackedInThisTurn;
    private int currentHp;
    private int amount;
    private final CreatureStatistic statistic;
    private DealDamageStrategyIf dealDamageStrategy;

    @Builder
    public CreatureStack(String aName, int aMaxHp, Range<Integer> aAttack, int aDefence, int aMoveRange, Range<Integer> aHeal, DealDamageStrategyIf aStrategy) {
        statistic = CreatureStatistic.builder().aName(aName).aMaxHp(aMaxHp).aAttack(aAttack).aDefence(aDefence).aMoveRange(aMoveRange).aHeal(aHeal).build();
        currentHp = statistic.getMaxHp();
        dealDamageStrategy = aStrategy;
    }

    public CreatureStack(CreatureStatistic aStatistic, Integer aAmount) {
        amount = aAmount;
        statistic = aStatistic;
        currentHp = statistic.getMaxHp();
    }

    public void attack(CreatureStack aDefender) {
        dealDamage(aDefender);
        aDefender.counterAttack(this);
    }

    private void counterAttack(CreatureStack aDefender){
        if(!counterAttackedInThisTurn){
            dealDamage(aDefender);
            counterAttackedInThisTurn = true;
        }
    }

    protected void dealDamage(CreatureStack aDefender) {
        int damage = dealDamageStrategy.dealDamage(this, aDefender);
        aDefender.currentHp -= damage;
    }

    public void heal(CreatureStack aPatient) {
        throw new UnsupportedOperationException("Only HealingCreatureStack can use this method");
    }

    public void isHealAllow(){

    }

    protected void healDamage(CreatureStack aPatient) {
        //int damage = HealDamageStrategy.dealDamage(this, aPatient);
        //aPatient.currentHp += damage;
    }

    public void gainLife(int damage){
        this.currentHp += damage;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public CreatureStatistic getStatistic() {
        return statistic;
    }

    public double getAttackRange() {
        return 1.0;
    }

    public int getMaxHp() {
        return getStatistic().getMaxHp();
    }

    public int getDefence() {
        return getStatistic().getDefence();
    }

    public Range<Integer> getAttack() {
        return getStatistic().getAttack();
    }

    public Range<Integer> getHeal() {
        return getStatistic().getHeal();
    }

    public String getName() {
        return getStatistic().getName();
    }

    public int getMoveRange() {
        return getStatistic().getMoveRange();
    }

    int getAmount() {
        return amount;
    }

    @Override
    public String getIcon() {
        StringBuilder sb = new StringBuilder(getName());
        sb.append(System.lineSeparator());
        sb.append("  ");
        sb.append(getAmount());
        sb.append(System.lineSeparator());
        sb.append(getCurrentHp());
        sb.append(" / ");
        sb.append(getMaxHp());
        return sb.toString();
    }
}
