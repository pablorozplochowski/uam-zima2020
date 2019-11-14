package pl.psi.battleengine;

import java.awt.*;
import java.util.List;

public class BattleEngine {

    private Hero hero1;
    private Hero hero2;
    private Board board;

    BattleEngine(Hero aHero1, Hero aHero2) {
        hero1 = aHero1;
        hero2 = aHero2;
        board = new Board();
        initBoard();
    }

    private void initBoard() {
        putHeroCreaturesToBoard(hero1, 0);
        putHeroCreaturesToBoard(hero2, Board.WIDTH);
    }

    private void putHeroCreaturesToBoard(Hero aHero, int aColumnNumber) {
        List<Creature> creatures = aHero.getCreatures();
        for (int i = 0; i < creatures.size(); i++) {
            board.put(new Point(aColumnNumber, i * 2 + 1), creatures.get(i));
        }
    }

    GuiTileIf getByPoint(Point aPoint) {
        return board.getByPoint(aPoint);
    }
}
