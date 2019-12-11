package pl.psi.gui;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pl.psi.battleengine.BattleEngine;

import java.awt.*;

class MovePossibleTileFactoryDecorator extends AbstractTileFactory {

    private Point location;
    private BattleEngine engine;

    public MovePossibleTileFactoryDecorator(AbstractTileFactory aTileFactory, Point aLocation, BattleEngine aEngine) {
        super(aTileFactory);
        location = aLocation;
        engine = aEngine;
    }

    @Override
    MapTile generateTile() {
        MapTile tile = decorated.generateTile();
        tile.setBackground(Color.GREY);
        tile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> move(e));
        return tile;
    }

    private void move(MouseEvent aE) {
        engine.move(location.x,location.y);
    }

}
