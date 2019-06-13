package com.amelie;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Defenseur implements DeroulementJeu {

    static Configuration configuration = new Configuration();
    static int longueurNb = configuration.getLongueurJeu();
    int nbEssais = configuration.getNbEssais();
    boolean modeDeveloppeur = configuration.getModeDeveloppeur();

    MethodesRepetitives methodesrepetitives = new MethodesRepetitives();
    int nbRandom = methodesrepetitives.genererCodeAleatoire();

    String nbMystere = null;
    String proposition = null;
    int i;
    boolean vf = true;
    String reponse;
    int j =0;
    String resultat;
    String compare;
    int x;


    public void nbMystere() {

        /*Vérifie si est bien un int*/


        System.out.println("Quel est le code que l'ordinateur doit trouver ?");

        /*Le joueur propose un nombre que l'ordinateur devra trouver*/

        do {
            do {
                Scanner sc = new Scanner(System.in);
                nbMystere = sc.nextLine();

                for(i=0;i<nbMystere.length();i++) {
                    vf = Character.isDigit(nbMystere.charAt(i));
                }

                if(vf==false) {
                    System.out.println("Vous n'avez pas saisi un nombre. Recommencez.");
                }else {
                    System.out.println("");
                }
            }
            while (vf == false && i<longueurNb);/*si pas un int redemande au joueur de saisir un nombre*/

            /* si le joueur ne saisi pas un nombre à 4 chiffres*/
            if (nbMystere.length() == longueurNb) {
            }else {
                System.out.println("Vous n'avez pas saisi un nombre à 4 chiffres. Recommencez.");
            }
        }
        while(longueurNb !=nbMystere.length());/*si le joueur ne saisi pas un nombre à 4 chiffres redemande au joueur une saisie*/
    }



    public void jeuTourneUneFois() {

        System.out.println("Proposition de l'ordinateur :");

        proposition = String.valueOf(nbRandom);

        resultat=proposition;

        System.out.println(resultat);


        compare = "";
        resultat = "";

        for (i=0;i<longueurNb;i++){
            if(nbMystere.charAt(i)>proposition.charAt(i)) {
                compare = compare +">";
                resultat =resultat + (char) (proposition.charAt(i) +1);

            }else if (nbMystere.charAt(i)<proposition.charAt(i)) {
                compare = compare +"<";
                resultat =resultat + (char) (proposition.charAt(i) -1);

            }else {
                compare = compare + "=";
                resultat =resultat + (char) (proposition.charAt(i));
            }
        }

        System.out.println(compare);

        if(i<nbEssais) {
            System.out.println(resultat);
        }else {
        }
    }



    public void boucle() {

        do {
            nbMystere();
            j=1;

            do {
                jeuTourneUneFois();
            }
            while((proposition.compareTo(nbMystere)!=0)&&(j++<nbEssais));

            if(proposition.compareTo(nbMystere)==0)
                System.out.println("Dommage, vous avez perdu !!!");

            else
                System.out.println("Bravo ! vous avez gagné !!!");

            do {
                System.out.println("Souhaitez-vous rejouer O/N?");
                Scanner sc2 = new Scanner(System.in);
                reponse = sc2.nextLine();
                reponse = reponse.toUpperCase();

                if (!reponse.equals ("O") && !reponse.equals ("N")) {
                    System.out.println("Vous n'avez pas saisi un caractère valide !");
                }else {
                }
            }
            while(!reponse.equals("O") && !reponse.equals("N"));
        }
        while (reponse.equals("O"));
    }

}






