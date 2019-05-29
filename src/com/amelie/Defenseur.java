package com.amelie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Defenseur {



    public static void comparer() {

        String nbMystere;
        int i;
        int longueurJeu = 4;
        int code;
        String nbPc = null;
        Integer nbAComparer;
        String nbPcCompare = null;

        System.out.println("Quel est le code que l'ordinateur doit trouver ?");

        Scanner sc = new Scanner(System.in);
        nbMystere = sc.nextLine();


        System.out.println("Proposition de l'ordinateur :");

        for (i=0;i<longueurJeu;i++) {
            Random r = new Random();
            code = r.nextInt(10);
            nbPc = String.valueOf(code);
            nbPcCompare.charAt(i) = nbPc.charAt(1);

            System.out.print(nbPcCompare);
            System.out.println("\n");
        }

        for (i=0;i<longueurJeu;i++) {

            if(nbMystere.charAt(i)>nbPcCompare.charAt(i))
                System.out.println(">");

            else if (nbMystere.charAt(i)<nbPcCompare.charAt(i))
                System.out.println("<");

            else
                System.out.println("=");

        }

        System.out.println ("Proposition de l'ordinateur :");

        for (i=0;i<longueurJeu;i++) {
            nbAComparer = Integer.valueOf(nbPcCompare.charAt(i));

            if(nbMystere.charAt(i)>nbPc.charAt(i)) {
                Random r1 = new Random();
                code = r1.nextInt(9-nbAComparer)+nbAComparer;
                nbPc = String.valueOf(code);

            }else if (nbPc.charAt(i)>nbMystere.charAt(i)) {
                nbAComparer = Integer.valueOf(nbPc.charAt(i));
                Random r1 = new Random();
                code = r1.nextInt(nbAComparer);
                nbPc = String.valueOf(code);
                System.out.print(nbPc);

            }else {
                System.out.print(nbMystere.charAt(i));
            }
        }

    }
}

