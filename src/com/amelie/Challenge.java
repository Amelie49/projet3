package com.amelie;

import java.util.Scanner;

public class Challenge{

    static Configuration configuration = new Configuration();
    static int longueurNb = configuration.getLongueurJeu();
    int nbEssais = configuration.getNbEssais();
    boolean modeDeveloppeur = configuration.getModeDeveloppeur();

    MethodesRepetitives methodesrepetitives = new MethodesRepetitives();
    int nbRandom;

    String proposition = null;
    int nbJoueur;
    int i;
    boolean vf = false;
    String reponse;
    String nbMystere = null;
    int j;
    String compare;


    public String nbMystere () {

        /*générer code aléatoire*/
        nbRandom = methodesrepetitives.genererCodeAleatoire();
        nbMystere=String.valueOf(nbRandom);

        /*Afficher nb mystere selon mode developpeur actif ou non*/
        if (modeDeveloppeur = true) {
            System.out.println(nbMystere);
        }else {
        }
        return nbMystere;
    }

    public String jeuTourneUneFois () {

        do {
            do{
                System.out.println("Quelle est votre proposition ?");

                Scanner sc = new Scanner(System.in);
                proposition = sc.nextLine();
                i=0;

                /* si le joueur ne saisi pas un nombre */
                for(i=0;i<proposition.length();i++) {
                    vf = Character.isDigit(proposition.charAt(i));
                }

                if(vf==false) {
                    System.out.println("Vous n'avez pas saisi un nombre");
                }else {
                    System.out.println("");
                }
            }
            while (vf == false && i<longueurNb);

            /* si le joueur ne saisi pas un nombre à 4 chiffres*/
            if (proposition.length() == longueurNb) {
            }else {
                System.out.println("Vous n'avez pas saisi un nombre à 4 chiffres. Recommencez.");
            }
        }
        while(proposition.length() !=longueurNb);

        /* Comparer les valeurs du Random et de la proposition du joueur
         */
        compare = "";
        for (i=0;i<longueurNb;i++) {

            if (nbMystere.charAt(i)<proposition.charAt(i))
                compare = compare + "<";

            else if (nbMystere.charAt(i)>proposition.charAt(i))
                compare = compare + ">";

            else
                compare = compare + "=";

        }
        System.out.println(compare);

        return proposition;
    }

    public void boucle() {


        do {
            nbMystere();
            i=0;
            do {
                jeuTourneUneFois();
            }
            while (!proposition.equals(nbMystere) && j++<nbEssais);

            if(proposition.compareTo(nbMystere)==0)
                System.out.println("Bravo ! vous avez gagné !!!");

            else
                System.out.println("Dommage, vous avez perdu !!!");

            do {
                System.out.println("Souhaitez-vous rejouer O/N?");
                Scanner sc2 = new Scanner(System.in);
                reponse = sc2.nextLine();
                reponse = reponse.toUpperCase();

                if (reponse.compareTo ("O")!=0 && reponse.compareTo ("N")!=0) {
                    System.out.println("Vous n'avez pas saisi un caractère valide !");
                }else {
                }
            }
            while(!reponse.equals("O") && !reponse.equals("N"));

        }
        while (reponse.equals("O"));

    }
}
