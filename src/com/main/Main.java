package com.main;


import com.fonctionnement.JeuEntier;
import com.niveaux.Challenger;


public class Main{


    public static void main(String[] args) {

        Challenger challenge = new Challenger();
        JeuEntier jeuEntier = new JeuEntier();


        jeuEntier.annoncerNiveaux();/*afficher la regle du jeu*/
        jeuEntier.rejouer(jeuEntier.lancerNiveauSelectionne());/*lancer le jeu avec tous les niveaux et si le joueur souhaite rejouer*/
    }
}

