package com.isep.hpah;

import com.isep.hpah.Character.AbsEnenmy.Boss;
import com.isep.hpah.Character.AbsSpell.Spell;
import com.isep.hpah.Character.Pet;
import com.isep.hpah.Character.Wand.Wand;
import com.isep.hpah.Character.Wizard;
import com.isep.hpah.Combat;

import java.util.List;
import java.util.Scanner;


public class Game {
    public static void startCombat(Wizard wizard, Boss boss) {
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
    static int currentYear=1;
    public static void nextYear() {
        currentYear++;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom de votre sorcier : ");
        String wizardName = scanner.nextLine();

        Wizard wizard = new Wizard(wizardName);
        wizard.setHouse(SortingHat.assignHouse());
        wizard.setPet(Pet.assignPet());
        wizard.setWand(Wand.createRandomWand());



        // Ajouter les sorts pour l'année en cours
        List<Spell> spellsForYear = Spell.getSpellsByYear(currentYear);
        for (Spell spell : spellsForYear) {
            wizard.addSpell(spell);
        }

        System.out.println("Bienvenue, " + wizard.getName() + " !");
        System.out.println("Votre maison est : " + wizard.getHouse().getName());
        System.out.println("Votre animal de compagnie est un(e) : " + wizard.getPet());
        System.out.println("Votre baguette est composée de : " + wizard.getWand().getCore() + " et mesure " + wizard.getWand().getLength() + " centimètres.");
        System.out.println("Vous êtes en première année. Les sorts que  " + wizard.getName() + " connaît  sont : ");
        for (Spell spell : wizard.getSpells()) {
            System.out.println(" - " + spell);
        }

        // Vous pouvez ajouter ici la logique du jeu, comme les combats, les niveaux, etc.


        // Lancer le combat
        System.out.println("Année " + currentYear + " - Combat contre le boss :");


        while (currentYear <= 7) {
            System.out.println("Année " + currentYear + " commence...");
            System.out.println("Année " + currentYear +" : Affrontez le Troll des toilettes !");
            Boss boss = Boss.createBoss(currentYear);

            // ... lancez le combat et vérifiez si le joueur a gagné ou perdu ...
            startCombat(wizard, boss);
            if(wizard.getHp()<=0){
                wizard.setHp(100);
                System.out.println("Vous avez perdu. Essayez à nouveau !");
                startCombat(wizard, boss);

            }

            if (wizard.getHp()>0) {
                nextYear();
            } else {
                System.out.println("Vous avez perdu. Essayez à nouveau !");
                // ... relancez le combat ou terminez le jeu ...
            }
        }


    }

}
