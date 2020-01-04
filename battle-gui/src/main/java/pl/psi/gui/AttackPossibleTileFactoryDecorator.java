package pl.psi.gui;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import pl.psi.battleengine.BattleEngine;

import java.awt.*;

class AttackPossibleTileFactoryDecorator extends AbstractTileFactory {

    private Point location;
    private BattleEngine engine;

    public AttackPossibleTileFactoryDecorator(AbstractTileFactory aTileFactory, Point aLocation, BattleEngine aEngine) {
        super(aTileFactory);
        location = aLocation;
        engine = aEngine;
    }

    @Override
    MapTile generateTile() {
        MapTile tile = decorated.generateTile();
        tile.setBackground(Color.RED);
        tile.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> attack(e));
        return tile;
    }

    private void attack(MouseEvent aE) {
        engine.attack(new Point(location.x,location.y));
    }

}
