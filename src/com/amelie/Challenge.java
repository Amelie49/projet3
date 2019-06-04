package com.amelie;

import java.util.Scanner;

public class Challenge implements DeroulementJeu{

    static Configuration configuration = new Configuration();
    static int longueurNb = configuration.getLongueurJeu();
    int nbEssais = configuration.getNbEssais();
    boolean modeDeveloppeur = configuration.getModeDeveloppeur();

    /**
     * code aléatoire
     * @return
     */


    public  void comparaison() {
        String choixJoueur = null;
        int nbJoueur;
        int i;
        int nbEssais = 0;
        boolean vf = false;
        char reponse = ' ';
        String nbPC = null;

        do {

            Codealeatoire codealeatoire = new Codealeatoire();
            int nbRandom = codealeatoire.genererCodeAleatoire();

            if (modeDeveloppeur = true)
                System.out.println(nbRandom);
            else

                do {
                    System.out.println("Quelle est votre proposition ?");

                    do {/* gérer exception si le joueur ne saisi pas un int*/

                        do{
                            Scanner sc = new Scanner(System.in);
                            choixJoueur = sc.nextLine();
                            i=0;

                            for(i=0;i<choixJoueur.length();i++) {

                                vf = Character.isDigit(choixJoueur.charAt(i));
                            }

                            if(vf==false) {

                                System.out.println("Vous n'avez pas saisi un nombre");
                            }else {
                                System.out.println("");
                            }
                        }
                        while (vf == false && i++<longueurNb);

                        /* si le joueur ne saisi pas un nombre à 4 chiffres*/

                        if (choixJoueur.length() == longueurNb) {
                        }else {
                            System.out.println("Vous n'avez pas saisi un nombre à 4 chiffres. Recommencez.");
                            System.out.println(choixJoueur.length());
                        }
                    }
                    while(choixJoueur.length() !=longueurNb);

                    nbPC = String.valueOf(nbRandom);

                    for (i=0;i< longueurNb;i++) {

                        if (nbPC.charAt(i)<choixJoueur.charAt(i))
                            System.out.print("<");

                        else if (nbPC.charAt(i)>choixJoueur.charAt(i))
                            System.out.print(">");

                        else
                            System.out.print("=");
                    }
                }
                while((choixJoueur.compareTo(nbPC)!=0)&&(nbEssais++<longueurNb));

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