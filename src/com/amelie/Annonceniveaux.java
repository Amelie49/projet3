package com.amelie;


import java.util.Scanner;

public class Annonceniveaux {

    static Configuration configuration = new Configuration();
    static int longueurNb = configuration.getLongueurJeu();
    int nbEssais = configuration.getNbEssais();
    boolean modeDeveloppeur = configuration.getModeDeveloppeur();

    MethodesRepetitives methodesrepetitives = new MethodesRepetitives();

    /**
     * Afficher chaque niveau
     */
    public void afficherLesNiveaux() {
        System.out.println("Votre mission si vous l'acceptez est de sortir de cette pièce.");
        System.out.println("Pour celà vous devez vaincre l'ordinateur.");
        System.out.println("Vous avez "  + nbEssais + " essais. Passé ce nombre, vous aurez perdu.");
        System.out.println("Vous avez le choix entre différents mode : challenge, défenseur et duel.");
        System.out.println("Choix du niveau");
        System.out.println("1- challenge : vous devez deviner le code secret de l'ordinateur");
        System.out.println("2- défenseur : l'ordinateur va à son tour essayer de deviner votre code");
        System.out.println("3- duel : vous devez deviner le code de l'ordinateur avant que celui-ci ne devine le votre");
    }

    /**
     * Afficher niveau sélectionné
     */
    public void jeu() {
        String nbLevel;
        Challenge challenge = new Challenge();
        Defenseur defenseur = new Defenseur();
        Duel duel = new Duel ();
        int i;
        String reponse = null;

        do {

            do {
                System.out.println("Quel niveau choisissez-vous ?");
                Scanner sc = new Scanner(System.in);
                nbLevel = sc.nextLine();

                switch (nbLevel) {

                    case "1":
                        System.out.println("Vous avez choisi le niveau challenge");
                        break;
                    case "2":
                        System.out.println("Vous avez choisi le niveau défenseur");
                        break;
                    case "3":
                        System.out.println("Vous avez choisi le niveau duel");
                        break;
                    default:
                        System.out.println("Vous n'avez pas choisi de niveau parmi ceux proposés. Veuillez réitérer votre choix");
                        break;
                }
            } while (!nbLevel.equals("1") && !nbLevel.equals("2") && !nbLevel.contentEquals("3"));

            System.out.println("Maintenant c'est à vous de jouer !");
            System.out.println("Bonne chance et que le meilleur gagne  !");

            if(nbLevel.equals("1"))

                challenge.boucle();


            else
                duel.jeu();

            methodesrepetitives.rejouer();

        }
        while (reponse.equals("O"));

    }

}

