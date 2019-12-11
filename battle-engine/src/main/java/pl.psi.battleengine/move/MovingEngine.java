package pl.psi.battleengine.move;


import pl.psi.battleengine.BattleEngine;
import pl.psi.battleengine.Board;
import pl.psi.battleengine.creatures.CreatureStack;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

public class MovingEngine implements PropertyChangeListener{

    private final Board board;
    private HashMap.Entry<Point, CreatureStack> currentCreature;

    public MovingEngine(Board aBoard, BattleEngine aBattleEngine) {
        board = aBoard;
        aBattleEngine.registerObserver(BattleEngine.ACTIVE_CREATURE_CHANGED, this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent aEvt) {
        currentCreature = (HashMap.Entry<Point, CreatureStack>) aEvt.getNewValue();
    }

    public boolean isMoveAllowed(Point aPoint) {
        return isMoveRangeEnought(aPoint) && board.isEmpty(aPoint);
    }

    private boolean isMoveRangeEnought(Point aPoint) {
        return Point.distance(currentCreature.getKey().getX(),currentCreature.getKey().getY(), aPoint.getX(),aPoint.getY()) <= currentCreature.getValue().getMoveRange();
    }

    public void move(int aX, int aY) {
        if (!isMoveAllowed(new Point(aX, aY))) {
            throw new IllegalArgumentException("To small move range!");
        }

        board.remove(currentCreature.getKey());
        board.put(new Point(aX, aY), currentCreature.getValue());
    }
}
