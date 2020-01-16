package pl.psi.battleengine.healengine;

import pl.psi.battleengine.BattleEngine;
import pl.psi.battleengine.Board;
import pl.psi.battleengine.creatures.CreatureStack;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class HealingEngine implements PropertyChangeListener {

    private HashMap.Entry<Point, CreatureStack> activeCreature;
    private final Board board;

    public HealingEngine(Board aBoard, BattleEngine aBattleEngine) {
        board = aBoard;
        aBattleEngine.registerObserver(BattleEngine.ACTIVE_CREATURE_CHANGED, this);
    }

    public boolean isHealAllowed(Point aPoint) {
        if ( activeCreature.getValue().getHeal().upperEndpoint() <= 0){
            return false;
        }
        return isHealRangeEnought(aPoint) && !board.isEmpty(aPoint);
    }

    public void heal(Point aPoint){
        activeCreature.getValue().heal(board.getCreatureByPoint(aPoint));
    }

    private boolean isHealRangeEnought(Point aPoint) {
        return Point.distance(activeCreature.getKey().getX(), activeCreature.getKey().getY(), aPoint.getX(), aPoint.getY()) <= activeCreature.getValue().getAttackRange();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aEvt) {
        activeCreature = (HashMap.Entry<Point, CreatureStack>) aEvt.getNewValue();
    }
}
