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
    MethodesRepetitives methodesRepetitives = new MethodesRepetitives();


    public String nbMystere() {/*Demande au joueur la saisie du nombre que l'ordinateur doit deviner et controle le format*/

        boolean vf = true;
        String nbInconnu = new String();
        int i;

        System.out.println("Combinaison secrète de l'Ordinateur : " );

        do {/*Vérifie si bien un int à 4 chiffres*/
            Scanner sc = new Scanner(System.in);
            nbInconnu = sc.nextLine();

            for (i = 0; i < nbInconnu.length(); i++) {/*boucle pour parcourir chaque chiffre du nombre*/
                vf = Character.isDigit(nbInconnu.charAt(i));/*Vérifie si nbInconnu est un int*/
            }

            if (vf == false) {/*si pas un nombre ou pas un nombre à 4 chiffres (renvoi deux messages d'erreurs différents)*/
                System.out.println("Vous n'avez pas saisi un nombre. Recommencez.");
            } else if (nbInconnu.length() != longueurNb) {
                System.out.println("Vous n'avez pas saisi un nombre à 4 chiffres. Recommencez.");
            }

        }
        while (vf == false || i < longueurNb || longueurNb != nbInconnu.length());/*si pas un int à 4 chiffres redemande au joueur de saisir un nombre*/


        return nbInconnu;
    }

    public String proposition() {/*generer un code aleatoire*/
        String code = new String();

        code = methodesRepetitives.genererCodeAleatoire();
        return code;
    }

    /*compare nb inconnu et code aleatoire*/
    public String compare (String nb1,  String nb2) {
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



    public String ajuste (String nb,  String compare) {/*ajuster le code selon retour du compare*/
        String res = new String();
        int i;

        for (i = 0; i < longueurNb; i++) {/*incremente ou decremente selon <,>,=*/

            if (compare.charAt(i) == '>') {
                res = res + (char) (nb.charAt(i) + 1);

            }else if (compare.charAt(i) == '<') {
                res = res + (char) (nb.charAt(i) - 1);

            } else {
                res = res + (char) (nb.charAt(i));
            }
        }
        return res;
    }



    public void jeu() {/* boucle qui fait tourner le jeu defenseur*/

        String resultcomp = "";
        int k;
        String reponse;

        String nbJoueur = nbMystere();
        String nbOrdi =proposition();
        boolean victoire = false;


        System.out.println("Proposition ordinateur : " + nbOrdi);

        for(k=1;victoire == false && k<=nbEssais;k++){

            resultcomp = compare(nbJoueur, nbOrdi);
            System.out.println(" -> Réponse Ordinateur : " + resultcomp);

            if (resultcomp.equals("====")) {
                victoire = true;
            }
            else if(k<nbEssais){
                nbOrdi = ajuste(nbOrdi, resultcomp);
                System.out.println("Proposition Ordinateur : " + nbOrdi);
            }
        }

        if (nbJoueur.compareTo(nbOrdi) == 0)
            System.out.println("Dommage, vous avez perdu !!!");

        else
            System.out.println("Bravo ! vous avez gagné !!!");

    }

}

