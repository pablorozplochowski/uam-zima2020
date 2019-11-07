package pl.psi.battleengine;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class Board {

    private Map<Point,GuiTileIf> board;

    Board() {
        board = new HashMap<>();
    }

    void put(Point aPoint, GuiTileIf aCreature) {
        board.put(aPoint,aCreature);
    }


    GuiTileIf getByPoint(Point aPoint) {
        return board.get(aPoint);
    }
}
