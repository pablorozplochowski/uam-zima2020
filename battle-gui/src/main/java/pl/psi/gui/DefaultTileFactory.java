package pl.psi.gui;

class DefaultTileFactory extends AbstractTileFactory{

    @Override
    MapTile generateTile() {
        return new MapTile("");
    }
}
