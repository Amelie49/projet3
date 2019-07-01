package com.niveaux;

import org.apache.log4j.Logger;
import ressources.Configuration;
import com.fonctionnement.MethodesRepetitives;


public class Duel {
    final static Configuration configuration = new Configuration();
    final static int nbEssais = configuration.getNbEssais();
    Challenger challenge = new Challenger();
    Defenseur defenseur = new Defenseur();

    MethodesRepetitives methodesRepetitives = new MethodesRepetitives();
    final static Logger log = Logger.getLogger(Duel.class);

    public boolean jeu() {  /*Permet de lancer le mode duel selon les modes defenseur et challenge*/
        int k;

        String compJoueur = "";
        String compOrdi = "";
        String reponse;

        boolean victoireJoueur = false;
        boolean victoireOrdi = false;
        String mystJoueur = challenge.nbMystere();   /*nb que le joueur doit trouver*/
        String mystOrdi = defenseur.nbMystere();       /*nb que l'ordinateur doit trouver*/
        String propOrdi = defenseur.proposition();  /*ordinateur genere un code aleatoire en premiere proposition*/
        log.info("Proposition ordinateur : " + propOrdi);   /*afficher proposition ordinateur*/
        String propJoueur = "";
        String goodResult = methodesRepetitives.goodResult();


        for (k = 1; victoireJoueur == false && victoireOrdi == false && k <= nbEssais; k++) {   /*si ni le joueur ou l'ordinateur n'ont gagne et si le nombre d'essais n'est pas atteind, relancer*/

            compOrdi = methodesRepetitives.compare(mystOrdi, propOrdi); /*lancer la methode de comparaison du niveau defenseur*/
            log.info("Reponse Ordinateur :" + compOrdi);  /*afficher la comparaison*/
            propJoueur = challenge.proposition();    /*demander une saisie au joueur selon le mode challenger*/
            compJoueur = methodesRepetitives.compare(mystJoueur, propJoueur); /*comparer selon le mode challenger*/
            log.info("Reponse Joueur :" + compJoueur);   /*afficher la comparaison*/

            if (compOrdi.equals(goodResult)) { /*si l'ordinateur a gagne, changement de la valeur victoireOrdi*/
                victoireOrdi = true;
            }else if(compJoueur.equals(goodResult)) {/*si le joueur a gagne changement de la valeur victoireJoeur*/
                victoireJoueur = true;
            } else if (k < nbEssais) {  /*sinon redemander un code a l'ordinateur selon les symboles de comparaison*/
                propOrdi = defenseur.ajuste(propOrdi, compOrdi);
                log.info("Proposition Ordinateur :" + propOrdi);
            }
        }

        if (victoireOrdi == true || victoireJoueur == false)/*si l'ordinateur ou le joueur perdent alors perdu sinon gagne*/
            victoireJoueur = false;
        else
            victoireJoueur = true;

        return victoireJoueur;


    }
}

