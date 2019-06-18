package com.amelie;

public class Configuration {
    private int longueurJeu = 4; /* nb de chiffres que doit contenir le nombre*/

    private int nbEssais = 5;/* nb d'essais possible*/

    private boolean modeDeveloppeur = true; /*si true permet d'afficher le code mystere*/

    public int getLongueurJeu () {
        return longueurJeu;
    }

    public int getNbEssais () {
        return nbEssais;
    }

    public boolean getModeDeveloppeur () {
        return modeDeveloppeur;
    }
}