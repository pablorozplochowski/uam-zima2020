package pl.psi.battleengine.spellbook;


import java.util.List;

public class Spell {
    private final String name;
    private int duration;
    private List<Effects> effects;

    public Spell(String name, int duration, List<Effects> effects) {
        this.name = name;
        this.duration = duration;
        this.effects = effects;
    }
}
