package pl.psi.gui;

abstract class AbstractTileFactory {

    protected final AbstractTileFactory decorated;

    protected AbstractTileFactory(AbstractTileFactory aDecorated) {
        decorated = aDecorated;
    }

    abstract MapTile generateTile();
}
