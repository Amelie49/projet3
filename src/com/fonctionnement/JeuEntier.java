package com.fonctionnement;


import com.niveaux.Duel;
import ressources.Configuration;
import com.niveaux.Challenger;
import com.niveaux.Defenseur;
import org.apache.log4j.Logger;


import java.util.Scanner;

public class JeuEntier {

    final static Configuration configuration = new Configuration();
    final static int nbEssais = configuration.getNbEssais();
    MethodesRepetitives methodesRepetitives = new MethodesRepetitives();
    Challenger challenge = new Challenger();
    Defenseur defenseur = new Defenseur();
    Duel duel = new Duel();

final static Logger log = Logger.getLogger(JeuEntier.class);

    public void annoncerNiveaux() {/*annonce la règle du jeu et chaque niveau*/

        /*Afficher les regles du jeu*/


        log.info("Votre mission si vous l'acceptez est de sortir de cette pièce.");
        log.info("Pour celà vous devez vaincre l'ordinateur.");
        log.info("Vous avez "  + nbEssais + " essais. Passé ce nombre, vous aurez perdu.");
        log.info("Vous avez le choix entre différents mode : challenge, défenseur et duel.");
        log.info("Choix du niveau");
        log.info("1- challenge : vous devez deviner le code secret de l'ordinateur");
        log.info("2- défenseur : l'ordinateur va à son tour essayer de deviner votre code");
        log.info("3- duel : vous devez deviner le code de l'ordinateur avant que celui-ci ne devine le votre");
    }


    public String lancerNiveauSelectionne() { /* Afficher niveau sélectionné et lancer le niveau demandé*/

        String nbLevel;

        int i;
        String reponse;

    do {
        log.info("Quel niveau choisissez-vous ?");
        Scanner sc = new Scanner(System.in);
        nbLevel = sc.nextLine();

        switch (nbLevel) {

            case "1":/*si le joueur choisi le niveau 1, lancer le niveau challenger*/
                log.info("Vous avez choisi le niveau challenge");
                methodesRepetitives.vainqueurOuPerdant(challenge.jeu());
                break;
            case "2":/*si le joueur choisi le niveau 2, lancer le niveau challenger*/
                log.info("Vous avez choisi le niveau défenseur");
                methodesRepetitives.vainqueurOuPerdant(defenseur.jeu());
                break;
            case "3":/*si le joueur choisi le niveau 3, lancer le niveau challenger*/
                log.info("Vous avez choisi le niveau duel");
                methodesRepetitives.vainqueurOuPerdant(duel.jeu());
                break;
            default:/*si le joueur n'a pas chosi un niveau cite lui redemander une saisie*/
                log.debug("Vous n'avez pas choisi de niveau parmi ceux proposés. Veuillez réitérer votre choix");
                break;

        }

    }
            while(!nbLevel.equals("1") && !nbLevel.equals("2") && !nbLevel.equals("3"));

        return nbLevel;
    }



    public String rejouer(String niveau) { /* Demander au joueur s'il souhaite rejouer*/

        String reponse;

        do {
            log.info("Si vous souhaitez rejouer au même niveau tapez 1");
            log.info("Si vous souhaitez rejouer à un autre niveau tapez 2");
            log.info("Si vous souhaitez quitter le jeu tapez 3");

            Scanner sc2 = new Scanner(System.in);
            reponse = sc2.nextLine();
            reponse = reponse.toUpperCase();/*selon les elements ci-dessus demander au joueur une saisie*/

            if (!reponse.equals ("1") && !reponse.equals ("2") && !reponse.equals ("3")) {
                log.debug("Vous n'avez pas saisi un caractère valide !");/*si valeur non valide*/
            }else if (reponse.equals("1") && niveau.equals("1")) {/*si le joueur choisi de relancer le meme niveau et qu'il s'agit du niveau 1*/
                methodesRepetitives.vainqueurOuPerdant(challenge.jeu());
            }else if (reponse.equals("1") && niveau.equals("2")) {/*si le joueur choisi de relancer le meme niveau et qu'il s'agit du niveau 2*/
                methodesRepetitives.vainqueurOuPerdant(defenseur.jeu());
            }else if (reponse.equals("1") && niveau.equals("3")) {/*si le joueur choisi de relancer le meme niveau et qu'il s'agit du niveau 3*/
                methodesRepetitives.vainqueurOuPerdant(duel.jeu());
            }else if (reponse.equals("2")) {/*si le joueur souhaite rejouer un autre niveau*/
                lancerNiveauSelectionne();
            }else if(reponse.equals("3")) {/*si le joueur souhaite quitter*/
                log.info("Au revoir ! et à Bientôt !");
            }


        }
        while(reponse.equals("1") ||reponse.contentEquals("2") || !reponse.contentEquals("3"));/*relancer si mauvaise saisie*/

        return reponse;
    }

}