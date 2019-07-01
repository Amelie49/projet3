package com.fonctionnement;


import org.apache.log4j.Logger;
import ressources.Configuration;

public class MethodesRepetitives {

    public Integer code;

    final static Configuration configuration = new Configuration();
    final static int longueurNb = configuration.getLongueurNb();
    final static int nbEssais = configuration.getNbEssais();

    int i;
    String nbPc;
    String proposition;
    boolean vf;
    String reponse;
    String codeJoueur;

    final static Logger log = Logger.getLogger(MethodesRepetitives.class);



    /** Générer le code aléatoire en int
     */
    public String genererCodeAleatoire(){

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
    public boolean siEstUnNombreABonNombreDeChiffres (boolean vf, String nb) {
        for(i=0;vf==true && i < nb.length();i++) {
            vf = Character.isDigit(nb.charAt(i));
        }

        if(vf==false) {
            log.debug("Vous n'avez pas saisi un nombre. Recommencez");
        } else if (nb.length() != longueurNb) {
            log.debug("Vous n'avez pas saisi un nombre à 4 chiffres. Recommencez");
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


    public String goodResult(){
        int k;
        String goodResult = "=";
        for (k=1;k<nbEssais;k++){
            goodResult = goodResult + "=";
        }
        return goodResult;
    }

    /** Afficher si le joueur à gagner ou perdu
     */


    public void vainqueurOuPerdant (boolean victoire) {


        if(victoire == true)
            log.info("Bravo ! vous avez gagné !!!");

        else
            log.info("Dommage, vous avez perdu !!!");

    }





}