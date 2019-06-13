package com.amelie;

import java.util.Scanner;

public class Duel {


    static Configuration configuration = new Configuration();
    int nbEssais = configuration.getNbEssais();

    Challenge challenge = new Challenge();
    Defenseur defenseur = new Defenseur();

    String nbPc;
    String propositionPc;
    String nbJoueur;
    String propositionJoueur;
    int i;
    String reponse;


    public void jeu (){

       do{

        do {
           i=5;

            challenge.nbMystere();
            challenge.jeuTourneUneFois();
            defenseur.nbMystere();

            nbPc = defenseur.nbMystere();
            nbJoueur = challenge.nbMystere();
            propositionJoueur = challenge.jeuTourneUneFois();
        }
        while(nbPc.compareTo(propositionPc)!=0 && nbJoueur.compareTo(propositionJoueur)!=0 && i++<nbEssais);

        if(propositionPc.compareTo(nbPc)==0)
            System.out.println("Dommage, vous avez perdu !!!");

        else
            System.out.println("Bravo ! vous avez gagné !!!");

        do {
            System.out.println("Souhaitez-vous rejouer O/N?");
            Scanner sc2 = new Scanner(System.in);
            reponse = sc2.nextLine();
            reponse = reponse.toUpperCase();

            if (!reponse.equals ("O") && !reponse.equals ("N")) {
                System.out.println("Vous n'avez pas saisi un caractère valide !");
            }else {
            }
        }
        while(!reponse.equals("O") && !reponse.equals("N"));
    }
        while (reponse.equals("O"));
    }
}
