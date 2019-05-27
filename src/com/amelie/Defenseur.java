package com.amelie;

import java.util.Random;
import java.util.Scanner;

public class Defenseur {

    static Configuration configuration = new Configuration();
    static int longueurnb = configuration.getLongueurJeu();
    int nbEssais = configuration.getNbEssais();



    public static int comparaison (){
        String nbMystere;
        int code;
        int i;
        String nbPc;

        System.out.println("Quel est le code mystère que l'ordinateur doit trouver ?");

        Scanner sc = new Scanner(System.in);
        nbMystere = sc.nextLine();

        Random r = new Random();
        code = r.nextInt(longueurnb);
        return code;

        do{
        for (i=0;i< longueurnb;i++){

            if (nbPc.charAt(i) < nbMystere.charAt(i))
                System.out.println("<");

            else if (nbPc.charAt(i) > nbMystere.charAt(i))
                System.out.print(">");

            else
                System.out.print("=");

    }
    }
}
