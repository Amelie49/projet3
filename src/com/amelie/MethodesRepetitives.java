package com.amelie;


import java.util.Random;
import java.util.Scanner;

public class MethodesRepetitives {

    public Integer code;

    static Configuration configuration = new Configuration();
    static int intervalRandom = (int) Math.pow (10,configuration.getLongueurJeu());
    int nbEssais = configuration.getNbEssais();
    boolean modeDeveloppeur;
    int nbRandom;

    int longueurNb;
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


    public void afficherNombreMystere (String nbInconnu) {
        if (modeDeveloppeur = true) {
            System.out.println(nbInconnu);
        }else {
        }
    }


    /** Savoir si la saisie correspond bien à un nombre
     */
    public void siEstUnNombre () {
        for(i=0;i<codeJoueur.length();i++) {
            vf = Character.isDigit(codeJoueur.charAt(i));
        }

        if(vf==false) {
            System.out.println("Vous n'avez pas saisi un nombre");
        }else {
            System.out.println("");
        }
    }

    /** Savoir si la saisie est bien un nombre à 4 chiffres
     */
    public void SiEstUnNombreAQuatreChiffres () {
        if (codeJoueur.length() == longueurNb) {
        }else {
            System.out.println("Vous n'avez pas saisi un nombre à 4 chiffres. Recommencez.");
        }
    }


    /** Afficher si le joueur à gagner ou perdu
     */
    public void vainqueurOuPerdant () {
        if(proposition.compareTo(nbPc)==0)
            System.out.println("Bravo ! vous avez gagné !!!");

        else
            System.out.println("Dommage, vous avez perdu !!!");
    }


    /** Si le joueur souhaite rejouer ou non
     */
    public void rejouer () {
        do {
            System.out.println("Souhaitez-vous rejouer O/N?");
            Scanner sc2 = new Scanner(System.in);
            reponse = sc2.nextLine();
            reponse.toUpperCase();

            if (!reponse.equals ("O") && !reponse.equals ("N")) {
                System.out.println("Vous n'avez pas saisi un caractère valide !");
            }else {
            }
        }
        while(!reponse.equals("O") && !reponse.equals("N"));
    }



}