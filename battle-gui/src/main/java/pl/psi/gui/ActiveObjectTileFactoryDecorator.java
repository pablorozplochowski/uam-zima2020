package pl.psi.gui;


import javafx.scene.paint.Color;

class ActiveObjectTileFactoryDecorator extends AbstractTileFactory {
    public ActiveObjectTileFactoryDecorator(AbstractTileFactory aTileFactory) {
        super(aTileFactory);
    }

    @Override
    MapTile generateTile() {
        MapTile tile = decorated.generateTile();
        tile.setBackground(Color.GREEN);
        return tile;
    }
}
