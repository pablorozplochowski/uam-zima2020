package pl.psi.battleengine.creatures;

import com.google.common.collect.Range;
import lombok.Builder;
import pl.psi.CreatureStatistic;
import pl.psi.battleengine.move.GuiTileIf;
import pl.psi.battleengine.spellbook.Spell;

import java.util.List;
import java.util.Vector;

public class CreatureStack implements GuiTileIf {


    private boolean counterAttackedInThisTurn;
    private int currentHp;
    private int amount;
    private final CreatureStatistic statistic;
    private DealDamageStrategyIf dealDamageStrategy;
    private List<Spell> spells;
    public StatisticBuffs buffs;

    @Builder
    public CreatureStack(String aName, int aMaxHp, Range<Integer> aAttack, int aDefence, int aMoveRange) {
        statistic = CreatureStatistic.builder().aName(aName).aMaxHp(aMaxHp).aAttack(aAttack).aDefence(aDefence).aMoveRange(aMoveRange).build();
        currentHp = statistic.getMaxHp();
        dealDamageStrategy = new DefaultDamageStrategy();
        spells = new Vector<Spell>();
        buffs = new StatisticBuffs();
    }

    public CreatureStack(CreatureStatistic aStatistic, Integer aAmount) {
        amount = aAmount;
        statistic = aStatistic;
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
        return getStatistic().getMaxHp() + buffs.maxHp;
    }

    public int getDefence() {
        return getStatistic().getDefence() + buffs.defence;
    }

    public Range<Integer> getAttack() {
        return Range.closed(getStatistic().getAttack().lowerEndpoint() + buffs.attack.lowerEndpoint(), getStatistic().getAttack().upperEndpoint() + buffs.attack.upperEndpoint());
    }

    public String getName() {
        return getStatistic().getName();
    }

    public int getMoveRange() {
        return getStatistic().getMoveRange() + buffs.moveRange;
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
