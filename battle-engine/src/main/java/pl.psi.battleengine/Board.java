package pl.psi.battleengine;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class Board {

    private Map<Point,GuiTileIf> board;
    public final static int WIDTH = 14;
    public final static int HEIGHT = 10;

    Board() {
        board = new HashMap<>();
    }

    void put(Point aPoint, GuiTileIf aCreature) {
        if (board.containsKey(aPoint)){
            throw new IllegalArgumentException("Tile isn't empty");
        }
        board.put(aPoint,aCreature);
    }


    GuiTileIf getByPoint(Point aPoint) {
        return board.get(aPoint);
    }

    Point getByCreature(Creature aCurrentCreature) {
        for (Map.Entry<Point, GuiTileIf> entry : board.entrySet()) {
            if (entry.getValue().equals(aCurrentCreature)) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("Creature is missing in board!");
    }

    boolean isEmpty(Point aPoint) {
        return !board.containsKey(aPoint);
    }

    void remove(Point aPoint) {
        board.remove(aPoint);
    }
}
