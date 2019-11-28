package pl.psi.gui;

class DefaultTileFactory extends AbstractTileFactory{

    DefaultTileFactory() {
        super(null);
    }

    @Override
    MapTile generateTile() {
        return new MapTile("");
    }
}
