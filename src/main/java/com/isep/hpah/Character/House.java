package com.isep.hpah.Character;

import lombok.Getter;

@Getter
public enum House {
    GRYFFINDOR("Gryffindor", 1.2, 1.0, 1.0, 1.0),
    HUFFLEPUFF("Hufflepuff", 1.0, 1.5, 1.0, 1.0),
    RAVENCLAW("Ravenclaw", 1.0, 1.0, 1.0, 1.2),
    SLYTHERIN("Slytherin", 1.0, 1.0, 1.2, 1.0);

    private final String name;
    private final double damageResistance;
    private final double potionEfficiency;
    private final double spellDamage;
    private final double spellPrecision;

    House(String name, double damageResistance, double potionEfficiency, double spellDamage, double spellPrecision) {
        this.name = name;
        this.damageResistance = damageResistance;
        this.potionEfficiency = potionEfficiency;
        this.spellDamage = spellDamage;
        this.spellPrecision = spellPrecision;
    }
}

