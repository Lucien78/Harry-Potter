package com.isep.hpah.Character.AbsSpell;

import java.util.ArrayList;
import java.util.List;

public enum Spell {
    EXPECTO_PATRONUM(3,"Expecto-patronum",10, 0),
    WINGARDIUM_LEVIOSA(1,"Wingardium-Leviosa",20, 0),
    PROTEGO(1,"Protego",0,50 ),
    EXPELLIARMUS(2,"Expelliarmus",30,0);

    private final int yearLearned;
    private final String name;
    private final int damage;
    private final int defense;

    Spell(int yearLearned, String name, int damage, int defense) {
        this.yearLearned = yearLearned;
        this.name = name;
        this.damage = damage;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
    public int getDefense() {
        return defense;
    }

    public int getYearLearned() {
        return yearLearned;
    }

    public static List<Spell> getSpellsByYear(int year) {
        List<Spell> spellsForYear = new ArrayList<>();
        for (Spell spell : values()) {
            if (spell.getYearLearned() <= year) {
                spellsForYear.add(spell);
            }
        }
        return spellsForYear;
    }
}