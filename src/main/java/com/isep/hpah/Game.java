package com.isep.hpah;

import com.isep.hpah.Character.Pet;
import com.isep.hpah.Character.Wand.Wand;
import com.isep.hpah.Character.Wizard;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nom de votre sorcier : ");
        String wizardName = scanner.nextLine();

        Wizard wizard = new Wizard(wizardName);
        wizard.setHouse(SortingHat.assignHouse());
        wizard.setPet(Pet.assignPet());
        wizard.setWand(Wand.createRandomWand());

        System.out.println("Bienvenue, " + wizard.getName() + " !");
        System.out.println("Votre maison est : " + wizard.getHouse().getName());
        System.out.println("Votre animal de compagnie est un(e) : " + wizard.getPet());
        System.out.println("Votre baguette est composée de : " + wizard.getWand().getCore() + " et mesure " + wizard.getWand().getLength() + " centimètres.");

        // Vous pouvez ajouter ici la logique du jeu, comme les combats, les niveaux, etc.
    }
}
