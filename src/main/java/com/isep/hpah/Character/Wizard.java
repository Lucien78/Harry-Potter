package com.isep.hpah.Character;

import com.isep.hpah.Character.AbsSpell.Spell;
import com.isep.hpah.Character.Wand.Wand;

import java.util.ArrayList;
import java.util.List;

public class Wizard {
    private String name;
    private int hitPoints;
    private int damagePoints;
    private House house;
    private Wand wand;
    private List<Spell> spells;
    private List<Potion> potions;

    public Wizard(String name) {
        this.name = name;
        this.hitPoints = 100; // valeur initiale des points de vie
        this.damagePoints = 10; // valeur initiale des points de dégâts
        this.spells = new ArrayList<>();
        this.potions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void addSpell(Spell spell) {
        this.spells.add(spell);
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void addPotion(Potion potion) {
        this.potions.add(potion);
    }

    // Autres méthodes pour attaquer, défendre, utiliser des potions, etc.
}
