package pl.psi.battleengine;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BattleEngine {

    private final Queue<Creature> creaturesQueue;
    private Hero hero1;
    private Hero hero2;
    private Board board;
    private HashMap.Entry<Point, Creature> activeCreature;

    BattleEngine(Hero aHero1, Hero aHero2) {
        hero1 = aHero1;
        hero2 = aHero2;
        board = new Board();
        initBoard();
        creaturesQueue = new LinkedList<>();
        initQueue();
    }

    private void initQueue() {
        List<Creature> c1 = hero1.getCreatures();
        c1.addAll(hero2.getCreatures());
        creaturesQueue.addAll(c1);
        System.err.println(hero1.getCreatures().size());
//        hero1.getCreatures().addAll(hero2.getCreatures());
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

    public GuiTileIf getByPoint(Point aPoint) {
        return board.getByPoint(aPoint);
    }

    public boolean isAttackAllowed(){
        return false;
    }

    public Point getActiveCreaturePosition() {
        return activeCreature.getKey();
    }
}
