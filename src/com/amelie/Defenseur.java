package com.amelie;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Defenseur implements DeroulementJeu{

    static Configuration configuration = new Configuration();
    static int longueurnb = configuration.getLongueurJeu();
    int nbEssais = configuration.getNbEssais();
    static int intervalRandom = (int) Math.pow (10,configuration.getLongueurJeu());


    public void comparaison() {

        String nbMystere;
        int i;
        int code;
        String nbPc = null;
        Integer nbAComparer = 0;
        String nbPcCompare = null;

        System.out.println("Quel est le code que l'ordinateur doit trouver ?");

        Scanner sc = new Scanner(System.in);
        nbMystere = sc.nextLine();


        System.out.println("Proposition de l'ordinateur :");

            Random r = new Random();
            code = r.nextInt(intervalRandom);
            nbPc = String.valueOf(code);

            System.out.print(nbPc + " : ");

        for (i=0;i<longueurnb;i++) {

            if (nbMystere.charAt(i) > nbPc.charAt(i))
                System.out.print(">");

            else if (nbMystere.charAt(i) < nbPc.charAt(i))
                System.out.print("<");

            else
                System.out.print("=");
        }

        System.out.print(nbPc.charAt(0));
        nbAComparer = Integer.valueOf(nbPc.charAt(0));
        System.out.print(nbAComparer);

        for(i=0;i<longueurnb;i++);



        System.out.println ("\n Proposition de l'ordinateur :");

            System.out.println(nbAComparer);

            Random r1 = new Random();
            code = r1.nextInt(9 - nbAComparer) + nbAComparer;
            nbPc = String.valueOf(code);
            System.out.println(nbPc);
        }





}

