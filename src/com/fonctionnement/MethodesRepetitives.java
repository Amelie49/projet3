package com.fonctionnement;


import ressources.Configuration;

public class MethodesRepetitives {

    public Integer code;

    static Configuration configuration = new Configuration();
    static int longueurNb = configuration.getLongueurNb();
    int nbEssais = configuration.getNbEssais();
    boolean modeDeveloppeur;

    int i;
    String nbPc;
    String proposition;
    boolean vf;
    String reponse;
    String codeJoueur;


    /** Générer le code aléatoire en int
     */
    public String genererCodeAleatoire(){

        int i;
        String res = new String();
        int n;
        double d;
        String nbInconnu = new String();

        for (i=0;i<4;i++) {

            n = (int)(Math.random()*5);
            res = String.valueOf(n);
            nbInconnu = nbInconnu + res;
        }
        return nbInconnu;
    }


    /** Savoir si la saisie correspond bien à un nombre
     */
    public boolean siEstUnNombreAQuatreChiffres (boolean vf, String nb) {
        for(i=0;vf==true && i < nb.length();i++) {
            vf = Character.isDigit(nb.charAt(i));
        }

        if(vf==false) {
            System.out.println("Vous n'avez pas saisi un nombre. Recommencez");
        } else if (nb.length() != longueurNb) {
            System.out.println("Vous n'avez pas saisi un nombre à 4 chiffres. Recommencez");
        }

        return vf;
    }


    public String compare(String nb1, String nb2) {
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


    /** Afficher si le joueur à gagner ou perdu
     */


    public void vainqueurOuPerdant (boolean victoire) {


        if(victoire == true)
            System.out.println("Bravo ! vous avez gagné !!!");

        else
            System.out.println("Dommage, vous avez perdu !!!");

    }





}