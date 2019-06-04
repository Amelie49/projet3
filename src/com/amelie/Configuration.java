package com.amelie;

public class Configuration {


    private int longueurJeu = 4;

    private int nbEssais = 5;

    private boolean modeDeveloppeur = false;

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