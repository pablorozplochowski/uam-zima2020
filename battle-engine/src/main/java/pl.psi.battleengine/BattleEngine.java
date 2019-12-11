package pl.psi.battleengine;


import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.creatures.HeroInBattle;
import pl.psi.battleengine.move.GuiTileIf;
import pl.psi.battleengine.move.MapObstacle;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;

public class BattleEngine {

    public final static int WIDTH = Board.WIDTH;
    public final static int HEIGHT = Board.HEIGHT;

    public static final String CREATURE_MOVED = "CREATURE_MOVED";
    private final Queue<CreatureStack> creaturesQueue;
    private HeroInBattle hero1;
    private HeroInBattle hero2;
    private Board board;
    private HashMap.Entry<Point, CreatureStack> activeCreature;
    private List<CreatureStack> activatedCreaturesInThisTurn;
    private final PropertyChangeSupport obsSupport;

    public BattleEngine(HeroInBattle aHero1, HeroInBattle aHero2) {
        hero1 = aHero1;
        hero2 = aHero2;
        board = new Board();
        obsSupport = new PropertyChangeSupport(this);
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
        if(checkEndTurn()){
            creaturesQueue.addAll(activatedCreaturesInThisTurn);
            activatedCreaturesInThisTurn.clear();
        }
        CreatureStack currentCreatureStack = creaturesQueue.poll();
        activatedCreaturesInThisTurn.add(currentCreatureStack);
        Point currentPoint = board.getByCreature(currentCreatureStack);
        activeCreature = new AbstractMap.SimpleEntry<>(currentPoint, currentCreatureStack);
    }

    private boolean checkEndTurn() {return creaturesQueue.isEmpty();
    }

    private boolean isMoveRangeEnought(Point aPoint) {
        return Point.distance(activeCreature.getKey().getX(),activeCreature.getKey().getY(), aPoint.getX(),aPoint.getY()) <= activeCreature.getValue().getMoveRange();
    }

    private boolean isAttackRangeEnought(Point aPoint) {
        return Point.distance(activeCreature.getKey().getX(),activeCreature.getKey().getY(), aPoint.getX(),aPoint.getY()) <= activeCreature.getValue().getAttackRange();
    }

    public void move(int aX, int aY) {
        if (!isMoveAllowed(new Point(aX, aY))){
            throw new IllegalArgumentException("To small move range!");
        }

        board.remove(activeCreature.getKey());
        board.put(new Point (aX, aY), activeCreature.getValue());

        obsSupport.firePropertyChange(CREATURE_MOVED,null,null);
    }

    public void registerObserver(String eventType, PropertyChangeListener aObs){
        obsSupport.addPropertyChangeListener(eventType, aObs);
    }
}
