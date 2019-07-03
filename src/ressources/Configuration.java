package ressources;


import java.util.ResourceBundle;

public class Configuration {

    private static ResourceBundle bundle = ResourceBundle.getBundle("ressources.config");

    /** nb d'essais*/
    public static int getNbEssais() {
        String nbEssais = bundle.getString("nbEssais");
        return Integer.parseInt(nbEssais);
    }

    /**nb de chiffres que doit contenir le nombre*/
    public static int getLongueurNb () {
        String longueurNb = bundle.getString("longueurNb");
        return Integer.parseInt(longueurNb);
    }

    /**mode developpeur active ou non */
    public static boolean getModeDeveloppeur () {
        String modeDeveloppeur = bundle.getString("modeDeveloppeur");
        return Boolean.parseBoolean(modeDeveloppeur);
    }

}