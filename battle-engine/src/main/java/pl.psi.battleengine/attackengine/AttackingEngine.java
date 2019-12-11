package pl.psi.battleengine.attackengine;

import pl.psi.battleengine.BattleEngine;
import pl.psi.battleengine.Board;
import pl.psi.battleengine.creatures.CreatureStack;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class AttackingEngine implements PropertyChangeListener {

    private HashMap.Entry<Point, CreatureStack> activeCreature;
    private final Board board;

    public AttackingEngine(Board aBoard, BattleEngine aBattleEngine) {
        board = aBoard;
        aBattleEngine.registerObserver(BattleEngine.ACTIVE_CREATURE_CHANGED, this);
    }

    public boolean isAttackAllowed(Point aPoint) {
        return isAttackRangeEnought(aPoint) && !board.isEmpty(aPoint);
    }

    private boolean isAttackRangeEnought(Point aPoint) {
        return Point.distance(activeCreature.getKey().getX(), activeCreature.getKey().getY(), aPoint.getX(), aPoint.getY()) <= activeCreature.getValue().getAttackRange();
    }

    @Override
    public void propertyChange(PropertyChangeEvent aEvt) {
        activeCreature = (HashMap.Entry<Point, CreatureStack>) aEvt.getNewValue();
    }
}
