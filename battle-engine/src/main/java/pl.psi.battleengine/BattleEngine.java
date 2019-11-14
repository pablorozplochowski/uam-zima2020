package pl.psi.battleengine;

import java.awt.*;
import java.util.*;
import java.util.List;

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
        List<Creature> creatures = hero1.getCreatures();
        creatures.addAll(hero2.getCreatures());
        creatures.sort(Comparator.comparingInt(Creature::getMoveRange).reversed());
        creaturesQueue.addAll(creatures);
        Creature currentCreature = creaturesQueue.poll();
        Point currentPoint = board.getByCreature(currentCreature);
        activeCreature = new AbstractMap.SimpleEntry<>(currentPoint,currentCreature);
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

    public Point getActiveCreaturePosition() {
        return activeCreature.getKey();
    }
}
