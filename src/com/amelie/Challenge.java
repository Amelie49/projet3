package com.amelie;

import java.util.Scanner;

public class Challenge {

    static Configuration configuration = new Configuration();
    static int longueurJeu = configuration.getLongueurJeu();
    int nbEssais = configuration.getNbEssais();

    /**
     * code aléatoire
     * @return
     */


    public static void comparaison() {
        String choixJoueur;
        int nbJoueur;
        int longueurJoueur;
        int i;
        int j;
        boolean vf;
        char reponse = ' ';
        String nbPC;

        do {
            j=0;

            Codealeatoire codealeatoire = new Codealeatoire();
            int nbRandom = codealeatoire.genererCodeAleatoire();

            do {
                System.out.println("Quelle est votre proposition ?");

                do {/* gérer exception si le joueur ne saisi pas un int*/
                    i=0;

                    do{
                        Scanner sc = new Scanner(System.in);
                        choixJoueur = sc.nextLine();

                        vf = Character.isDigit(choixJoueur.charAt(i));

                        if(vf==false) {
                            System.out.print("Vous n'avez pas saisi un nombre");
                        }else {
                            System.out.print("");
                        }
                    }
                    while (vf == false && i++<longueurJeu);

                    /* si le joueur ne saisi pas un nombre à 4 chiffres*/
                    longueurJoueur = choixJoueur.length();

                    if (longueurJoueur == longueurJeu) {
                    }else {
                        System.out.println("Vous n'avez pas saisi un nombre à 4 chiffres. Recommencez.");
                        System.out.println(choixJoueur.length());
                    }
                }
                while(longueurJoueur!=longueurJeu);

                nbPC = String.valueOf(nbRandom);

                for (i=0;i< longueurJeu;i++) {

                    if (nbPC.charAt(i)<choixJoueur.charAt(i))
                        System.out.println("<");

                    else if (nbPC.charAt(i)>choixJoueur.charAt(i))
                        System.out.println(">");

                    else
                        System.out.println("=");
                }
            }
            while((choixJoueur.compareTo(nbPC)!=0)&&(j++<longueurJeu));

            if(choixJoueur.compareTo(nbPC)==0)
                System.out.println("Bravo ! vous avez gagné !!!");

            else
                System.out.println("Dommage, vous avez perdu !!!");

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
