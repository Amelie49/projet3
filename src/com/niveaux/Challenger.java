package com.niveaux;


import org.apache.log4j.Logger;
import ressources.Configuration;
import com.fonctionnement.DeroulementJeu;
import com.fonctionnement.MethodesRepetitives;

import java.util.Scanner;

public class Challenger implements DeroulementJeu {

    /**Valeurs reprises de la classe configuration*/
    final static int longueurNb = Configuration.getLongueurNb();
    final static int nbEssais = Configuration.getNbEssais();
    final static boolean modeDeveloppeur = Configuration.getModeDeveloppeur();

    /**Méthodes reprises de la classe methodesrepetitives*/
    final static Logger log = Logger.getLogger(Challenger.class);

    /**générer code aléatoire*/
    public String nbMystere() {

        String nbInconnu = MethodesRepetitives.genererCodeAleatoire();

        /**Afficher nb mystere selon mode developpeur actif ou non*/
        if (modeDeveloppeur) {
            log.info("Combinaison secrète du Joueur : " + nbInconnu);
        } else {
        }
        return nbInconnu;
    }


    /**Vérifier si la saisie du joueur est bien un nombre à tant de chiffres*/
    public String proposition() {

        String nb;
        int i = 0;
        boolean vf;

        do {
            log.info("Proposition Joueur :");

            Scanner sc = new Scanner(System.in);
            nb = sc.nextLine();
            vf = true;
            vf = MethodesRepetitives.siEstUnNombreABonNombreDeChiffres(vf, nb);

        }
        while (!vf  || nb.length() != longueurNb);

        return nb;
    }


    /**boucle la méthode qui fait tourner le niveau en entier*/
    public boolean jeu() {

        String resultcomp = "";
        int k;
        String reponse;
        String nbOrdi = nbMystere();/**definir nb a trouver*/
        String nbJoueur = proposition();/**demande au joueur de saisir un nombre*/
        boolean victoire = false;
        String goodResult = MethodesRepetitives.bonResultat();



        for (k = 1; !victoire && k <= nbEssais; k++) {/**une boucle qui tourne tant que le joueur n'a pas trouve le nb, et tant qu'on a pas atteind le nb limite d'essais*/
            resultcomp = MethodesRepetitives.compare(nbOrdi, nbJoueur);/**lancer la comparaison des valeur*/
            log.info(" -> Réponse Joueur : " + resultcomp);/**afficher les symboles de comparaison*/

            if (resultcomp.equals(goodResult)) {/**si la saisie du joueur correspond au nb mystere alors victoire */
                victoire = true;
            } else if (k < nbEssais) { /**sinon relancer methode de saisie du joueur*/
                nbJoueur = proposition();
            }

        }
        log.info("Le nombre mystère est : " + nbOrdi);/**arrivee au dernier essai afficher le nb qu'il fallait trouver*/

        return victoire;

    }
}