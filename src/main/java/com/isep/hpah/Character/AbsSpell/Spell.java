package com.isep.hpah.Character.AbsSpell;

public enum Spell {
    EXPECTO_PATRONUM("Expecto Patronum"),
    WINGARDIUM_LEVIOSA("Wingardium Leviosa"),
    PROTEGO("Protego"),
    EXPELLIARMUS("Expelliarmus");

    private final String name;

    Spell(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}