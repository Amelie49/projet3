package com.main;


import com.fonctionnement.JeuEntier;

public class Main{

    /**afficher la regle du jeu*/
    /**lancer le jeu avec tous les niveaux et si le joueur souhaite rejouer*/
    public static void main(String[] args) {

        JeuEntier jeuEntier = new JeuEntier();

        /**afficher la regle du jeu*/
        jeuEntier.annoncerNiveaux();

        /**lancer le jeu avec tous les niveaux et si le joueur souhaite rejouer*/
        jeuEntier.rejouer(jeuEntier.lancerNiveauSelectionne());
    }
}

