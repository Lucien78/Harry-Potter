package com.isep.hpah.Character;
import lombok.Setter;
import lombok.Getter;

@Getter
public enum Potion {
    HEALING_POTION("Healing Potion", 50),
    STRENGTH_POTION("Strength Potion", 10),
    DEFENSE_POTION("Defense Potion", 10),
    PRECISION_POTION("Precision Potion", 10);

    private final String name;
    private final int effectValue;

    Potion(String name, int effectValue) {
        this.name = name;
        this.effectValue = effectValue;
    }

    public void applyEffect(Wizard wizard) {
        switch (this) {
            case HEALING_POTION:
                wizard.setHp(wizard.getHp() + effectValue);
                break;
            case STRENGTH_POTION:
                wizard.setStrength(wizard.getStrength() + effectValue);
                break;
            case DEFENSE_POTION:
                wizard.setDefense(wizard.getDefense() + effectValue);
                break;
            case PRECISION_POTION:
                wizard.setPrecision(wizard.getPrecision() + effectValue);
                break;
        }
    }
}

