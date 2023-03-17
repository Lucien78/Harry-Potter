package com.isep.hpah.Character;

import com.isep.hpah.Character.AbsSpell.Spell;
import com.isep.hpah.Character.House;
import com.isep.hpah.Character.Wand.Wand;
import com.isep.hpah.SortingHat;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Wizard {
    private String name;
    private int hp;
    private House house;
    private Wand wand;
    private List<Spell> spells;
    private List<Potion> potions;
    private String pet;
    private int strength;
    private int defense;
    private int precision;
    public void addSpell(Spell spell) {
        spells.add(spell);
    }

    public Wizard(String name) {
        this.name = name;
        this.hp = 100; // valeur initiale des points de vie
        this.spells = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.house = SortingHat.assignHouse();
        this.pet = Pet.assignPet();
        this.strength = 10;
        this.defense = 10;
        this.precision = 10;
    }
    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp= 0;
        }
        System.out.println(this.name + " a maintenant " + this.hp + " points de vie.");
    }



    // Autres méthodes pour attaquer, défendre, utiliser des potions, etc.
}

