package com.amelie;

import java.util.Scanner;

public class Annonceniveaux {

    /**
     * Afficher chaque niveau
     */
    public void afficherLesNiveaux() {
        System.out.println("Votre mission si vous l'acceptez est de sortir de cette pièce.");
        System.out.println("Pour celà vous devez vaincre l'ordinateur.");
        System.out.println("Vous avez 5 essais. Passer ce nombre, vous aurez perdu.");
        System.out.println("Vous avez le choix entre différents mode : challenge, défenseur et duel.");
        System.out.println("Choix du niveau");
        System.out.println("1- challenge : vous devez deviner le code secret de l'ordinateur");
        System.out.println("2- défenseur : l'ordinateur va à son tour essayer de deviner votre code");
        System.out.println("3- duel : vous devez deviner le code de l'ordinateur avant que celui-ci ne devine le votre");
    }

    /**
     * Afficher niveau sélectionné
     */
    public static int afficherSelectionNiveaux() {
        int nbLevel;
        do {
            System.out.println("Quel niveau choisissez-vous ?");
            Scanner sc = new Scanner(System.in);
            nbLevel = sc.nextInt();
            switch (nbLevel)
            {
                case 1:
                    System.out.println("Vous avez choisi le niveau challenge");
                    break;
                case 2:
                    System.out.println("Vous avez choisi le niveau défenseur");
                    break;
                case 3:
                    System.out.println("Vous avez choisi le niveau duel");
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi de niveau parmi ceux proposés. Veuillez réitérer votre choix");
                    break;
            }
        } while (nbLevel != 1 && nbLevel != 2 && nbLevel != 3);
        return 0 ;
    }

    /** Phrase d'accroche début du jeu
     */
    public void debuterLeJeu() {
        System.out.println("Maintenant c'est à vous de jouer !");
        System.out.println("Bonne chance et que le meilleur gagne !");
    }
}


