package com.isep.hpah.Character.AbsEnenmy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Boss {
    private String name;
    private int hp;
    private int damage;

    public static Boss createBoss(int year) {
        switch (year) {
            case 1:
                return new Boss("Troll", 20, 20);
            case 2:
                return new Boss("Basilic", 200, 30);
            case 3:
                return new Boss("Mangemorts", 300, 40);
            default:
                throw new IllegalStateException("Aucun boss trouvé pour l'année " + year);
        }
    }
}