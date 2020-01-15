package pl.psi.battleengine.creatures;

import com.google.common.collect.Range;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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
    @Getter
    private List<Spell> spells;

    @Builder
    public CreatureStack(String aName, int aMaxHp, Range<Integer> aAttack, int aDefence, int aMoveRange) {
        statistic = CreatureStatistic.builder().aName(aName).aMaxHp(aMaxHp).aAttack(aAttack).aDefence(aDefence).aMoveRange(aMoveRange).build();
        currentHp = statistic.getMaxHp();
        dealDamageStrategy = new DefaultDamageStrategy();
        spells = new Vector<Spell>();
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

    public void setCurrentHp(int aCurrentHp) { currentHp = aCurrentHp;}

    public CreatureStatistic getStatistic() {
        return statistic;
    }

    public double getAttackRange() {
        return 1.0;
    }

    public int getMaxHp() {
        int buff = 0;
        for(Spell spell : spells) buff += spell.getBuffs().getMaxHp();
        return getStatistic().getMaxHp() + buff;
    }

    public int getDefence() {
        int buff = 0;
        for(Spell spell : spells) buff += spell.getBuffs().getDefence();
        return getStatistic().getDefence() + buff;
    }

    public Range<Integer> getAttack() {
        int lowerBuff = 0, upperBuff = 0;
        for(Spell spell : spells) {
            lowerBuff  += spell.getBuffs().getAttack().lowerEndpoint();
            upperBuff += spell.getBuffs().getAttack().upperEndpoint();
        }
        return Range.closed(getStatistic().getAttack().lowerEndpoint() + lowerBuff, getStatistic().getAttack().upperEndpoint() + upperBuff);
    }

    public String getName() {
        return getStatistic().getName();
    }

    public int getMoveRange() {
        int buff = 0;
        for(Spell spell : spells) buff += spell.getBuffs().getMoveRange();
        return getStatistic().getMoveRange() + buff;
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
