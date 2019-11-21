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
    private List<Creature> activatedCreaturesInThisTurn;

    public BattleEngine(Hero aHero1, Hero aHero2) {
        hero1 = aHero1;
        hero2 = aHero2;
        board = new Board();
        initBoard();
        creaturesQueue = new LinkedList<>();
        activatedCreaturesInThisTurn = new ArrayList<>();
        initQueue();
        addObstacles();
    }

    private void addObstacles() {
        board.put(new Point(7,5),new MapObstacle());
        board.put(new Point(7,6),new MapObstacle());
        board.put(new Point(7,7),new MapObstacle());
        board.put(new Point(7,4),new MapObstacle());
        board.put(new Point(7,3),new MapObstacle());
    }

    public GuiTileIf getByPoint(Point aPoint) {
        return board.getByPoint(aPoint);
    }

    public GuiTileIf getByPoint(int x, int y) {
        return getByPoint(new Point(x,y));
    }

    public Point getActiveCreaturePosition() {
        return activeCreature.getKey();
    }

    public void pass() {
        nextCreature();
    }

    public boolean isMoveAllowed(Point aPoint) {
        return isMoveRangeEnought(aPoint) && board.isEmpty(aPoint);
    }

    public boolean isAttackAllowed(Point aPoint) {
        return isAttackRangeEnought(aPoint) && !board.isEmpty(aPoint);
    }

    private void initQueue() {
        List<Creature> creatures = hero1.getCreatures();
        creatures.addAll(hero2.getCreatures());
        creatures.sort(Comparator.comparingInt(Creature::getMoveRange).reversed());
        creaturesQueue.addAll(creatures);
        nextCreature();
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

    private void nextCreature() {
        if(checkEndTurn()){
            creaturesQueue.addAll(activatedCreaturesInThisTurn);
            activatedCreaturesInThisTurn.clear();
        }
        Creature currentCreature = creaturesQueue.poll();
        activatedCreaturesInThisTurn.add(currentCreature);
        Point currentPoint = board.getByCreature(currentCreature);
        activeCreature = new AbstractMap.SimpleEntry<>(currentPoint,currentCreature);
    }

    private boolean checkEndTurn() {
        return creaturesQueue.isEmpty();
    }

    private boolean isMoveRangeEnought(Point aPoint) {
        return Point.distance(activeCreature.getKey().getX(),activeCreature.getKey().getY(), aPoint.getX(),aPoint.getY()) <= activeCreature.getValue().getMoveRange();
    }

    private boolean isAttackRangeEnought(Point aPoint) {
        return Point.distance(activeCreature.getKey().getX(),activeCreature.getKey().getY(), aPoint.getX(),aPoint.getY()) <= activeCreature.getValue().getAttackRange();
    }
}
