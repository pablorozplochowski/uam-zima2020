package pl.psi.battleengine.spellbook;


import java.util.List;

public class Spell {
    private final String name;
    private List<Effects> effects;

    public Spell(String name, List<Effects> effects) {
        this.name = name;
        this.effects = effects;
    }
}
