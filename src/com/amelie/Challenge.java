package com.amelie;

import java.util.Scanner;

public class Challenge {

    private static final String String = null;
    /*Valeurs reprises de la classe configuration*/
    static Configuration configuration = new Configuration();
    static int longueurNb = configuration.getLongueurJeu();
    int nbEssais = configuration.getNbEssais();
    boolean modeDeveloppeur = configuration.getModeDeveloppeur();

    /*Méthodes reprises de la classe methodesrepetitives*/
    MethodesRepetitives methodesrepetitives = new MethodesRepetitives();


    public String nbMystere() {

        String nbInconnu = new String();

        /*générer code aléatoire*/
        nbInconnu = methodesrepetitives.genererCodeAleatoire();

        /*Afficher nb mystere selon mode developpeur actif ou non*/
        if (modeDeveloppeur = true) {
            System.out.println("Combinaison secrète du Joueur : " + nbInconnu);
        } else {
        }
        return nbInconnu;
    }

    public String proposition() {

        String proposition;
        int i;
        boolean vf;

        do { /*Vérifier si la saisie du joueur est bien un nombre à 4 chiffres*/
            System.out.println("Proposition Joueur :");

            Scanner sc = new Scanner(System.in);
            proposition = sc.nextLine();
            vf = true;


            for (i = 0; vf==true && i < proposition.length(); i++) {/*boucle qui vérifie chaque chiffre du nombre*/
                vf = Character.isDigit(proposition.charAt(i));
            }

            if (vf == false) {/*si pas un nombre ou pas un nombre à 4 chiffres (renvoi deux messages d'erreurs différents)*/
                System.out.println("Vous n'avez pas saisi un nombre. Recommencez");
            } else if (proposition.length() != longueurNb) {
                System.out.println("Vous n'avez pas saisi un nombre à 4 chiffres. Recommencez");
            }

        }
        while (vf == false || i < longueurNb || proposition.length() != longueurNb);

        return proposition;
    }


    public String compare(String nb1, String nb2) {
        String comp = new String();
        int j;

        for (j = 0; j < longueurNb; j++) {/*Comparer chaque chiffre du nombre*/

            if (nb1.charAt(j) > nb2.charAt(j)) {
                comp = comp + ">";

            } else if (nb1.charAt(j) < nb2.charAt(j)) {
                comp = comp + "<";

            } else {
                comp = comp + "=";
            }
        }

        return comp;
    }

    public void jeu() {/*boucle la méthode jeuTourneUneFois selon le nombre d'essais défini*/


        String resultcomp = "";
        int k;
        String reponse;
        String nbOrdi = nbMystere();
        String nbJoueur = proposition();
        boolean victoire = false;


        for (k = 1; victoire == false && k <= nbEssais; k++) {
            resultcomp = compare(nbOrdi, nbJoueur);
            System.out.println(" -> Réponse Joueur : " + resultcomp);


            if (resultcomp.equals("====")) {
                victoire = true;
            } else if (k < nbEssais) {
                nbJoueur = proposition();
            }
        }

        System.out.println("Le nombre mystère est : " + nbOrdi);

        if (nbJoueur.compareTo(nbOrdi) == 0)
            System.out.println("Bravo ! vous avez gagné !!!");

        else
            System.out.println("Dommage, vous avez perdu !!!");

    }}