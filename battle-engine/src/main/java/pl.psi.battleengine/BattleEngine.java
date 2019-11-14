package pl.psi.battleengine;

import java.awt.*;

public class BattleEngine {

    private Hero hero1;
    private Hero hero2;

    BattleEngine(Hero aHero1, Hero aHero2) {
        hero1 = aHero1;
        hero2 = aHero2;
    }

    GuiTileIf getByPoint(Point aPoint) {
        return null;
    }
}
