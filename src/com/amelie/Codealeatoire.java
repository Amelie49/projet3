package com.amelie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Codealeatoire {

    public Integer code;

    static Configuration configuration = new Configuration();
    static int intervalRandom = (int) Math.pow (10,configuration.getLongueurJeu());
    int nbEssais = configuration.getNbEssais();

    /** Générer le code aléatoire en int
     */
    public int genererCodeAleatoire () {
        Random r = new Random();
        code = r.nextInt(intervalRandom);
        return code;
    }
}
