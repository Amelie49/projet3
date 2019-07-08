package com.niveaux;


import org.apache.log4j.Logger;
import ressources.Configuration;
import com.fonctionnement.DeroulementJeu;
import com.fonctionnement.MethodesRepetitives;

import java.util.Scanner;


public class Defenseur implements DeroulementJeu {

    /**Appeler valeur de la classe configuration*/
    final static int longueurNb = Configuration.getLongueurNb();/**recuperer longueur du nb*/
    final static int nbEssais = Configuration.getNbEssais();/**recuperer nb essais*/

    /**Appeler méthodes de la classe méthodesrépétitives*/
    MethodesRepetitives methodesRepetitives = new MethodesRepetitives();
    final static Logger log = Logger.getLogger(Defenseur.class);

    /**Demande au joueur la saisie du nombre que l'ordinateur doit deviner et controle le format*/
    public String nbMystere() {

        boolean vf;
        String nb = new String();
        int i = 0;

        do {/**Vérifie si bien un int à 4 chiffres*/
            log.info("Combinaison secrète de l'Ordinateur : ");

            Scanner sc = new Scanner(System.in);
            nb = sc.nextLine();/**demander une saisie au joueur*/
            vf = true;

            vf = methodesRepetitives.siEstUnNombreABonNombreDeChiffres(vf, nb);

        }
        while (!vf || nb.length() != longueurNb);/**si pas un int à 4 chiffres redemande au joueur de saisir un nombre*/


        return nb;
    }

    /**generer un code aleatoire*/
    public String proposition() {
        String code = new String();

        code = methodesRepetitives.genererCodeAleatoire();
        return code;
    }

    /**ajuster le code selon retour du compare*/
    public String ajuste(String nb, String compare) {
        String res = new String();
        int i;

        for (i = 0; i < longueurNb; i++) {/**incremente ou decremente selon <,>,=*/

            if (compare.charAt(i) == '>') {
                res = res + (char) (nb.charAt(i) + 1);

            } else if (compare.charAt(i) == '<') {

                res = res + (char) (nb.charAt(i) - 1);

            } else {
                res = res + (char) (nb.charAt(i));
            }
        }
        return res;
    }

    /** boucle qui fait tourner le jeu defenseur*/
    public boolean jeu() {

        String resultcomp = "";
        int k;
        String reponse;

        String nbJoueur = nbMystere();/**demande au joueur de saisir le nb que l'ordinateur doit trouver*/
        String nbOrdi = proposition();/**valeur aleatoire donnee par l'ordinateur*/
        boolean victoireNiveau = false;
        boolean victoireOrdi = false;
        String goodResult = methodesRepetitives.bonResultat();

        log.info("Proposition ordinateur : " + nbOrdi);/**affiche la valeur que l'ordinateur propose*/

        for (k = 1; !victoireOrdi && k <= nbEssais; k++) {

            resultcomp = methodesRepetitives.compare(nbJoueur, nbOrdi);/**compare la valeur de l'ordinateur avec celle du joueur*/
            log.info(" -> Réponse Ordinateur : " + resultcomp);/** affiche les symboles de comparaion*/

            if (resultcomp.equals(goodResult)) {/**si les symboles correspondent a ==== alors victoire correspond a vrai*/
                victoireOrdi = true;
            } else if (k < nbEssais) {/**si le nb d'essais final n'est pas atteind, redemander un nb a l'ordinateur et relancer la comparaison*/
                nbOrdi = ajuste(nbOrdi, resultcomp);
                log.info("Proposition Ordinateur : " + nbOrdi);
            }
        }
        if (victoireOrdi)/**si l'ordinateur trouve le code le joueur a perdu sinon il a gagne*/
            victoireNiveau = false;
        else
            victoireNiveau = true;

        return victoireNiveau;

    }
}