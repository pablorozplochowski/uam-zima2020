package pl.psi.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pl.psi.battleengine.spellbook.Spell;

public class SpellList {

    @FXML
    private GridPane spellGrid;

    public SpellList(){



    }

    @FXML
    private void initialize(){

        MapTile tile = new MapTile("test");
        spellGrid.add(tile,0,0);

    }

}
