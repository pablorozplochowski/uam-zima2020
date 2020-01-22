package pl.psi.gui;

import com.google.common.collect.Range;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pl.psi.battleengine.BattleEngine;
import pl.psi.battleengine.creatures.CreatureStack;
import pl.psi.battleengine.creatures.StatisticBuffs;
import pl.psi.battleengine.spellbook.Spell;
import pl.psi.battleengine.spellbook.SpellBook;
import pl.psi.battleengine.spellbook.SpellBuff;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SpellList implements PropertyChangeListener {

    @FXML
    private GridPane spellGrid;
    private final PropertyChangeSupport obsSupport;
    private BattleEngine engine;
    private SpellBook spellBook;

    public SpellList(){
        obsSupport = new PropertyChangeSupport(this);
        spellBook=new SpellBook();
    }

    public void setEngine(BattleEngine engine){

        this.engine = engine;

    }

    private void tescik(){



    }

    @FXML
    private void initialize(){

        MapTile tile = new MapTile("test");
        spellGrid.add(tile,0,0);
        tile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            spellBook.attackSpell.cast((CreatureStack)engine.getByPoint(new Point(0,1)));
        });
        MapTile tile2 = new MapTile("test2");
        spellGrid.add(tile2,0,1);
        MapTile tile3 = new MapTile("test3");
        spellGrid.add(tile3,0,2);
        MapTile tile4 = new MapTile("test4");
        spellGrid.add(tile4,0,3);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(this::tescik);
    }
}
