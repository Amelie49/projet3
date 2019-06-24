package com.niveaux;

import ressources.Configuration;
import com.fonctionnement.MethodesRepetitives;


public class Duel {
    static Configuration configuration = new Configuration();
    static int nbEssais = configuration.getNbEssais();
    Challenger challenge = new Challenger();
    Defenseur defenseur = new Defenseur();

    MethodesRepetitives methodesRepetitives = new MethodesRepetitives();

    public boolean jeu() {  /*Permet de lancer le mode duel selon les modes defenseur et challenge*/
        int l;

        String compJoueur = "";
        String compOrdi = "";
        String reponse;

        boolean victoireJoueur = false;
        boolean victoireOrdi = false;
        String mystJoueur = challenge.nbMystere();   /*nb que le joueur doit trouver*/
        String mystOrdi = defenseur.nbMystere();       /*nb que l'ordinateur doit trouver*/
        String propOrdi = defenseur.proposition();  /*ordinateur genere un code aleatoire en premiere proposition*/
        System.out.println("Proposition ordinateur : " + propOrdi);   /*afficher proposition ordinateur*/
        String propJoueur = "";

        for (l = 1; victoireJoueur == false && victoireOrdi == false && l <= nbEssais; l++) {   /*si ni le joueur ou l'ordinateur n'ont gagne et si le nombre d'essais n'est pas atteind, relancer*/

            compOrdi = methodesRepetitives.compare(mystOrdi, propOrdi); /*lancer la methode de comparaison du niveau defenseur*/
            System.out.println("Reponse Ordinateur :" + compOrdi);  /*afficher la comparaison*/
            propJoueur = challenge.proposition();    /*demander une saisie au joueur selon le mode challenger*/
            compJoueur = methodesRepetitives.compare(mystJoueur, propJoueur); /*comparer selon le mode challenger*/
            System.out.println("Reponse Joueur :" + compJoueur);   /*afficher la comparaison*/

            if (compOrdi.equals("====")) { /*si l'ordinateur a gagne, changement de la valeur victoireOrdi*/
                victoireOrdi = true;
            }else if(compJoueur.equals("====")) {/*si le joueur a gagne changement de la valeur victoireJoeur*/
                victoireJoueur = true;
            } else if (l < nbEssais) {  /*sinon redemander un code a l'ordinateur selon les symboles de comparaison*/
                propOrdi = defenseur.ajuste(propOrdi, compOrdi);
                System.out.println("Proposition Ordinateur :" + propOrdi);
            }
        }

        if (victoireOrdi == true || victoireJoueur == false)/*si l'ordinateur ou le joueur perdent alors perdu sinon gagne*/
            victoireJoueur = false;
        else
            victoireJoueur = true;

        return victoireJoueur;


    }
}

