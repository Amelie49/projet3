package com.amelie;


import java.util.Random;
import java.util.Scanner;

public class Defenseur{

    /*Appeler valeur de la classe configuration*/
    static Configuration configuration = new Configuration();
    static int longueurNb = configuration.getLongueurJeu();
    int nbEssais = configuration.getNbEssais();
    boolean modeDeveloppeur = configuration.getModeDeveloppeur();

    /*Appeler méthodes de la classe méthodesrépétitives*/
    MethodesRepetitives methodesrepetitives = new MethodesRepetitives();

    String reponse;
    int i;

/** Génère le nombre que l'ordinateur doit deviner*/
    public String nbMystere() {
        boolean vf = true;

        String nbInconnu = new String();

        System.out.println("Quel est le code que l'ordinateur doit trouver ?");

        do {/*Vérifie si bien un int*/
            Scanner sc = new Scanner(System.in);
            nbInconnu = sc.nextLine();

            for (i = 0; i < nbInconnu.length(); i++) {/*boucle pour parcourir chaque chiffre du nombre*/
                vf = Character.isDigit(nbInconnu.charAt(i));/*Vérifie si nbInconnu est un int*/
            }

            if (vf == false) {
                System.out.println("Vous n'avez pas saisi un nombre. Recommencez.");
            } else {
                System.out.println("");
            }

            if (nbInconnu.length() == longueurNb) {
            } else {
                System.out.println("Vous n'avez pas saisi un nombre à 4 chiffres. Recommencez.");
            }

        }
        while (vf == false && i < longueurNb && longueurNb != nbInconnu.length());/*si pas un int à 4 chiffres redemande au joueur de saisir un nombre*/

        return nbInconnu;
    }


    /* génère un code aléatoire*/
    public String codeAleatoire() {

        String proposition = new String();

        int nbRandom = methodesrepetitives.genererCodeAleatoire();

        proposition = String.valueOf(nbRandom);

        System.out.println("Proposition de l'ordinateur : " + proposition);

        return proposition;
    }


    /*Fais tourner le jeu une fois*/
    public String jeuTourneUneFois(String nbInconnu, String proposition) {

        String res = new String();
        String comp = new String();
        String a = proposition;

        for (i = 0; i < longueurNb; i++) {/*Comparer chaque chiffre du nombre*/

            if (nbInconnu.charAt(i) > a.charAt(i)) {
                comp = comp + ">";
                res = res + (char) (a.charAt(i) + 1);

            } else if (nbInconnu.charAt(i) < a.charAt(i)) {
                comp = comp + "<";
                res = res + (char) (a.charAt(i) - 1);

            } else {
                comp = comp + "=";
                res = res + (char) (a.charAt(i));
            }
        }
        System.out.println(comp);

        return res;
    }


    public void boucle(String a, String res, String nbInconnu) {

        String code = new String();
        String b = new String();
        String soluce = new String();
        int j = 0;

        b = nbMystere();

        int random = methodesrepetitives.genererCodeAleatoire();
        code = String.valueOf(random);

        System.out.println("Proposition de l'ordinateur : " + code);

        res = jeuTourneUneFois(nbInconnu, a);

        System.out.println(j);

        do {
                j=0;

                res = jeuTourneUneFois(b, code);

                if (j < nbEssais) {
                    System.out.println("Proposition de l'ordinateur : " + res);
                    break;
                }
            }
            while ((res.compareTo(b) != 0) && (j++ < nbEssais));

            if (a.compareTo(nbInconnu) == 0)
                System.out.println("Dommage, vous avez perdu !!!");

            else
                System.out.println("Bravo ! vous avez gagné !!!");

            do {
                System.out.println("Souhaitez-vous rejouer O/N?");
                Scanner sc2 = new Scanner(System.in);
                reponse = sc2.nextLine();
                reponse = reponse.toUpperCase();

                if (!reponse.equals("O") && !reponse.equals("N")) {
                    System.out.println("Vous n'avez pas saisi un caractère valide !");
                } else {
                }
            }
            while (!reponse.equals("O") && !reponse.equals("N"));


    }


}






