package pl.psi.economyengine.hero.gui;

class ObjectTileFactoryDecorator extends AbstractTileFactory{

    private String name;

    ObjectTileFactoryDecorator(AbstractTileFactory aDecorated, String aName) {
        super(aDecorated);
        name = aName;
    }

    @Override
    MapTile generateTile() {
        MapTile tile = decorated.generateTile();
        tile.setName(name);
        return tile;
    }
}
