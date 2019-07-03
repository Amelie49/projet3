package com.fonctionnement;


import org.apache.log4j.Logger;
import ressources.Configuration;

public class MethodesRepetitives {

    public Integer code;

    final static int longueurNb = Configuration.getLongueurNb();
    final static int nbEssais = Configuration.getNbEssais();

    int i;
    String nbPc;
    String proposition;
    boolean vf;
    String reponse;
    String codeJoueur;

    final static Logger log = Logger.getLogger(MethodesRepetitives.class);



    /** Générer le code aléatoire en int
     */
    public static String genererCodeAleatoire(){

        int i;
        String res = new String();
        int n;
        double d;
        String nbInconnu = new String();

        for (i=0;i<longueurNb;i++) {

            n = (int)(Math.random()*10);
            res = String.valueOf(n);
            nbInconnu = nbInconnu + res;
        }
        return nbInconnu;
    }


    /** Savoir si la saisie correspond bien à un nombre
     */
    public static boolean siEstUnNombreABonNombreDeChiffres (boolean vf, String nb) {
        int i;

        if (nb.length() != longueurNb)
            log.debug("Vous n'avez pas saisi un nombre à " + longueurNb +  "chiffres. Recommencez");

        for(i=0;vf && i < nb.length();i++) {
            vf = Character.isDigit(nb.charAt(i));
        }

        if(!vf)
            log.debug("Vous n'avez pas saisi un nombre. Recommencez");

        return vf;
    }


    /**Comparer chaque chiffre du nombre*/
    public static String compare(String nb1, String nb2) {
        String comp = new String();
        int j;

        for (j = 0; j < longueurNb; j++) {

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


    /**Génère les symboles que doit prendre la méthode compare pour gagner*/
        public static String bonResultat () {
            int k;
            String goodResult = "=";
            for (k = 1; k < nbEssais; k++) {
                goodResult = goodResult + "=";
            }
            return goodResult;
        }


        /** Afficher si le joueur à gagner ou perdu*/
    public static void vainqueurOuPerdant (boolean victoire) {

        if(victoire)
            log.info("Bravo ! vous avez gagné !!!");

        else
            log.info("Dommage, vous avez perdu !!!");

    }





}