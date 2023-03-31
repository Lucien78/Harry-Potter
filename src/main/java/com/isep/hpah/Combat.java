package com.isep.hpah;

import com.isep.hpah.Character.AbsEnenmy.Boss;
import com.isep.hpah.Character.AbsSpell.Spell;
import com.isep.hpah.Character.Potion;
import com.isep.hpah.Character.Wizard;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
@Getter
@Setter
public class Combat {

    private Wizard wizard;
    private Boss boss;

    public Combat(Wizard wizard, Boss boss) {
        this.wizard = wizard;
        this.boss = boss;
    }
    public void startCombat(Wizard wizard, Boss boss) {
        Scanner scanner = new Scanner(System.in);
        Combat combat = new Combat(wizard, boss);
        boolean combatEnded = false;

        System.out.println("Un combat commence ! " + wizard.getName() + " affronte " + boss.getName() + ".");

        while (!combatEnded) {
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Attaquer");
            System.out.println("2. Utiliser une potion");
            System.out.println("3. Fuir");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    combat.attack();
                    break;
                case 2:
                    combat.usePotion();
                    break;
                case 3:

                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
                    continue;
            }

            combat.enemyAttack();

            // Vérifiez les conditions de fin de combat, comme la mort du Wizard ou du boss
            if (wizard.getHp() <= 10) {
                System.out.println("Vous avez perdu le combat.");
                combatEnded = true;
            } else if (boss.getHp() <= 0) {
                System.out.println("Vous avez gagné le combat !");
                combatEnded = true;
            }
        }
    }


    public void attack() {
        System.out.println("Choisissez un sort à lancer :");
        List<Spell> knownSpells = wizard.getSpells();
        for (int i = 0; i < knownSpells.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, knownSpells.get(i).getName());
        }

        Scanner scanner = new Scanner(System.in);
        int spellChoice = scanner.nextInt() - 1;

        if (spellChoice >= 0 && spellChoice < knownSpells.size()) {
            Spell selectedSpell = knownSpells.get(spellChoice);
            System.out.printf("Vous lancez %s.\n", selectedSpell.getName());

            // Calculez les dégâts en fonction de la logique de votre jeu.
            // Vous pouvez prendre en compte les spécificités des maisons ici.
            double damageModifier =  wizard.getHouse().getSpellDamage();
            int damage = (int) (selectedSpell.getDamage()*damageModifier);

            // Infligez les dégâts au boss.
            boss.setHp(boss.getHp() - damage);
            System.out.printf("Le %s a subi %d points de dégâts.\n", boss.getName(), damage);

            if (boss.getHp() <= 0) {
                System.out.printf("Vous avez vaincu le %s !\n", boss.getName());
                // Vous pouvez ajouter ici la logique pour terminer le combat et passer au niveau suivant.
            }
        } else {
            System.out.println("Choix invalide, veuillez réessayer.");
        }
    }

    public void usePotion() {
        System.out.println("Choisissez une potion à utiliser :");
        Potion[] potions = Potion.values();
        for (int i = 0; i < potions.length; i++) {
            System.out.printf("%d. %s\n", i + 1, potions[i].getName());
        }

        Scanner scanner = new Scanner(System.in);
        int potionChoice = scanner.nextInt() - 1;

        if (potionChoice >= 0 && potionChoice < potions.length) {
            Potion selectedPotion = potions[potionChoice];
            System.out.printf("Vous utilisez %s.\n", selectedPotion.getName());

            switch (selectedPotion) {
                case HEALING_POTION:
                    wizard.setHp(wizard.getHp() + selectedPotion.getEffectValue());
                    break;
                case STRENGTH_POTION:
                    // Ajoutez la logique pour augmenter les dégâts du sorcier
                    break;
                case PRECISION_POTION:
                    // Ajoutez la logique pour augmenter la précision du sorcier
                    break;
                case DEFENSE_POTION:
                    // Ajoutez la logique pour augmenter la défense du sorcier
                    break;
            }
        } else {
            System.out.println("Choix invalide, veuillez réessayer.");
        }
    }

    public void enemyAttack() {
        // Récupérer le boss pour l'année en cours (supposons que "currentYear" est un int représentant l'année en cours)
            int damage = boss.getDamage();
            wizard.takeDamage(damage);
            System.out.println("Le boss " + boss.getName() + " inflige " + damage + " points de dégâts à " + wizard.getName() + ".");
        }
    }



