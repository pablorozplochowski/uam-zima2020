package pl.psi.gui;

class ObjectTileFactory extends AbstractTileFactory{

    private String name;

    ObjectTileFactory(String aName) {
        name = aName;
    }

    @Override
    MapTile generateTile() {
        return new MapTile(name);
    }
}
