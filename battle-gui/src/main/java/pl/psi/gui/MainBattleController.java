package pl.psi.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import pl.psi.battleengine.BattleEngine;
import pl.psi.battleengine.Creature;
import pl.psi.battleengine.Hero;
import pl.psi.battleengine.ObserverIf;

import java.awt.Point;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainBattleController implements PropertyChangeListener {

    @FXML
    private GridPane gridMap;
    @FXML
    private Button passButton;

    private BattleEngine engine;


    public MainBattleController() {
        Hero h1 = new Hero();
        h1.addCreature(Creature.builder().aName("h1_1").build());
        h1.addCreature(Creature.builder().aName("h1_2").build());
        h1.addCreature(Creature.builder().aName("h1_3").aMoveRange(5).build());
        h1.addCreature(Creature.builder().aName("h1_4").build());
        Hero h2 = new Hero();
        h2.addCreature(Creature.builder().aName("h2_1").build());
        h2.addCreature(Creature.builder().aName("h2_2").build());
        h2.addCreature(Creature.builder().aName("h2_3").build());
        h2.addCreature(Creature.builder().aName("h2_4").build());
        engine = new BattleEngine(h1,h2);
    }

    @FXML
    private void initialize() {
        refreshGui();

        passButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            engine.pass();
            refreshGui();
        });

        engine.registerObserver(BattleEngine.CREATURE_MOVED, this);
    }

    private void refreshGui() {
        for (int i = 0; i < 15 ; i++) {
            for (int j = 0; j < 10; j++) {
                createTile(i,j);
            }
        }
    }

    private void createTile(int aX, int aY) {
        Point activePoint = engine.getActiveCreaturePosition();
        MapTile tile;
        AbstractTileFactory tileFactory = new DefaultTileFactory();

        if(engine.getByPoint(aX,aY) !=null){
            tileFactory = new ObjectTileFactoryDecorator(tileFactory,engine.getByPoint(aX,aY).getIcon());
        }

        if(new Point(aX,aY).equals(engine.getActiveCreaturePosition())){
            tileFactory = new ActiveObjectTileFactoryDecorator(tileFactory);
        }

        if(engine.isMoveAllowed(new Point (aX, aY))){
            tileFactory = new MovePossibleTileFactoryDecorator(tileFactory, new Point(aX, aY),engine);
        }

        tile = tileFactory.generateTile();
        gridMap.add(tile, aX,aY);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        refreshGui();
    }
}
