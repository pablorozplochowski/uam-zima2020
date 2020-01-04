package pl.psi.battleengine;

import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.move.GuiTileIf;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private Map<Point,GuiTileIf> board;
    public final static int WIDTH = 14;
    public final static int HEIGHT = 10;

    Board() {
        board = new HashMap<>();
    }

    public void put(Point aPoint, GuiTileIf aCreature) {
        if (board.containsKey(aPoint)){
            throw new IllegalArgumentException("Tile isn't empty");
        }
        board.put(aPoint,aCreature);
    }


    GuiTileIf getByPoint(Point aPoint) {
        return board.get(aPoint);
    }

    public CreatureStack getCreatureByPoint(Point aPoint) {
        GuiTileIf potencialCreature = board.get(aPoint);
        if (potencialCreature == null){
            throw new IllegalArgumentException("Field is empty");
        }
        else if (!(potencialCreature instanceof CreatureStack)){
            throw new IllegalArgumentException("Is not a creature");
        }
        return (CreatureStack) board.get(aPoint);
    }

    Point getByCreature(CreatureStack aCurrentCreatureStack) {
        for (Map.Entry<Point, GuiTileIf> entry : board.entrySet()) {
            if (entry.getValue().equals(aCurrentCreatureStack)) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("CreatureStack is missing in board!");
    }

    public boolean isEmpty(Point aPoint) {
        return !board.containsKey(aPoint);
    }

    public void remove(Point aPoint) {
        board.remove(aPoint);
    }

    public boolean hasCreature(Point aPoint) {
        return getCreatureByPoint(aPoint) != null;
    }
}
