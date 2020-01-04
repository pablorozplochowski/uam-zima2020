package pl.psi.battleengine;


import pl.psi.battleengine.attackengine.AttackingEngine;
import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.creatures.HeroInBattle;
import pl.psi.battleengine.move.GuiTileIf;
import pl.psi.battleengine.move.MapObstacle;
import pl.psi.battleengine.move.MovingEngine;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;

public class BattleEngine {

    public final static int WIDTH = Board.WIDTH;
    public final static int HEIGHT = Board.HEIGHT;

    public static final String CREATURE_MOVED = "CREATURE_MOVED";
    public static final String ACTIVE_CREATURE_CHANGED = "ACTIVE_CREATURE_CHANGED";
    public static final String END_OF_TURN = "END_OF_TURN";
    private final Queue<CreatureStack> creaturesQueue;
    private final HeroInBattle hero1;
    private final HeroInBattle hero2;
    private final Board board;

    private final MovingEngine moveEngine;
    private final AttackingEngine attackingEngine;

    private final PropertyChangeSupport obsSupport;

    private final List<CreatureStack> activatedCreaturesInThisTurn;
    private HashMap.Entry<Point, CreatureStack> activeCreature;


    public BattleEngine(HeroInBattle aHero1, HeroInBattle aHero2) {
        obsSupport = new PropertyChangeSupport(this);
        hero1 = aHero1;
        hero2 = aHero2;
        board = new Board();
        moveEngine = new MovingEngine(board, this);
        attackingEngine = new AttackingEngine(board, this);
        initBoard();
        creaturesQueue = new LinkedList<>();
        activatedCreaturesInThisTurn = new ArrayList<>();
        initQueue();
        addObstacles();
    }

    private void addObstacles() {
        board.put(new Point(7, 5), new MapObstacle());
        board.put(new Point(7, 6), new MapObstacle());
        board.put(new Point(7, 7), new MapObstacle());
        board.put(new Point(7, 4), new MapObstacle());
        board.put(new Point(7, 3), new MapObstacle());
    }

    public GuiTileIf getByPoint(Point aPoint) {
        return board.getByPoint(aPoint);
    }

    public GuiTileIf getByPoint(int x, int y) {
        return getByPoint(new Point(x, y));
    }

    public Point getActiveCreaturePosition() {
        return activeCreature.getKey();
    }

    public void pass() {
        nextCreature();
    }

    public boolean isMoveAllowed(Point aPoint) {
        return moveEngine.isMoveAllowed(aPoint);
    }

    public void move(int aX, int aY) {
        moveEngine.move(aX, aY);
        obsSupport.firePropertyChange(CREATURE_MOVED, null, null);
        Map.Entry<Point, CreatureStack> oldCreature = activeCreature;
        activeCreature = new AbstractMap.SimpleEntry<>(new Point(aX,aY), activeCreature.getValue());
        obsSupport.firePropertyChange(ACTIVE_CREATURE_CHANGED, oldCreature, activeCreature);
    }

    public void registerObserver(String eventType, PropertyChangeListener aObs) {
        obsSupport.addPropertyChangeListener(eventType, aObs);
    }

    public void registerObserver(PropertyChangeListener aObs) {
        obsSupport.addPropertyChangeListener(aObs);
    }

    public boolean isAttackAllowed(Point aPoint) {
        return attackingEngine.isAttackAllowed(aPoint);
    }

    public void attack(Point aPoint) {
        attackingEngine.attack(aPoint);
        pass();
    }

    private void initQueue() {
        List<CreatureStack> creatureStacks = hero1.getCreatureStacks();
        creatureStacks.addAll(hero2.getCreatureStacks());
        creatureStacks.sort(Comparator.comparingInt(CreatureStack::getMoveRange).reversed());
        creaturesQueue.addAll(creatureStacks);
        nextCreature();
    }

    private void initBoard() {
        putHeroCreaturesToBoard(hero1, 0);
        putHeroCreaturesToBoard(hero2, Board.WIDTH);
    }

    private void putHeroCreaturesToBoard(HeroInBattle aHero, int aColumnNumber) {
        List<CreatureStack> creatureStacks = aHero.getCreatureStacks();
        for (int i = 0; i < creatureStacks.size(); i++) {
            board.put(new Point(aColumnNumber, i * 2 + 1), creatureStacks.get(i));
        }
    }

    private void nextCreature() {
        Map.Entry<Point, CreatureStack> previousCreature = activeCreature;
        if (checkEndTurn()) {
            creaturesQueue.addAll(activatedCreaturesInThisTurn);
            activatedCreaturesInThisTurn.clear();
            obsSupport.firePropertyChange(END_OF_TURN, null, null);
        }
        CreatureStack currentCreatureStack = creaturesQueue.poll();
        activatedCreaturesInThisTurn.add(currentCreatureStack);
        Point currentPoint = board.getByCreature(currentCreatureStack);
        activeCreature = new AbstractMap.SimpleEntry<>(currentPoint, currentCreatureStack);

        obsSupport.firePropertyChange(ACTIVE_CREATURE_CHANGED, previousCreature, activeCreature);
    }

    private boolean checkEndTurn() {
        return creaturesQueue.isEmpty();
    }

}
