package pl.psi.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import pl.psi.battleengine.BattleEngine;
import pl.psi.battleengine.Creature;
import pl.psi.battleengine.Hero;

public class MainBattleController {

    @FXML
    private GridPane gridMap;
    @FXML
    private Button passButton;

    private BattleEngine engine;


    public MainBattleController() {
        Hero h1 = new Hero();
        h1.addCreature(Creature.builder().aName("h1_1").build());
        h1.addCreature(Creature.builder().aName("h1_2").build());
        h1.addCreature(Creature.builder().aName("h1_3").build());
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
        for (int i = 0; i < 15 ; i++) {
            for (int j = 0; j < 10; j++) {
                if(engine.getByPoint(i,j) == null){
                    gridMap.add(new MapTile(""),i,j);
                }else {
                    gridMap.add(new MapTile(engine.getByPoint(i,j).getIcon()),i,j);
                }
            }
        }
    }
}
