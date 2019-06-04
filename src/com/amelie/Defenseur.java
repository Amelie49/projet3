package com.amelie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Defenseur implements DeroulementJeu {

    static Configuration configuration = new Configuration();
    static int longueurNb = configuration.getLongueurJeu();
    int nbEssais = configuration.getNbEssais();


    public void comparaison() {

        String nbMystere = null;
        int i;
        int code=0;
        String newNbPc = null;
        int nbPcCompare = 0;
        boolean vf = true;
        char reponse = ' ';
        int nbEssais=0;
        int j =0;

        do {

            System.out.println("Quel est le code que l'ordinateur doit trouver ?");

            do {

                do {

                    Scanner sc = new Scanner(System.in);
                    nbMystere = sc.nextLine();
                    i=0;

                    for(i=0;i<nbMystere.length();i++) {

                        vf = Character.isDigit(nbMystere.charAt(i));
                    }

                    if(vf==false) {
                        System.out.println("Vous n'avez pas saisi un nombre. Recommencez.");
                    }else {
                        System.out.println("");
                    }
                }
                while (vf == false && i++<longueurNb);

                /* si le joueur ne saisi pas un nombre à 4 chiffres*/

                if (longueurNb == nbMystere.length()) {
                }else {
                    System.out.println("Vous n'avez pas saisi un nombre à 4 chiffres. Recommencez.");
                }
            }
            while(longueurNb !=nbMystere.length());

            System.out.println("Proposition de l'ordinateur :");

            Codealeatoire codealeatoire = new Codealeatoire();
            int nbRandom = codealeatoire.genererCodeAleatoire();
            String nbPc = String.valueOf(nbRandom);
            System.out.println(nbPc);

            for (i=0;i<longueurNb;i++) {

                if(nbMystere.charAt(i)>nbPc.charAt(i)) {
                    System.out.print(">");

                }else if (nbMystere.charAt(i)<nbPc.charAt(i)) {
                    System.out.print("<");

                }else {
                    System.out.print("=");
                }
            }
            System.out.println("\n");

            do {
                j++;

                for (i=0;i<longueurNb;i++) {

                    if(nbMystere.charAt(i)>nbPc.charAt(i)) {
                        nbPcCompare = nbPc.charAt(i) - '0';
                        System.out.print(nbPcCompare +j);

                    }else if (nbMystere.charAt(i)<nbPc.charAt(i)) {
                        nbPcCompare = nbPc.charAt(i) - '0';
                        System.out.print(nbPcCompare -j);
                    }else {
                        System.out.print(nbPc.charAt(i));
                    }

                }

                for (i=0;i<longueurNb;i++) {

                    if(nbMystere.charAt(i)>nbPc.charAt(i)+j) {
                        System.out.print(">");

                    }else if (nbMystere.charAt(i)<nbPc.charAt(i)+j) {
                        System.out.print("<");

                    }else {
                        System.out.print("=");
                    }
                }
                System.out.println("\n");
            }

            while((nbMystere.compareTo(nbPc)!=0)&&(nbEssais++<longueurNb));

            if(nbMystere.compareTo(nbPc)==0)
                System.out.println("Dommage, vous avez perdu !!!");

            else
                System.out.println("Bravo ! vous avez gagné !!!");


            do {
                System.out.println("Souhaitez-vous rejouer O/N?");
                Scanner sc2 = new Scanner(System.in);
                reponse = sc2.nextLine().charAt(0);

                if (reponse!='O' && reponse !='N') {
                    System.out.println("Vous n'avez pas saisi un caractère valide !");
                }else {
                }
            }
            while(reponse!='O'&&reponse!='N');

        }
        while(reponse=='O');
    }


}




