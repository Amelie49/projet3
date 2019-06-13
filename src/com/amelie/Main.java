package com.amelie;

import java.util.concurrent.ConcurrentMap;

public class Main {

    public static void main(String[] args) {
        Annonceniveaux Annonceniveaux = new Annonceniveaux();
        Annonceniveaux.afficherLesNiveaux();

Challenge Challenge = new Challenge();
        Defenseur Defenseur = new Defenseur();
        Defenseur.nbMystere();
        String s = Defenseur.nbMystere();
        String a = Defenseur.codeAleatoire();
        String b = Defenseur.jeuTourneUneFois(s,a);
        Defenseur.boucle(s,a,b);

    }
}